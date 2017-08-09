package ro.mbe.learn.kafka.custom;

import java.util.Date;

public class Message {

    private static final String TO_STRING_FORMAT_MESSAGE = "Message[index:[%d],text:[%s],timestamp:[%tF %tT]]";

    private Integer index;
    private String text;
    private Date timestamp;

    public Message(String text) {
        this (0, text, new Date());
    }

    public Message(Integer index, String text) {
        this (index, text, new Date());
    }

    public Message(Integer index, String text, Date timestamp) {

        this.index = index;
        this.text = text;
        this.timestamp = timestamp;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getIndex() {
        return this.index;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public String toString() {
        return String.format(TO_STRING_FORMAT_MESSAGE, this.index, this.text, this.timestamp, this.timestamp);
    }
}
