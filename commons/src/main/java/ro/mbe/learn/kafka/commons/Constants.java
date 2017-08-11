package ro.mbe.learn.kafka.commons;

public class Constants {

    public static final int PollingTimeout = 1000;
    public static final int NoOfRecordsToSend = 100;
    public static final int NoOfRecordsToReceive = 100;
    public static final int NoOfRecordsInTransaction = 10;

    public static final String PATTERN_RECORD_SENT = "Message with offset %d, sent to topic %s, on partition %d";
}
