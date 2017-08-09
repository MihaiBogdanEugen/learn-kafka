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
import ro.mbe.learn.kafka.custom.Message;
import ro.mbe.learn.kafka.custom.MessageJsonSerializer;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

public class TransactionalProducerApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionalProducerApp.class);

    public static void main(String[] args) {

        String clientId = (args != null && args.length > 0 && args[0].length() > 0)
                ? args[0]
                : UUID.randomUUID().toString();

        String transactionalId = UUID.randomUUID().toString();

        Properties properties = getProducerProperties(clientId, transactionalId);

        try (KafkaProducer<String, Message> producer = new KafkaProducer<>(properties)) {

            producer.initTransactions();
            producer.beginTransaction();

            for (int index = 0; index < Constants.NoOfRecordsToSend; index ++) {

                if ((index + 1) % Constants.NoOfRecordsInTransaction == 0) {
                    LOGGER.info("Commiting transaction...");
                    producer.commitTransaction();
                    producer.beginTransaction();
                }

                for (Map.Entry<String, List<Integer>> entry : Setup.TopicsAndPartitions.entrySet()) {

                    int noOfPartitions = entry.getValue().size();

                    String topic = entry.getKey();
                    Integer partition = index % noOfPartitions;
                    String key = UUID.randomUUID().toString();
                    Message value = new Message(index, UUID.randomUUID().toString());

                    ProducerRecord<String, Message> record = (noOfPartitions == 1)
                            ? new ProducerRecord<>(topic, key, value)
                            : new ProducerRecord<>(topic, partition, key, value);

                    producer.send(record, (RecordMetadata metadata, Exception error) -> {

                        if (error == null) {
                            LOGGER.info(String.format(Constants.PATTERN_RECORD_SENT, metadata.offset(), metadata.topic(), metadata.partition()));
                        } else {
                            LOGGER.error(error.getMessage(), error);
                            producer.abortTransaction();
                        }
                    });
                }
            }

            producer.commitTransaction();

        } catch (Exception error) {
            LOGGER.error(error.getMessage(), error);
        }

        System.out.println("DONE!");
    }

    private static Properties getProducerProperties(String clientId, String transactionalId) {

        Properties properties = new Properties();
        properties.put(KafkaConfig.Producer.BOOTSTRAP_SERVERS, String.join(", ", Setup.KafkaServers));
        properties.put(KafkaConfig.Producer.KEY_SERIALIZER, StringSerializer.class.getName());
        properties.put(KafkaConfig.Producer.VALUE_SERIALIZER, MessageJsonSerializer.class.getName());
        properties.put(KafkaConfig.Producer.CLIENT_ID, clientId);
        properties.put(KafkaConfig.Producer.TRANSACTIONAL_ID, transactionalId);
        return properties;
    }
}