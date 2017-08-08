package ro.mbe.learn.kafka.producers;

import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.mbe.learn.kafka.commons.KafkaConfig;
import ro.mbe.learn.kafka.commons.Setup;
import ro.mbe.learn.kafka.custom.MessageJsonSerializer;

import java.util.Properties;

public class TransactionalProducerApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionalProducerApp.class);

    public static void main(String[] args) {

        System.out.println("DONE!");
    }
}
