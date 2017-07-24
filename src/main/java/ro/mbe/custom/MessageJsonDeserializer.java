package ro.mbe.custom;

import com.google.gson.Gson;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class MessageJsonDeserializer implements Deserializer<Message> {

    private static final Gson GSON = new Gson();
    private static final String ENCODING = "UTF8";

    @Override
    public Message deserialize(String topic, byte[] data) {

        if (data == null || data.length == 0)
            return null;

        try {
            String messageAsString = new String(data, ENCODING);
            return GSON.fromJson(messageAsString, Message.class);
        } catch (UnsupportedEncodingException e) {
            throw new SerializationException("Error when deserializing byte[] to JSON string due to unsupported UTF-8 encoding");
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
