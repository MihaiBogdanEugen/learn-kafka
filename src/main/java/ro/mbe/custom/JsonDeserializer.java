package ro.mbe.custom;

import com.google.gson.Gson;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class JsonDeserializer<T> implements Deserializer<T> {

    private static final Gson Gson = new Gson();
    private String encoding = "UTF8";
    private Class<T> clazz;

    @Override
    @SuppressWarnings("unchecked")
    public void configure(Map<String, ?> configs, boolean isKey) {

        Object encodingValue = configs.get(isKey ? "key.deserializer.encoding" : "value.deserializer.encoding");

        if (encodingValue == null) {
            encodingValue = configs.get("serializer.encoding");
        }

        if (encodingValue != null && encodingValue instanceof String) {
            this.encoding = (String) encodingValue;
        }

        Object classValue = configs.get(isKey ? "key.deserializer.class" : "value.deserializer.class");
        String className = String.valueOf(classValue);

        try {
            this.clazz = (Class<T>) Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new SerializationException("Error when defining the deserializing class: " + className);
        }
    }

    @Override
    public T deserialize(String topic, byte[] data) {

        if (data == null || data.length == 0)
            return null;

        try {
            return Gson.fromJson(new String(data, this.encoding), this.clazz);
        } catch (UnsupportedEncodingException e) {
            throw new SerializationException("Error when deserializing byte[] to JSON string due to unsupported encoding: " + this.encoding);
        }
    }

    @Override
    public void close() {
        //do nothing
    }
}
