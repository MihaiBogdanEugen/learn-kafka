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

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

public class CustomQoSProducerApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomQoSProducerApp.class);

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
                    Message value = new Message(index, "This message can't be lost");

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
         * The number of acknowledgments the producer requires the leader to have received before considering a request
         * complete. This controls the durability of records that are sent. The following settings are allowed:
         *  - acks=0    If set to zero then the producer will not wait for any acknowledgment from the server at all.
         *              The record will be immediately added to the socket buffer and considered sent. No guarantee can
         *              be made that the server has received the record in this case, and the retries configuration will
         *              not take effect (as the client won't generally know of any failures). The offset given back for
         *              each record will always be set to -1.
         *  - acks=1    This will mean the leader will write the record to its local log but will respond without
         *              awaiting full acknowledgement from all followers. In this case should the leader fail immediately
         *              after acknowledging the record but before the followers have replicated it then the record will
         *              be lost.
         *  - acks=all  This means the leader will wait for the full set of in-sync replicas to acknowledge the record.
         *              This guarantees that the record will not be lost as long as at least one in-sync replica remains
         *              alive. This is the strongest available guarantee. This is equivalent to the acks=-1 setting.
         */
        properties.put(KafkaConfig.Producer.ACKS, KafkaConfig.Producer.Acks.ALL);

        /**
         * Setting a value greater than zero will cause the client to resend any record whose send fails with a
         * potentially transient error. Note that this retry is no different than if the client resent the record upon
         * receiving the error. Allowing retries without setting max.in.flight.requests.per.connection to 1 will
         * potentially change the ordering of records because if two batches are sent to a single partition, and the
         * first fails and is retried but the second succeeds, then the records in the second batch may appear first.
         */
        properties.put(KafkaConfig.Producer.RETRIES, 10);

        /**
         * The amount of time to wait before attempting to retry a failed request to a given topic partition.
         * This avoids repeatedly sending requests in a tight loop under some failure scenarios.
         */
        properties.put(KafkaConfig.Producer.RETRY_BACKOFF_MS, 500);

        /**
         * The maximum number of unacknowledged requests the client will send on a single connection before blocking.
         * Note that if this setting is set to be greater than 1 and there are failed sends, there is a risk of message
         * re-ordering due to retries (i.e., if retries are enabled).
         */
        properties.put(KafkaConfig.Producer.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, 1);

        /**
         * When set to 'true', the producer will ensure that exactly one copy of each message is written in the stream.
         * If 'false', producer retries due to broker failures, etc., may write duplicates of the retried message in the
         * stream. This is set to 'false' by default. Note that enabling idempotence requires
         * max.in.flight.requests.per.connection to be set to 1 and retries cannot be zero. Additionally acks must be set
         * to 'all'. If these values are left at their defaults, we will override the default to be suitable. If the
         * values are set to something incompatible with the idempotent producer, a ConfigException will be thrown.
         */
        properties.put(KafkaConfig.Producer.ENABLE_IDEMPOTENCE, true);

        return properties;
    }
}
