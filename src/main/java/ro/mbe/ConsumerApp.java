package ro.mbe;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Properties;
import java.util.UUID;

public class ConsumerApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerApp.class);

    private static final String PatternPrintRecord = "Message with offset %d, received from topic %s, partition %d, with value: [%s]";

    public static void main(String[] args) {

        String clientId = (args != null && args.length > 0 && args[0].length() > 0) ? args[0] : UUID.randomUUID().toString();

        Properties properties = Configuration.getConsumerConfig(clientId, null);
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties)) {

            if (Configuration.UseSubsciptionMethod) {

                Collection<String> topics = Configuration.getAllTopics();
                consumer.subscribe(topics);
            } else {

                Collection<TopicPartition> partitions = Configuration.getAllPartitions();
                consumer.assign(partitions);
            }

            int counterMessagesReceived = 0;

            while (true) {

                //  Overrides the fetch offsets that the consumer will use on the next poll(timeout)}.
                //consumer.seek(new TopicPartition("", 0), 0);

                ConsumerRecords<String, String> records =  consumer.poll(Configuration.PollingTimeout);
                for (ConsumerRecord<String, String> record : records) {

                    LOGGER.info(String.format(PatternPrintRecord, record.offset(), record.topic(), record.partition(), record.value()));

                    counterMessagesReceived++;

                }

                if (counterMessagesReceived >= Configuration.NoOfRecordsToReceive) {
                    break;
                }

//                Object enableAutoCommitObj = properties.get("enable.auto.commit");
//                if (enableAutoCommitObj != null && enableAutoCommitObj instanceof Boolean && !((Boolean)enableAutoCommitObj)) {
//
//                    try {
//                        consumer.commitSync();
//                    } catch (org.apache.kafka.clients.consumer.CommitFailedException error) {
//                        //do smth
//                    }
//
//                    consumer.commitAsync((offsets, errir) -> {
//                       //do smth
//                    });
//                }
            }

            if (Configuration.UseSubsciptionMethod) {
                consumer.unsubscribe();
            }

        } catch (Exception error) {
            LOGGER.error(error.getMessage(), error);
        }
    }
}