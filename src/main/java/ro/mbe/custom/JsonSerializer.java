package ro.mbe.custom;

import com.google.gson.Gson;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class JsonSerializer<T> implements Serializer<T> {

    private static final Gson Gson = new Gson();
    private String encoding = "UTF8";

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

        Object encodingValue = configs.get(isKey ? "key.serializer.encoding" : "value.serializer.encoding");

        if (encodingValue == null) {
            encodingValue = configs.get("serializer.encoding");
        }

        if (encodingValue != null && encodingValue instanceof String) {
            this.encoding = (String) encodingValue;
        }
    }

    @Override
    public byte[] serialize(String topic, T data) {

        if (data == null)
            return new byte[0];

        try {
            return Gson.toJson(data).getBytes(this.encoding);
        } catch (UnsupportedEncodingException e) {
            throw new SerializationException("Error when serializing JSON string to byte[] due to unsupported encoding: " + this.encoding);
        }
    }

    @Override
    public void close() {
        //do nothing
    }
}
