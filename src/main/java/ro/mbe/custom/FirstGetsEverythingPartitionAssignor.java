package ro.mbe.custom;

import org.apache.kafka.clients.consumer.internals.AbstractPartitionAssignor;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.utils.CircularIterator;
import org.apache.kafka.common.utils.Utils;

import java.util.*;

public class FirstGetsEverythingPartitionAssignor extends AbstractPartitionAssignor {

    /**
     * Perform the group assignment given the partition counts and member subscriptions
     *
     * @param partitionsPerTopic The number of partitions for each subscribed topic.
     *                           Topics not in metadata will be excluded from this map.
     * @param subscriptions Map from the memberId to their respective topic subscription
     * @return Map from each member to the list of partitions assigned to them.
     */
    @Override
    public Map<String, List<TopicPartition>> assign(Map<String, Integer> partitionsPerTopic, Map<String, Subscription> subscriptions) {

        Map<String, List<TopicPartition>> assignment = new HashMap<>();

        for (Map.Entry<String, Subscription> subscription : subscriptions.entrySet()) {

            String memberId = subscription.getKey();
            assignment.put(memberId, new ArrayList<>());

            for (Map.Entry<String, Integer> partitionPerTopic : partitionsPerTopic.entrySet()) {

                int noOfPartitions = partitionPerTopic.getValue();
                for (int partition = 0; partition < noOfPartitions; partition++) {
                    assignment.get(memberId).add(new TopicPartition(partitionPerTopic.getKey(), partition));
                }
            }

            break;
        }

        return assignment;
    }

    /**
     * Unique name for this assignor (e.g. "range" or "roundrobin" or "sticky")
     *
     * @return non-null unique name
     */
    @Override
    public String name() {
        return "first-gets-everything";
    }

}
