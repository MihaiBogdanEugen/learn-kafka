package ro.mbe.custom;

import com.google.gson.Gson;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import ro.mbe.KafkaConfig;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class JsonDeserializer<T> implements Deserializer<T> {

    private static final Gson GSON = new Gson();
    private static final String ENCODING = "UTF8";
    private Class<T> clazz;

    @Override
    @SuppressWarnings("unchecked")
    public void configure(Map<String, ?> configs, boolean isKey) {

        Object classValue = configs.get(isKey ? KafkaConfig.Consumer.KEY_DESERIALIZER : KafkaConfig.Consumer.VALUE_DESERIALIZER);
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
            return GSON.fromJson(new String(data, ENCODING), this.clazz);
        } catch (UnsupportedEncodingException e) {
            throw new SerializationException("Error when deserializing byte[] to JSON string due to unsupported UTF-8 encoding");
        }
    }

    @Override
    public void close() {
        //do nothing
    }
}
