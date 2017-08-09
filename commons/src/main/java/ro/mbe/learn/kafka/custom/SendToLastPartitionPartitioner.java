package ro.mbe.learn.kafka.custom;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;

import java.util.Map;

/**
 * Simple partitioner that sends anything to the last available topic partition.
 * If this is not used for (key.type=String.class,value.type=Message.class), then it returns the default (zero) partition.
 *
 */
public class SendToLastPartitionPartitioner implements Partitioner {

    public int defaultPartitionerPartitionValue = 0;

    /**
     * Compute the partition for the given record.
     *
     * @param topic The topic name
     * @param key The key to partition on (or null if no key)
     * @param keyBytes serialized key to partition on (or null if no key)
     * @param value The value to partition on or null
     * @param valueBytes serialized value to partition on or null
     * @param cluster The current cluster metadata
     */
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {

        if (key instanceof String && value instanceof Message) {
            return cluster.partitionsForTopic(topic).stream()
                    .map(PartitionInfo::partition)
                    .max(Integer::compareTo)
                    .orElse(0);
        }

        return this.defaultPartitionerPartitionValue;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

        Object defaultPartitionerPartitionValue = configs.get("default.partitioner.partition.value");

        if (defaultPartitionerPartitionValue != null && defaultPartitionerPartitionValue instanceof Integer) {
            this.defaultPartitionerPartitionValue = (Integer) defaultPartitionerPartitionValue;
        }
    }
}
