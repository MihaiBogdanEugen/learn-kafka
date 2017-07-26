package ro.mbe.custom;

import com.google.gson.Gson;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class MessageJsonSerializer implements Serializer<Message> {

    private static final Gson GSON = new Gson();
    private static final String ENCODING = "UTF8";

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
            return messageAsString.getBytes(ENCODING);
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
        //do nothing
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
