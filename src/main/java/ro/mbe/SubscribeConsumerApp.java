package ro.mbe;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Properties;
import java.util.UUID;

import ro.mbe.custom.Message;

public class SubscribeConsumerApp  {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubscribeConsumerApp.class);
    private static final String PatternPrintRecord = "Message with offset %d, received from topic %s, partition %d, with value: [%s]";

    public static void main(String[] args) {

        String clientId = (args != null && args.length > 0 && args[0].length() > 0) ? args[0] : UUID.randomUUID().toString();
        String groupId = (args != null && args.length > 1 && args[1].length() > 0) ? args[1] : UUID.randomUUID().toString();
        Properties properties = Configuration.getConsumerConfig(clientId, groupId);

        try (KafkaConsumer<String, Message> consumer = new KafkaConsumer<>(properties)) {

            Collection<String> topics = Configuration.getAllTopics();
            consumer.subscribe(topics);

            int counterMessagesReceived = 0;

            while (true) {

                ConsumerRecords<String, Message> records =  consumer.poll(Configuration.PollingTimeout);
                for (ConsumerRecord<String, Message> record : records) {

                    LOGGER.info(String.format(PatternPrintRecord, record.offset(), record.topic(), record.partition(), record.value().toString()));
                    counterMessagesReceived++;
                }

                if (counterMessagesReceived >= Configuration.NoOfRecordsToReceive) {
                    break;
                }
            }

            consumer.unsubscribe();

        } catch (Exception error) {
            LOGGER.error(error.getMessage(), error);
        }
    }
}