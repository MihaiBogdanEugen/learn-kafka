package ro.mbe.learn.kafka.commons;

import org.apache.kafka.common.TopicPartition;

import java.util.*;
import java.util.stream.Collectors;

public class Setup {

    public static final String[] KafkaServers = new String[] {
            "localhost:19101",
            "localhost:19102",
            "localhost:19103"
    };

    public static final Map<String, List<Integer>> TopicsAndPartitions = new HashMap<>();
    static {
        TopicsAndPartitions.put("sensors.first", Arrays.asList(0));
        TopicsAndPartitions.put("sensors.second", Arrays.asList(0, 1));
        TopicsAndPartitions.put("sensors.third", Arrays.asList(0, 1, 2));
    }

    static Collection<String> getAllTopics() {
        return TopicsAndPartitions.keySet();
    }

    static Collection<TopicPartition> getAllPartitions() {
        return Setup.TopicsAndPartitions.entrySet()
                .stream()
                .flatMap(entry -> entry.getValue()
                        .stream()
                        .map(partition -> new TopicPartition(entry.getKey(), partition)))
                .collect(Collectors.toList());
    }
}

