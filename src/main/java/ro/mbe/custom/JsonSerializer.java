package ro.mbe.custom;

import com.google.gson.Gson;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class JsonSerializer<T> implements Serializer<T> {

    private static final Gson GSON = new Gson();
    private static final String ENCODING = "UTF8";

    @Override
    public byte[] serialize(String topic, T data) {

        if (data == null) {
            return new byte[0];
        }

        try {
            return GSON.toJson(data).getBytes(ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new SerializationException("Error when serializing JSON string to byte[] due to unsupported UTF-8 encoding");
        }
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        //do nothing
    }

    @Override
    public void close() {
        //do nothing
    }
}
