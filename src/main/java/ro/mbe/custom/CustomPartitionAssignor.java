package ro.mbe.custom;

import org.apache.kafka.clients.consumer.internals.AbstractPartitionAssignor;
import org.apache.kafka.common.TopicPartition;

import java.util.List;
import java.util.Map;

public class CustomPartitionAssignor extends AbstractPartitionAssignor {

    /**
     * Perform the group assignment given the partition counts and member subscriptions
     *
     * @param partitionsPerTopic The number of partitions for each subscribed topic. Topics not in metadata will be excluded
     *                           from this map.
     * @param subscriptions      Map from the memberId to their respective topic subscription
     * @return Map from each member to the list of partitions assigned to them.
     */
    @Override
    public Map<String, List<TopicPartition>> assign(Map<String, Integer> partitionsPerTopic, Map<String, Subscription> subscriptions) {
        return null;
    }

    @Override
    public String name() {
        return "custom";
    }

}
