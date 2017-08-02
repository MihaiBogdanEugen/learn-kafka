package ro.mbe;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.mbe.common.KafkaConfig;
import ro.mbe.common.Setup;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

public class SimpleProducerApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleProducerApp.class);

    private static final String PATTERN_RECORD_SENT = "Message with offset %d, sent to topic %s, on partition %d";

    public static void main(String[] args) {

        String clientId = (args != null && args.length > 0 && args[0].length() > 0)
                ? args[0]
                : UUID.randomUUID().toString();

        Properties properties = getProducerProperties(clientId);

        try (KafkaProducer<String, String> producer = new KafkaProducer<>(properties)) {
            for (int index = 0; index < Setup.NoOfRecordsToSend; index ++) {
                for (Map.Entry<String, List<Integer>> entry : Setup.TopicsAndPartitions.entrySet()) {

                    int noOfPartitions = entry.getValue().size();

                    String topic = entry.getKey();
                    Integer partition = index % noOfPartitions;
                    String key = UUID.randomUUID().toString();
                    String value = UUID.randomUUID().toString();

                    ProducerRecord<String, String> record = (noOfPartitions == 1)
                            ? new ProducerRecord<>(topic, key, value)
                            : new ProducerRecord<>(topic, partition, key, value);

                    producer.send(record, (metadata, error) -> {

                        if (error == null) {
                            LOGGER.info(String.format(PATTERN_RECORD_SENT,
                                    metadata.offset(), metadata.topic(), metadata.partition()));
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
        properties.put(KafkaConfig.Producer.BOOTSTRAP_SERVERS, String.join(", ", Setup.KafkaServers));
        properties.put(KafkaConfig.Producer.KEY_SERIALIZER, StringSerializer.class.getName());
        properties.put(KafkaConfig.Producer.VALUE_SERIALIZER, StringSerializer.class.getName());
        properties.put(KafkaConfig.Producer.CLIENT_ID, clientId);
        return properties;
    }
}
