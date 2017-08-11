package ro.mbe.learn.kafka.producers;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.mbe.learn.kafka.commons.Constants;
import ro.mbe.learn.kafka.commons.KafkaConfig;
import ro.mbe.learn.kafka.commons.Setup;
import ro.mbe.learn.kafka.custom.MessageJsonSerializer;
import ro.mbe.learn.kafka.custom.Message;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

public class CustomBatchingProducerApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomBatchingProducerApp.class);

    public static void main(String[] args) {

        String clientId = (args != null && args.length > 0 && args[0].length() > 0)
                ? args[0]
                : UUID.randomUUID().toString();

        Properties properties = getProducerProperties(clientId);

        try (KafkaProducer<String, Message> producer = new KafkaProducer<>(properties)) {
            for (int index = 0; index < Constants.NoOfRecordsToSend; index ++) {
                for (Map.Entry<String, List<Integer>> entry : Setup.TopicsAndPartitions.entrySet()) {

                    int noOfPartitions = entry.getValue().size();

                    String topic = entry.getKey();
                    Integer partition = index % noOfPartitions;
                    String key = UUID.randomUUID().toString();
                    Message value = new Message(index, new String(new byte[1024], StandardCharsets.UTF_8));

                    ProducerRecord<String, Message> record = (noOfPartitions == 1)
                            ? new ProducerRecord<>(topic, key, value)
                            : new ProducerRecord<>(topic, partition, key, value);

                    producer.send(record, (RecordMetadata metadata, Exception error) -> {

                        if (error == null) {
                            LOGGER.info(String.format(Constants.PATTERN_RECORD_SENT, metadata.offset(), metadata.topic(), metadata.partition()));
                        } else {
                            LOGGER.error(error.getMessage(), error);
                        }
                    });
                }
            }
        } catch (Exception error) {
            LOGGER.error(error.getMessage(), error);
        }

        System.out.println("DONE!");
    }

    private static Properties getProducerProperties(String clientId) {

        Properties properties = new Properties();

        /**
         * A list of host/port pairs to use for establishing the initial connection to the Kafka cluster. The client will
         * make use of all servers irrespective of which servers are specified here for bootstrapping—this list only
         * impacts the initial hosts used to discover the full set of servers. This list should be in the form
         * host1:port1,host2:port2,.... Since these servers are just used for the initial connection to discover the full
         * cluster membership (which may change dynamically), this list need not contain the full set of servers (you
         * may want more than one, though, in case a server is down).
         */
        properties.put(KafkaConfig.Producer.BOOTSTRAP_SERVERS, String.join(", ", Setup.KafkaServers));

        /**
         * Serializer class for key that implements the Serializer interface.
         */
        properties.put(KafkaConfig.Producer.KEY_SERIALIZER, StringSerializer.class.getName());

        /**
         * Serializer class for value that implements the Serializer interface.
         */
        properties.put(KafkaConfig.Producer.VALUE_SERIALIZER, MessageJsonSerializer.class.getName());

        /**
         * An id string to pass to the server when making requests. The purpose of this is to be able to track the source
         * of requests beyond just ip/port by allowing a logical application name to be included in server-side request
         * logging.
         */
        properties.put(KafkaConfig.Producer.CLIENT_ID, clientId);

        /**
         * Custom setting: Tells the MessageJsonSerializer what encoding to use for GSON serialization
         */
        properties.put(KafkaConfig.Producer.VALUE_SERIALIZER + ".encoding", "UTF8");

        /**
         * The maximum size of a request in bytes. This setting will limit the number of record batches the producer
         * will send in a single request to avoid sending huge requests. This is also effectively a cap on the maximum
         * record batch size. Note that the server has its own cap on record batch size which may be different from this.
         */
        properties.put(KafkaConfig.Producer.MAX_REQUEST_SIZE, 33554432);    // 32 MB

        /**
         * The producer will attempt to batch records together into fewer requests whenever multiple records are being
         * sent to the same partition. This helps performance on both the client and the server. This configuration
         * controls the default batch size in bytes.
         *
         * No attempt will be made to batch records larger than this size.
         *
         * Requests sent to brokers will contain multiple batches, one for each partition with data available to be sent.
         *
         * A small batch size will make batching less common and may reduce throughput (a batch size of zero will disable
         * batching entirely). A very large batch size may use memory a bit more wastefully as we will always allocate
         * a buffer of the specified batch size in anticipation of additional records.
         */
        properties.put(KafkaConfig.Producer.BATCH_SIZE, 4194304);           // 4 MB

        /**
         * The total bytes of memory the producer can use to buffer records waiting to be sent to the server. If records
         * are sent faster than they can be delivered to the server the producer will block for max.block.ms after which
         * it will throw an exception.
         *
         * This setting should correspond roughly to the total memory the producer will use, but is not a hard bound
         * since not all memory the producer uses is used for buffering. Some additional memory will be used for
         * compression (if compression is enabled) as well as for maintaining in-flight requests.
         */
        properties.put(KafkaConfig.Producer.BUFFER_MEMORY, 16777216);       // 16 MB

        /**
         * The configuration controls how long KafkaProducer.send() and KafkaProducer.partitionsFor() will block.These
         * methods can be blocked either because the buffer is full or metadata unavailable.Blocking in the
         * user-supplied serializers or partitioner will not be counted against this timeout.
         */
        properties.put(KafkaConfig.Producer.MAX_BLOCK_MS, 30000);           // 30 seconds

        /**
         * The producer groups together any records that arrive in between request transmissions into a single batched
         * request. Normally this occurs only under load when records arrive faster than they can be sent out. However
         * in some circumstances the client may want to reduce the number of requests even under moderate load. This
         * setting accomplishes this by adding a small amount of artificial delay—that is, rather than immediately
         * sending out a record the producer will wait for up to the given delay to allow other records to be sent so
         * that the sends can be batched together. This can be thought of as analogous to Nagle's algorithm in TCP.
         * This setting gives the upper bound on the delay for batching: once we get batch.size worth of records for a
         * partition it will be sent immediately regardless of this setting, however if we have fewer than this many
         * bytes accumulated for this partition we will 'linger' for the specified time waiting for more records to
         * show up. This setting defaults to 0 (i.e. no delay). Setting linger.ms=5, for example, would have the effect
         * of reducing the number of requests sent but would add up to 5ms of latency to records sent in the absense of
         * load.
         */
        properties.put(KafkaConfig.Producer.LINGER_MS, 60000);              // 60 seconds

        return properties;
    }
}