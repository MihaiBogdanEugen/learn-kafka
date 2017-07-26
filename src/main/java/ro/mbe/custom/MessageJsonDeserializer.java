package ro.mbe.custom;

import com.google.gson.Gson;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import ro.mbe.KafkaConfig;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class MessageJsonDeserializer implements Deserializer<Message> {

    private static final Gson GSON = new Gson();

    private String encoding = "UTF8";

    /**
     * Deserialize a record value from a byte array into a value or object.
     *
     * @param topic topic associated with the data
     * @param data serialized bytes; may be null; implementations are recommended to handle null by returning a value or null rather than throwing an exception.
     * @return deserialized typed data; may be null
     */
    @Override
    public Message deserialize(String topic, byte[] data) {

        if (data == null || data.length == 0)
            return null;

        try {
            String messageAsString = new String(data, this.encoding);
            return GSON.fromJson(messageAsString, Message.class);
        } catch (UnsupportedEncodingException e) {
            throw new SerializationException("Error when deserializing byte[] to JSON string due to unsupported UTF-8 encoding");
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
                ? KafkaConfig.Consumer.KEY_DESERIALIZER + ".encoding"
                : KafkaConfig.Consumer.VALUE_DESERIALIZER + ".encoding");

        if (encodingValue == null) {
            encodingValue = configs.get("deserializer.encoding");
        }

        if (encodingValue == null) {
            encodingValue = configs.get("serializer.encoding");
        }

        if (encodingValue != null && encodingValue instanceof String) {
            this.encoding = (String) encodingValue;
        }
    }

    /**
     * Close this deserializer.
     *
     * This method must be idempotent as it may be called multiple times.
     */
    @Override
    public void close() {
        //do nothing
    }
}
