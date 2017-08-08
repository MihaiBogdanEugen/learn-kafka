package ro.mbe.learn.kafka.custom;

import com.google.gson.Gson;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import ro.mbe.learn.kafka.commons.KafkaConfig;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class MessageJsonSerializer implements Serializer<Message> {

    private static final Gson GSON = new Gson();

    private String encoding = "UTF8";

    /**
     * Convert {@code data} into a byte array.
     *
     * @param topic topic associated with data
     * @param data typed data
     * @return serialized bytes
     */
    @Override
    public byte[] serialize(String topic, Message data) {

        if (data == null) {
            return new byte[0];
        }

        try {
            String messageAsString = GSON.toJson(data);
            return messageAsString.getBytes(this.encoding);
        } catch (UnsupportedEncodingException e) {
            throw new SerializationException("Error when serializing JSON string to byte[] due to unsupported UTF-8 encoding");
        }
    }

    /**
     * Configure this class.
     *
     * @param configs configs in key/value pairs
     * @param isKey whether is for key or value
     */
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

        Object encodingValue = configs.get(isKey
                ? KafkaConfig.Producer.KEY_SERIALIZER + ".encoding"
                : KafkaConfig.Producer.VALUE_SERIALIZER + ".encoding");

        if (encodingValue == null) {
            encodingValue = configs.get("serializer.encoding");
        }

        if (encodingValue == null) {
            encodingValue = configs.get("deserializer.encoding");
        }

        if (encodingValue != null && encodingValue instanceof String) {
            this.encoding = (String) encodingValue;
        }
    }

    /**
     * Close this serializer.
     *
     * This method must be idempotent as it may be called multiple times.
     */
    @Override
    public void close() {
        //do nothing
    }
}
