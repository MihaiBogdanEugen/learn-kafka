package ro.mbe;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class ProducerApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerApp.class);

    private static final String PatternMessage = "Message #%d: %s, sent at %tF %tT";
    private static final String PatternRecordSent = "Message with offset %d, sent to topic %s, on partition %d";

    public static void main(String[] args) {

        String clientId = (args != null && args.length > 0 && args[0].length() > 0) ? args[0] : UUID.randomUUID().toString();

        Properties properties = Configuration.getProducerConfig(clientId);

        try (KafkaProducer<String, String> producer = new KafkaProducer<>(properties)) {

            for (int index = 0; index < Configuration.NoOfRecordsToSend; index ++) {

                for (Map.Entry<String, List<Integer>> entry : Configuration.TopicsAndPartitions.entrySet()) {

                    String topic = entry.getKey();
                    int noOfPartitions = entry.getValue().size();

                    Date now = new Date();
                    String message = String.format(PatternMessage, index, UUID.randomUUID().toString(), now, now);

                    ProducerRecord<String, String> record = (noOfPartitions == 1)
                            ? new ProducerRecord<>(topic, null, message)
                            : new ProducerRecord<>(topic, index % noOfPartitions, null, message);

                    producer.send(record, (metadata, error) -> {

                        if (error == null) {
                            LOGGER.info(String.format(PatternRecordSent, metadata.offset(), metadata.topic(), metadata.partition()));
                        } else {
                            LOGGER.error(error.getMessage(), error);
                        }
                    });
                }
            }
        } catch (Exception error) {
            LOGGER.error(error.getMessage(), error);
        }
    }
}
