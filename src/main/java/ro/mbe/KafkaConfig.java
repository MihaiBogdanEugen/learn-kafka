package ro.mbe;

/**
 * More information in the following classes:
 * - {@link org.apache.kafka.common.config.SaslConfigs}
 * - {@link org.apache.kafka.common.config.SslConfigs}
 * - {@link org.apache.kafka.common.config.TopicConfig}
 * - {@link org.apache.kafka.clients.producer.ProducerConfig}
 * - {@link org.apache.kafka.clients.consumer.ConsumerConfig}
 * - {@link org.apache.kafka.clients.admin.AdminClientConfig}
 * - {@link org.apache.kafka.clients.CommonClientConfigs}
 * and in the original Apache Kafka documentation (https://kafka.apache.org/documentation)
 */
public class KafkaConfig {

    /**
     * https://kafka.apache.org/documentation/#brokerconfigs
     */
    public static class Broker {

        public static class CompressionType {
            public static final String GZIP = "gzip";
            public static final String LZ4 = "lz4";
            public static final String PRODUCER = "producer";
            public static final String SNAPPY = "snappy";
            public static final String UNCOMPRESSED = "uncompressed";
        }

        public static class LogCleanupPolicy {
            public static final String COMPACT = "compact";
            public static final String DELETE = "delete";
        }

        public static class LogMessageTimestampType {
            public static String CREATE_TIME = "CreateTime";
            public static String LOG_APPEND_TIME = "LogAppendTime";
        }

        public static class SslClientAuth {
            public static String REQUIRED = "required";
            public static String REQUESTED = "requested";
            public static String NONE = "none";
        }

        public static class InterBrokerProtocolVersion {

            public static final String v0_8_0 = "0.8.0";
            public static final String v0_8_1 = "0.8.1";
            public static final String v0_8_1_1 = "0.8.1.1";
            public static final String v0_8_2 = "0.8.2";
            public static final String v0_8_2_0 = "0.8.2.0";
            public static final String v0_8_2_1 = "0.8.2.1";
            public static final String v0_9_0 = "0.9.0";
            public static final String v0_9_0_0 = "0.9.0.0";
            public static final String v0_9_0_1 = "0.9.0.1";
            public static final String v0_10_0 = "0.10.0";
            public static final String v0_10_1 = "0.10.1";
            public static final String v0_10_2 = "0.10.2";
            public static final String v0_11_0_IV2 = "0.11.0-IV2";
        }

        public static class LogMessageFormatVersion {

            public static final String v0_8_0 = "0.8.0";
            public static final String v0_8_1 = "0.8.1";
            public static final String v0_8_1_1 = "0.8.1.1";
            public static final String v0_8_2 = "0.8.2";
            public static final String v0_8_2_0 = "0.8.2.0";
            public static final String v0_8_2_1 = "0.8.2.1";
            public static final String v0_9_0 = "0.9.0";
            public static final String v0_9_0_0 = "0.9.0.0";
            public static final String v0_9_0_1 = "0.9.0.1";
            public static final String v0_10_0 = "0.10.0";
            public static final String v0_10_1 = "0.10.1";
            public static final String v0_10_2 = "0.10.2";
            public static final String v0_11_0_IV2 = "0.11.0-IV2";
        }

        public static final String ADVERTISED_HOST_NAME = "advertised.host.name";
        public static final String ADVERTISED_LISTENERS = "advertised.listeners";
        public static final String ADVERTISED_PORT = "advertised.port";
        public static final String ALTER_CONFIG_POLICY_CLASS_NAME = "alter.config.policy.class.name";
        public static final String AUTHORIZER_CLASS_NAME = "authorizer.class.name";
        public static final String AUTO_CREATE_TOPICS_ENABLE = "auto.create.topics.enable";
        public static final String AUTO_LEADER_REBALANCE_ENABLE = "auto.leader.rebalance.enable";
        public static final String BACKGROUND_THREADS = "background.threads";
        public static final String BROKER_ID = "broker.id";
        public static final String BROKER_ID_GENERATION_ENABLE = "broker.id.generation.enable";
        public static final String BROKER_RACK = "broker.rack";
        public static final String COMPRESSION_TYPE = "compression.type";
        public static final String CONNECTIONS_MAX_IDLE_MS = "connections.max.idle.ms";
        public static final String CONTROLLED_SHUTDOWN_ENABLE = "controlled.shutdown.enable";
        public static final String CONTROLLED_SHUTDOWN_MAX_RETRIES = "controlled.shutdown.max.retries";
        public static final String CONTROLLED_SHUTDOWN_RETRY_BACKOFF_MS = "controlled.shutdown.retry.backoff.ms";
        public static final String CONTROLLER_SOCKET_TIMEOUT_MS = "controller.socket.timeout.ms";
        public static final String CREATE_TOPIC_POLICY_CLASS_NAME = "create.topic.policy.class.name";
        public static final String DEFAULT_REPLICATION_FACTOR = "default.replication.factor";
        public static final String DELETE_RECORDS_PURGATORY_PURGE_INTERVAL_REQUESTS = "delete.records.purgatory.purge.interval.requests";
        public static final String DELETE_TOPIC_ENABLE = "delete.topic.enable";
        public static final String FETCH_PURGATORY_PURGE_INTERVAL_REQUESTS = "fetch.purgatory.purge.interval.requests";
        public static final String GROUP_INITIAL_REBALANCE_DELAY_MS = "group.initial.rebalance.delay.ms";
        public static final String GROUP_MAX_SESSION_TIMEOUT_MS = "group.max.session.timeout.ms";
        public static final String GROUP_MIN_SESSION_TIMEOUT_MS = "group.min.session.timeout.ms";
        public static final String HOST_NAME = "host.name";
        public static final String INTER_BROKER_LISTENER_NAME = "inter.broker.listener.name";
        public static final String INTER_BROKER_PROTOCOL_VERSION = "inter.broker.protocol.version";
        public static final String LEADER_IMBALANCE_CHECK_INTERVAL_SECONDS = "leader.imbalance.check.interval.seconds";
        public static final String LEADER_IMBALANCE_PER_BROKER_PERCENTAGE = "leader.imbalance.per.broker.percentage";
        public static final String LISTENER_SECURITY_PROTOCOL_MAP = "listener.security.protocol.map";
        public static final String LISTENERS = "listeners";
        public static final String LOG_CLEANER_BACKOFF_MS = "log.cleaner.backoff.ms";
        public static final String LOG_CLEANER_DEDUPE_BUFFER_SIZE = "log.cleaner.dedupe.buffer.size";
        public static final String LOG_CLEANER_DELETE_RETENTION_MS = "log.cleaner.delete.retention.ms";
        public static final String LOG_CLEANER_ENABLE = "log.cleaner.enable";
        public static final String LOG_CLEANER_IO_BUFFER_LOAD_FACTOR = "log.cleaner.io.buffer.load.factor";
        public static final String LOG_CLEANER_IO_BUFFER_SIZE = "log.cleaner.io.buffer.size";
        public static final String LOG_CLEANER_IO_MAX_BYTES_PER_SECOND = "log.cleaner.io.max.bytes.per.second";
        public static final String LOG_CLEANER_MIN_CLEANABLE_RATIO = "log.cleaner.min.cleanable.ratio";
        public static final String LOG_CLEANER_MIN_COMPACTION_LAG_MS = "log.cleaner.min.compaction.lag.ms";
        public static final String LOG_CLEANER_THREADS = "log.cleaner.threads";
        public static final String LOG_CLEANUP_POLICY = "log.cleanup.policy";
        public static final String LOG_DIR = "log.dir";
        public static final String LOG_DIRS = "log.dirs";
        public static final String LOG_FLUSH_INTERVAL_MESSAGES = "log.flush.interval.messages";
        public static final String LOG_FLUSH_INTERVAL_MS = "log.flush.interval.ms";
        public static final String LOG_FLUSH_OFFSET_CHECKPOINT_INTERVAL_MS = "log.flush.offset.checkpoint.interval.ms";
        public static final String LOG_FLUSH_SCHEDULER_INTERVAL_MS = "log.flush.scheduler.interval.ms";
        public static final String LOG_FLUSH_START_OFFSET_CHECKPOINT_INTERVAL_MS = "log.flush.start.offset.checkpoint.interval.ms";
        public static final String LOG_INDEX_INTERVAL_BYTES = "log.index.interval.bytes";
        public static final String LOG_INDEX_SIZE_MAX_BYTES = "log.index.size.max.bytes";
        public static final String LOG_MESSAGE_FORMAT_VERSION = "log.message.format.version";
        public static final String LOG_MESSAGE_TIMESTAMP_DIFFERENCE_MAX_MS = "log.message.timestamp.difference.max.ms";
        public static final String LOG_MESSAGE_TIMESTAMP_TYPE = "log.message.timestamp.type";
        public static final String LOG_PREALLOCATE = "log.preallocate";
        public static final String LOG_RETENTION_BYTES = "log.retention.bytes";
        public static final String LOG_RETENTION_CHECK_INTERVAL_MS = "log.retention.check.interval.ms";
        public static final String LOG_RETENTION_HOURS = "log.retention.hours";
        public static final String LOG_RETENTION_MINUTES = "log.retention.minutes";
        public static final String LOG_RETENTION_MS = "log.retention.ms";
        public static final String LOG_ROLL_HOURS = "log.roll.hours";
        public static final String LOG_ROLL_JITTER_HOURS = "log.roll.jitter.hours";
        public static final String LOG_ROLL_JITTER_MS = "log.roll.jitter.ms";
        public static final String LOG_ROLL_MS = "log.roll.ms";
        public static final String LOG_SEGMENT_BYTES = "log.segment.bytes";
        public static final String LOG_SEGMENT_DELETE_DELAY_MS = "log.segment.delete.delay.ms";
        public static final String MAX_CONNECTIONS_PER_IP = "max.connections.per.ip";
        public static final String MAX_CONNECTIONS_PER_IP_OVERRIDES = "max.connections.per.ip.overrides";
        public static final String MESSAGE_MAX_BYTES = "message.max.bytes";
        public static final String METRIC_REPORTERS = "metric.reporters";
        public static final String METRICS_NUM_SAMPLES = "metrics.num.samples";
        public static final String METRICS_RECORDING_LEVEL = "metrics.recording.level";
        public static final String METRICS_SAMPLE_WINDOW_MS = "metrics.sample.window.ms";
        public static final String MIN_INSYNC_REPLICAS = "min.insync.replicas";
        public static final String NUM_IO_THREADS = "num.io.threads";
        public static final String NUM_NETWORK_THREADS = "num.network.threads";
        public static final String NUM_PARTITIONS = "num.partitions";
        public static final String NUM_RECOVERY_THREADS_PER_DATA_DIR = "num.recovery.threads.per.data.dir";
        public static final String NUM_REPLICA_FETCHERS = "num.replica.fetchers";
        public static final String OFFSET_METADATA_MAX_BYTES = "offset.metadata.max.bytes";
        public static final String OFFSETS_COMMIT_REQUIRED_ACKS = "offsets.commit.required.acks";
        public static final String OFFSETS_COMMIT_TIMEOUT_MS = "offsets.commit.timeout.ms";
        public static final String OFFSETS_LOAD_BUFFER_SIZE = "offsets.load.buffer.size";
        public static final String OFFSETS_RETENTION_CHECK_INTERVAL_MS = "offsets.retention.check.interval.ms";
        public static final String OFFSETS_RETENTION_MINUTES = "offsets.retention.minutes";
        public static final String OFFSETS_TOPIC_COMPRESSION_CODEC = "offsets.topic.compression.codec";
        public static final String OFFSETS_TOPIC_NUM_PARTITIONS = "offsets.topic.num.partitions";
        public static final String OFFSETS_TOPIC_REPLICATION_FACTOR = "offsets.topic.replication.factor";
        public static final String OFFSETS_TOPIC_SEGMENT_BYTES = "offsets.topic.segment.bytes";
        public static final String PORT = "port";
        public static final String PRINCIPAL_BUILDER_CLASS = "principal.builder.class";
        public static final String PRODUCER_PURGATORY_PURGE_INTERVAL_REQUESTS = "producer.purgatory.purge.interval.requests";
        public static final String QUEUED_MAX_REQUESTS = "queued.max.requests";
        public static final String QUOTA_CONSUMER_DEFAULT = "quota.consumer.default";
        public static final String QUOTA_PRODUCER_DEFAULT = "quota.producer.default";
        public static final String QUOTA_WINDOW_NUM = "quota.window.num";
        public static final String QUOTA_WINDOW_SIZE_SECONDS = "quota.window.size.seconds";
        public static final String REPLICA_FETCH_BACKOFF_MS = "replica.fetch.backoff.ms";
        public static final String REPLICA_FETCH_MAX_BYTES = "replica.fetch.max.bytes";
        public static final String REPLICA_FETCH_MIN_BYTES = "replica.fetch.min.bytes";
        public static final String REPLICA_FETCH_RESPONSE_MAX_BYTES = "replica.fetch.response.max.bytes";
        public static final String REPLICA_FETCH_WAIT_MAX_MS = "replica.fetch.wait.max.ms";
        public static final String REPLICA_HIGH_WATERMARK_CHECKPOINT_INTERVAL_MS = "replica.high.watermark.checkpoint.interval.ms";
        public static final String REPLICA_LAG_TIME_MAX_MS = "replica.lag.time.max.ms";
        public static final String REPLICA_SOCKET_RECEIVE_BUFFER_BYTES = "replica.socket.receive.buffer.bytes";
        public static final String REPLICA_SOCKET_TIMEOUT_MS = "replica.socket.timeout.ms";
        public static final String REPLICATION_QUOTA_WINDOW_NUM = "replication.quota.window.num";
        public static final String REPLICATION_QUOTA_WINDOW_SIZE_SECONDS = "replication.quota.window.size.seconds";
        public static final String REQUEST_TIMEOUT_MS = "request.timeout.ms";
        public static final String RESERVED_BROKER_MAX_ID = "reserved.broker.max.id";
        public static final String SASL_ENABLED_MECHANISMS = "sasl.enabled.mechanisms";
        public static final String SASL_KERBEROS_KINIT_CMD = "sasl.kerberos.kinit.cmd";
        public static final String SASL_KERBEROS_MIN_TIME_BEFORE_RELOGIN = "sasl.kerberos.min.time.before.relogin";
        public static final String SASL_KERBEROS_PRINCIPAL_TO_LOCAL_RULES = "sasl.kerberos.principal.to.local.rules";
        public static final String SASL_KERBEROS_SERVICE_NAME = "sasl.kerberos.service.name";
        public static final String SASL_KERBEROS_TICKET_RENEW_JITTER = "sasl.kerberos.ticket.renew.jitter";
        public static final String SASL_KERBEROS_TICKET_RENEW_WINDOW_FACTOR = "sasl.kerberos.ticket.renew.window.factor";
        public static final String SASL_MECHANISM_INTER_BROKER_PROTOCOL = "sasl.mechanism.inter.broker.protocol";
        public static final String SECURITY_INTER_BROKER_PROTOCOL = "security.inter.broker.protocol";
        public static final String SOCKET_RECEIVE_BUFFER_BYTES = "socket.receive.buffer.bytes";
        public static final String SOCKET_REQUEST_MAX_BYTES = "socket.request.max.bytes";
        public static final String SOCKET_SEND_BUFFER_BYTES = "socket.send.buffer.bytes";
        public static final String SSL_CIPHER_SUITES = "ssl.cipher.suites";
        public static final String SSL_CLIENT_AUTH = "ssl.client.auth";
        public static final String SSL_ENABLED_PROTOCOLS = "ssl.enabled.protocols";
        public static final String SSL_ENDPOINT_IDENTIFICATION_ALGORITHM = "ssl.endpoint.identification.algorithm";
        public static final String SSL_KEY_PASSWORD = "ssl.key.password";
        public static final String SSL_KEYMANAGER_ALGORITHM = "ssl.keymanager.algorithm";
        public static final String SSL_KEYSTORE_LOCATION = "ssl.keystore.location";
        public static final String SSL_KEYSTORE_PASSWORD = "ssl.keystore.password";
        public static final String SSL_KEYSTORE_TYPE = "ssl.keystore.type";
        public static final String SSL_PROTOCOL = "ssl.protocol";
        public static final String SSL_PROVIDER = "ssl.provider";
        public static final String SSL_SECURE_RANDOM_IMPLEMENTATION = "ssl.secure.random.implementation";
        public static final String SSL_TRUSTMANAGER_ALGORITHM = "ssl.trustmanager.algorithm";
        public static final String SSL_TRUSTSTORE_LOCATION = "ssl.truststore.location";
        public static final String SSL_TRUSTSTORE_PASSWORD = "ssl.truststore.password";
        public static final String SSL_TRUSTSTORE_TYPE = "ssl.truststore.type";
        public static final String TRANSACTION_ABORT_TIMED_OUT_TRANSACTION_CLEANUP_INTERVAL_MS = "transaction.abort.timed.out.transaction.cleanup.interval.ms";
        public static final String TRANSACTION_MAX_TIMEOUT_MS = "transaction.max.timeout.ms";
        public static final String TRANSACTION_REMOVE_EXPIRED_TRANSACTION_CLEANUP_INTERVAL_MS = "transaction.remove.expired.transaction.cleanup.interval.ms";
        public static final String TRANSACTION_STATE_LOG_LOAD_BUFFER_SIZE = "transaction.state.log.load.buffer.size";
        public static final String TRANSACTION_STATE_LOG_MIN_ISR = "transaction.state.log.min.isr";
        public static final String TRANSACTION_STATE_LOG_NUM_PARTITIONS = "transaction.state.log.num.partitions";
        public static final String TRANSACTION_STATE_LOG_REPLICATION_FACTOR = "transaction.state.log.replication.factor";
        public static final String TRANSACTION_STATE_LOG_SEGMENT_BYTES = "transaction.state.log.segment.bytes";
        public static final String TRANSACTIONAL_ID_EXPIRATION_MS = "transactional.id.expiration.ms";
        public static final String UNCLEAN_LEADER_ELECTION_ENABLE = "unclean.leader.election.enable";
        public static final String ZOOKEEPER_CONNECT = "zookeeper.connect";
        public static final String ZOOKEEPER_CONNECTION_TIMEOUT_MS = "zookeeper.connection.timeout.ms";
        public static final String ZOOKEEPER_SESSION_TIMEOUT_MS = "zookeeper.session.timeout.ms";
        public static final String ZOOKEEPER_SET_ACL = "zookeeper.set.acl";
        public static final String ZOOKEEPER_SYNC_TIME_MS = "zookeeper.sync.time.ms";

        /**
         * https://kafka.apache.org/documentation/#topic-config
         */
        public static class TopicLevel {

            public static class CleanupPolicy {
                public static final String COMPACT = "compact";
                public static final String DELETE = "delete";
            }

            public static class CompressionType {
                public static final String GZIP = "gzip";
                public static final String LZ4 = "lz4";
                public static final String PRODUCER = "producer";
                public static final String SNAPPY = "snappy";
                public static final String UNCOMPRESSED = "uncompressed";
            }

            public static class MessageFormatVersion {

                public static final String v0_8_0 = "0.8.0";
                public static final String v0_8_1 = "0.8.1";
                public static final String v0_8_1_1 = "0.8.1.1";
                public static final String v0_8_2 = "0.8.2";
                public static final String v0_8_2_0 = "0.8.2.0";
                public static final String v0_8_2_1 = "0.8.2.1";
                public static final String v0_9_0 = "0.9.0";
                public static final String v0_9_0_0 = "0.9.0.0";
                public static final String v0_9_0_1 = "0.9.0.1";
                public static final String v0_10_0 = "0.10.0";
                public static final String v0_10_1 = "0.10.1";
                public static final String v0_10_2 = "0.10.2";
                public static final String v0_11_0_IV2 = "0.11.0-IV2";
            }

            public static final String CLEANUP_POLICY = "cleanup.policy";
            public static final String COMPRESSION_TYPE = "compression.type";
            public static final String DELETE_RETENTION_MS = "delete.retention.ms";
            public static final String FILE_DELETE_DELAY_MS = "file.delete.delay.ms";
            public static final String FLUSH_MESSAGES = "flush.messages";
            public static final String FLUSH_MS = "flush.ms";
            public static final String FOLLOWER_REPLICATION_THROTTLED_REPLICAS = "follower.replication.throttled.replicas";
            public static final String INDEX_INTERVAL_BYTES = "index.interval.bytes";
            public static final String LEADER_REPLICATION_THROTTLED_REPLICAS = "leader.replication.throttled.replicas";
            public static final String MAX_MESSAGE_BYTES = "max.message.bytes";
            public static final String MESSAGE_FORMAT_VERSION = "message.format.version";
            public static final String MESSAGE_TIMESTAMP_DIFFERENCE_MAX_MS = "message.timestamp.difference.max.ms";
            public static final String MESSAGE_TIMESTAMP_TYPE = "message.timestamp.type";
            public static final String MIN_CLEANABLE_DIRTY_RATIO = "min.cleanable.dirty.ratio";
            public static final String MIN_COMPACTION_LAG_MS = "min.compaction.lag.ms";
            public static final String MIN_INSYNC_REPLICAS = "min.insync.replicas";
            public static final String PREALLOCATE = "preallocate";
            public static final String RETENTION_BYTES = "retention.bytes";
            public static final String RETENTION_MS = "retention.ms";
            public static final String SEGMENT_BYTES = "segment.bytes";
            public static final String SEGMENT_INDEX_BYTES = "segment.index.bytes";
            public static final String SEGMENT_JITTER_MS = "segment.jitter.ms";
            public static final String SEGMENT_MS = "segment.ms";
            public static final String UNCLEAN_LEADER_ELECTION_ENABLE = "unclean.leader.election.enable";
        }
    }

    /**
     * https://kafka.apache.org/documentation/#producerconfigs
     */
    public static class Producer {

        public static class Acks {

            public static final String NONE = "0";
            public static final String LEADER = "1";
            public static final String ALL = "-1";
        }

        public static class CompressionType {
            public static final String GZIP = "gzip";
            public static final String LZ4 = "lz4";
            public static final String NONE = "none";
            public static final String SNAPPY = "snappy";
        }

        public static class MetricsRecordingLevel {

            public static final String INFO = "INFO";
            public static final String DEBUG = "DEBUG";
        }

        public static class SslProtocol {

            public static final String TLS = "TLS";
            public static final String TLSv1_1 = "TLSv1.1";
            public static final String TLSv1_2 = "TLSv1.2";
            public static final String SSL = "SSL";
            public static final String SSLv2 = "SSLv2";
            public static final String SSLv3 = "SSLv3";
        }

        public static final String ACKS = "acks";
        public static final String BATCH_SIZE = "batch.size";
        public static final String BOOTSTRAP_SERVERS = "bootstrap.servers";
        public static final String BUFFER_MEMORY = "buffer.memory";
        public static final String CLIENT_ID = "client.id";
        public static final String COMPRESSION_TYPE = "compression.type";
        public static final String CONNECTIONS_MAX_IDLE_MS = "connections.max.idle.ms";
        public static final String ENABLE_IDEMPOTENCE = "enable.idempotence";
        public static final String INTERCEPTOR_CLASSES = "interceptor.classes";
        public static final String KEY_SERIALIZER = "key.serializer";
        public static final String LINGER_MS = "linger.ms";
        public static final String MAX_BLOCK_MS = "max.block.ms";
        public static final String MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION = "max.in.flight.requests.per.connection";
        public static final String MAX_REQUEST_SIZE = "max.request.size";
        public static final String METADATA_MAX_AGE_MS = "metadata.max.age.ms";
        public static final String METRIC_REPORTERS = "metric.reporters";
        public static final String METRICS_NUM_SAMPLES = "metrics.num.samples";
        public static final String METRICS_RECORDING_LEVEL = "metrics.recording.level";
        public static final String METRICS_SAMPLE_WINDOW_MS = "metrics.sample.window.ms";
        public static final String PARTITIONER_CLASS = "partitioner.class";
        public static final String RECEIVE_BUFFER_BYTES = "receive.buffer.bytes";
        public static final String RECONNECT_BACKOFF_MAX_MS = "reconnect.backoff.max.ms";
        public static final String RECONNECT_BACKOFF_MS = "reconnect.backoff.ms";
        public static final String REQUEST_TIMEOUT_MS = "request.timeout.ms";
        public static final String RETRIES = "retries";
        public static final String RETRY_BACKOFF_MS = "retry.backoff.ms";
        public static final String SASL_JAAS_CONFIG = "sasl.jaas.config";
        public static final String SASL_KERBEROS_KINIT_CMD = "sasl.kerberos.kinit.cmd";
        public static final String SASL_KERBEROS_MIN_TIME_BEFORE_RELOGIN = "sasl.kerberos.min.time.before.relogin";
        public static final String SASL_KERBEROS_SERVICE_NAME = "sasl.kerberos.service.name";
        public static final String SASL_KERBEROS_TICKET_RENEW_JITTER = "sasl.kerberos.ticket.renew.jitter";
        public static final String SASL_KERBEROS_TICKET_RENEW_WINDOW_FACTOR = "sasl.kerberos.ticket.renew.window.factor";
        public static final String SASL_MECHANISM = "sasl.mechanism";
        public static final String SECURITY_PROTOCOL = "security.protocol";
        public static final String SEND_BUFFER_BYTES = "send.buffer.bytes";
        public static final String SSL_CIPHER_SUITES = "ssl.cipher.suites";
        public static final String SSL_ENABLED_PROTOCOLS = "ssl.enabled.protocols";
        public static final String SSL_ENDPOINT_IDENTIFICATION_ALGORITHM = "ssl.endpoint.identification.algorithm";
        public static final String SSL_KEY_PASSWORD = "ssl.key.password";
        public static final String SSL_KEYMANAGER_ALGORITHM = "ssl.keymanager.algorithm";
        public static final String SSL_KEYSTORE_LOCATION = "ssl.keystore.location";
        public static final String SSL_KEYSTORE_PASSWORD = "ssl.keystore.password";
        public static final String SSL_KEYSTORE_TYPE = "ssl.keystore.type";
        public static final String SSL_PROTOCOL = "ssl.protocol";
        public static final String SSL_PROVIDER = "ssl.provider";
        public static final String SSL_SECURE_RANDOM_IMPLEMENTATION = "ssl.secure.random.implementation";
        public static final String SSL_TRUSTMANAGER_ALGORITHM = "ssl.trustmanager.algorithm";
        public static final String SSL_TRUSTSTORE_LOCATION = "ssl.truststore.location";
        public static final String SSL_TRUSTSTORE_PASSWORD = "ssl.truststore.password";
        public static final String SSL_TRUSTSTORE_TYPE = "ssl.truststore.type";
        public static final String TRANSACTION_TIMEOUT_MS = "transaction.timeout.ms";
        public static final String TRANSACTIONAL_ID = "transactional.id";
        public static final String VALUE_SERIALIZER = "value.serializer";
    }

    /**
     * https://kafka.apache.org/documentation/#consumerconfigs
     * https://kafka.apache.org/documentation/#newconsumerconfigs
     */
    public static class Consumer {

        public static class AutoOffsetReset {

            public static final String LATEST = "latest";
            public static final String EARLIEST = "earliest";
            public static final String NONE = "none";
        }

        public static class IsolationLevel {

            public static final String READ_COMMITED = "read_committed";
            public static final String READ_UNCOMMITED = "read_uncommitted";
        }

        public static class SecurityProtocol {

            public static final String PLAINTEXT = "PLAINTEXT";
            public static final String SSL = "SSL";
            public static final String SASL_PLAINTEXT = "SASL_PLAINTEXT";
            public static final String SASL_SSL = "SASL_SSL";
        }

        public static class SslEnabledProtocols {

            public static final String TLSv1_2 = "TLSv1.2";
            public static final String TLSv1_1 = "TLSv1.1";
            public static final String TLSv1 = "TLSv1";
        }

        public static class SslProtocol {

            public static final String TLS = "TLS";
            public static final String TLSv1_1 = "TLSv1.1";
            public static final String TLSv1_2 = "TLSv1.2";
            public static final String SSL = "SSL";
            public static final String SSLv2 = "SSLv2";
            public static final String SSLv3 = "SSLv3";
        }

        public static class MetricsRecordingLevel {

            public static final String INFO = "INFO";
            public static final String DEBUG = "DEBUG";
        }

        public static final String AUTO_COMMIT_INTERVAL_MS = "auto.commit.interval.ms";
        public static final String AUTO_OFFSET_RESET = "auto.offset.reset";
        public static final String BOOTSTRAP_SERVERS = "bootstrap.servers";
        public static final String CHECK_CRCS = "check.crcs";
        public static final String CLIENT_ID = "client.id";
        public static final String CONNECTIONS_MAX_IDLE_MS = "connections.max.idle.ms";
        public static final String ENABLE_AUTO_COMMIT = "enable.auto.commit";
        public static final String EXCLUDE_INTERNAL_TOPICS = "exclude.internal.topics";
        public static final String FETCH_MAX_BYTES = "fetch.max.bytes";
        public static final String FETCH_MAX_WAIT_MS = "fetch.max.wait.ms";
        public static final String FETCH_MIN_BYTES = "fetch.min.bytes";
        public static final String GROUP_ID = "group.id";
        public static final String HEARTBEAT_INTERVAL_MS = "heartbeat.interval.ms";
        public static final String INTERCEPTOR_CLASSES = "interceptor.classes";
        public static final String ISOLATION_LEVEL = "isolation.level";
        public static final String KEY_DESERIALIZER = "key.deserializer";
        public static final String MAX_PARTITION_FETCH_BYTES = "max.partition.fetch.bytes";
        public static final String MAX_POLL_INTERVAL_MS = "max.poll.interval.ms";
        public static final String MAX_POLL_RECORDS = "max.poll.records";
        public static final String METADATA_MAX_AGE_MS = "metadata.max.age.ms";
        public static final String METRIC_REPORTERS = "metric.reporters";
        public static final String METRICS_NUM_SAMPLES = "metrics.num.samples";
        public static final String METRICS_RECORDING_LEVEL = "metrics.recording.level";
        public static final String METRICS_SAMPLE_WINDOW_MS = "metrics.sample.window.ms";
        public static final String PARTITION_ASSIGNMENT_STRATEGY = "partition.assignment.strategy";
        public static final String RECEIVE_BUFFER_BYTES = "receive.buffer.bytes";
        public static final String RECONNECT_BACKOFF_MAX_MS = "reconnect.backoff.max.ms";
        public static final String RECONNECT_BACKOFF_MS = "reconnect.backoff.ms";
        public static final String REQUEST_TIMEOUT_MS = "request.timeout.ms";
        public static final String RETRY_BACKOFF_MS = "retry.backoff.ms";
        public static final String SASL_JAAS_CONFIG = "sasl.jaas.config";
        public static final String SASL_KERBEROS_KINIT_CMD = "sasl.kerberos.kinit.cmd";
        public static final String SASL_KERBEROS_MIN_TIME_BEFORE_RELOGIN = "sasl.kerberos.min.time.before.relogin";
        public static final String SASL_KERBEROS_SERVICE_NAME = "sasl.kerberos.service.name";
        public static final String SASL_KERBEROS_TICKET_RENEW_JITTER = "sasl.kerberos.ticket.renew.jitter";
        public static final String SASL_KERBEROS_TICKET_RENEW_WINDOW_FACTOR = "sasl.kerberos.ticket.renew.window.factor";
        public static final String SASL_MECHANISM = "sasl.mechanism";
        public static final String SECURITY_PROTOCOL = "security.protocol";
        public static final String SEND_BUFFER_BYTES = "send.buffer.bytes";
        public static final String SESSION_TIMEOUT_MS = "session.timeout.ms";
        public static final String SSL_CIPHER_SUITES = "ssl.cipher.suites";
        public static final String SSL_ENABLED_PROTOCOLS = "ssl.enabled.protocols";
        public static final String SSL_ENDPOINT_IDENTIFICATION_ALGORITHM = "ssl.endpoint.identification.algorithm";
        public static final String SSL_KEY_PASSWORD = "ssl.key.password";
        public static final String SSL_KEYMANAGER_ALGORITHM = "ssl.keymanager.algorithm";
        public static final String SSL_KEYSTORE_LOCATION = "ssl.keystore.location";
        public static final String SSL_KEYSTORE_PASSWORD = "ssl.keystore.password";
        public static final String SSL_KEYSTORE_TYPE = "ssl.keystore.type";
        public static final String SSL_PROTOCOL = "ssl.protocol";
        public static final String SSL_PROVIDER = "ssl.provider";
        public static final String SSL_SECURE_RANDOM_IMPLEMENTATION = "ssl.secure.random.implementation";
        public static final String SSL_TRUSTMANAGER_ALGORITHM = "ssl.trustmanager.algorithm";
        public static final String SSL_TRUSTSTORE_LOCATION = "ssl.truststore.location";
        public static final String SSL_TRUSTSTORE_PASSWORD = "ssl.truststore.password";
        public static final String SSL_TRUSTSTORE_TYPE = "ssl.truststore.type";
        public static final String VALUE_DESERIALIZER = "value.deserializer";
    }

    /**
     * https://kafka.apache.org/documentation/#adminclientconfigs
     */
    public static class AdminClient {

        public static final String BOOTSTRAP_SERVERS = "bootstrap.servers";
        public static final String CLIENT_ID = "client.id";
        public static final String CONNECTIONS_MAX_IDLE_MS = "connections.max.idle.ms";
        public static final String METADATA_MAX_AGE_MS = "metadata.max.age.ms";
        public static final String METRIC_REPORTERS = "metric.reporters";
        public static final String METRICS_NUM_SAMPLES = "metrics.num.samples";
        public static final String METRICS_RECORDING_LEVEL = "metrics.recording.level";
        public static final String METRICS_SAMPLE_WINDOW_MS = "metrics.sample.window.ms";
        public static final String RECEIVE_BUFFER_BYTES = "receive.buffer.bytes";
        public static final String RECONNECT_BACKOFF_MAX_MS = "reconnect.backoff.max.ms";
        public static final String RECONNECT_BACKOFF_MS = "reconnect.backoff.ms";
        public static final String REQUEST_TIMEOUT_MS = "request.timeout.ms";
        public static final String RETRIES = "retries";
        public static final String RETRY_BACKOFF_MS = "retry.backoff.ms";
        public static final String SASL_JAAS_CONFIG = "sasl.jaas.config";
        public static final String SASL_KERBEROS_KINIT_CMD = "sasl.kerberos.kinit.cmd";
        public static final String SASL_KERBEROS_MIN_TIME_BEFORE_RELOGIN = "sasl.kerberos.min.time.before.relogin";
        public static final String SASL_KERBEROS_SERVICE_NAME = "sasl.kerberos.service.name";
        public static final String SASL_KERBEROS_TICKET_RENEW_JITTER = "sasl.kerberos.ticket.renew.jitter";
        public static final String SASL_KERBEROS_TICKET_RENEW_WINDOW_FACTOR = "sasl.kerberos.ticket.renew.window.factor";
        public static final String SASL_MECHANISM = "sasl.mechanism";
        public static final String SECURITY_PROTOCOL = "security.protocol";
        public static final String SEND_BUFFER_BYTES = "send.buffer.bytes";
        public static final String SSL_CIPHER_SUITES = "ssl.cipher.suites";
        public static final String SSL_ENABLED_PROTOCOLS = "ssl.enabled.protocols";
        public static final String SSL_ENDPOINT_IDENTIFICATION_ALGORITHM = "ssl.endpoint.identification.algorithm";
        public static final String SSL_KEY_PASSWORD = "ssl.key.password";
        public static final String SSL_KEYMANAGER_ALGORITHM = "ssl.keymanager.algorithm";
        public static final String SSL_KEYSTORE_LOCATION = "ssl.keystore.location";
        public static final String SSL_KEYSTORE_PASSWORD = "ssl.keystore.password";
        public static final String SSL_KEYSTORE_TYPE = "ssl.keystore.type";
        public static final String SSL_PROTOCOL = "ssl.protocol";
        public static final String SSL_PROVIDER = "ssl.provider";
        public static final String SSL_SECURE_RANDOM_IMPLEMENTATION = "ssl.secure.random.implementation";
        public static final String SSL_TRUSTMANAGER_ALGORITHM = "ssl.trustmanager.algorithm";
        public static final String SSL_TRUSTSTORE_LOCATION = "ssl.truststore.location";
        public static final String SSL_TRUSTSTORE_PASSWORD = "ssl.truststore.password";
        public static final String SSL_TRUSTSTORE_TYPE = "ssl.truststore.type";
    }

    /**
     * https://kafka.apache.org/documentation/#streamsconfigs
     */
    public static class Streams {

        public static final String APPLICATION_ID = "application.id";
        public static final String APPLICATION_SERVER = "application.server";
        public static final String BOOTSTRAP_SERVERS = "bootstrap.servers";
        public static final String BUFFERED_RECORDS_PER_PARTITION = "buffered.records.per.partition";
        public static final String CACHE_MAX_BYTES_BUFFERING = "cache.max.bytes.buffering";
        public static final String CLIENT_ID = "client.id";
        public static final String COMMIT_INTERVAL_MS = "commit.interval.ms";
        public static final String CONNECTIONS_MAX_IDLE_MS = "connections.max.idle.ms";
        public static final String DEFAULT_KEY_SERDE = "default.key.serde";
        public static final String DEFAULT_TIMESTAMP_EXTRACTOR = "default.timestamp.extractor";
        public static final String DEFAULT_VALUE_SERDE = "default.value.serde";
        public static final String KEY_SERDE = "key.serde";
        public static final String METADATA_MAX_AGE_MS = "metadata.max.age.ms";
        public static final String METRIC_REPORTERS = "metric.reporters";
        public static final String METRICS_NUM_SAMPLES = "metrics.num.samples";
        public static final String METRICS_RECORDING_LEVEL = "metrics.recording.level";
        public static final String METRICS_SAMPLE_WINDOW_MS = "metrics.sample.window.ms";
        public static final String NUM_STANDBY_REPLICAS = "num.standby.replicas";
        public static final String NUM_STREAM_THREADS = "num.stream.threads";
        public static final String PARTITION_GROUPER = "partition.grouper";
        public static final String POLL_MS = "poll.ms";
        public static final String PROCESSING_GUARANTEE = "processing.guarantee";
        public static final String RECEIVE_BUFFER_BYTES = "receive.buffer.bytes";
        public static final String RECONNECT_BACKOFF_MAX_MS = "reconnect.backoff.max.ms";
        public static final String RECONNECT_BACKOFF_MS = "reconnect.backoff.ms";
        public static final String REPLICATION_FACTOR = "replication.factor";
        public static final String REQUEST_TIMEOUT_MS = "request.timeout.ms";
        public static final String RETRY_BACKOFF_MS = "retry.backoff.ms";
        public static final String ROCKSDB_CONFIG_SETTER = "rocksdb.config.setter";
        public static final String SECURITY_PROTOCOL = "security.protocol";
        public static final String SEND_BUFFER_BYTES = "send.buffer.bytes";
        public static final String STATE_CLEANUP_DELAY_MS = "state.cleanup.delay.ms";
        public static final String STATE_DIR = "state.dir";
        public static final String TIMESTAMP_EXTRACTOR = "timestamp.extractor";
        public static final String VALUE_SERDE = "value.serde";
        public static final String WINDOWSTORE_CHANGELOG_ADDITIONAL_RETENTION_MS = "windowstore.changelog.additional.retention.ms";
        public static final String ZOOKEEPER_CONNECT = "zookeeper.connect";
    }

    /**
     * https://kafka.apache.org/documentation/#connectconfigs
     */
    public static class Connect {

        public static final String ACCESS_CONTROL_ALLOW_METHODS = "access.control.allow.methods";
        public static final String ACCESS_CONTROL_ALLOW_ORIGIN = "access.control.allow.origin";
        public static final String BOOTSTRAP_SERVERS = "bootstrap.servers";
        public static final String CLIENT_ID = "client.id";
        public static final String CONFIG_STORAGE_REPLICATION_FACTOR = "config.storage.replication.factor";
        public static final String CONFIG_STORAGE_TOPIC = "config.storage.topic";
        public static final String CONNECTIONS_MAX_IDLE_MS = "connections.max.idle.ms";
        public static final String GROUP_ID = "group.id";
        public static final String HEARTBEAT_INTERVAL_MS = "heartbeat.interval.ms";
        public static final String INTERNAL_KEY_CONVERTER = "internal.key.converter";
        public static final String INTERNAL_VALUE_CONVERTER = "internal.value.converter";
        public static final String KEY_CONVERTER = "key.converter";
        public static final String METADATA_MAX_AGE_MS = "metadata.max.age.ms";
        public static final String METRIC_REPORTERS = "metric.reporters";
        public static final String METRICS_NUM_SAMPLES = "metrics.num.samples";
        public static final String METRICS_SAMPLE_WINDOW_MS = "metrics.sample.window.ms";
        public static final String OFFSET_FLUSH_INTERVAL_MS = "offset.flush.interval.ms";
        public static final String OFFSET_FLUSH_TIMEOUT_MS = "offset.flush.timeout.ms";
        public static final String OFFSET_STORAGE_PARTITIONS = "offset.storage.partitions";
        public static final String OFFSET_STORAGE_REPLICATION_FACTOR = "offset.storage.replication.factor";
        public static final String OFFSET_STORAGE_TOPIC = "offset.storage.topic";
        public static final String PLUGIN_PATH = "plugin.path";
        public static final String REBALANCE_TIMEOUT_MS = "rebalance.timeout.ms";
        public static final String RECEIVE_BUFFER_BYTES = "receive.buffer.bytes";
        public static final String RECONNECT_BACKOFF_MAX_MS = "reconnect.backoff.max.ms";
        public static final String RECONNECT_BACKOFF_MS = "reconnect.backoff.ms";
        public static final String REQUEST_TIMEOUT_MS = "request.timeout.ms";
        public static final String REST_ADVERTISED_HOST_NAME = "rest.advertised.host.name";
        public static final String REST_ADVERTISED_PORT = "rest.advertised.port";
        public static final String REST_HOST_NAME = "rest.host.name";
        public static final String REST_PORT = "rest.port";
        public static final String RETRY_BACKOFF_MS = "retry.backoff.ms";
        public static final String SASL_JAAS_CONFIG = "sasl.jaas.config";
        public static final String SASL_KERBEROS_KINIT_CMD = "sasl.kerberos.kinit.cmd";
        public static final String SASL_KERBEROS_MIN_TIME_BEFORE_RELOGIN = "sasl.kerberos.min.time.before.relogin";
        public static final String SASL_KERBEROS_SERVICE_NAME = "sasl.kerberos.service.name";
        public static final String SASL_KERBEROS_TICKET_RENEW_JITTER = "sasl.kerberos.ticket.renew.jitter";
        public static final String SASL_KERBEROS_TICKET_RENEW_WINDOW_FACTOR = "sasl.kerberos.ticket.renew.window.factor";
        public static final String SASL_MECHANISM = "sasl.mechanism";
        public static final String SECURITY_PROTOCOL = "security.protocol";
        public static final String SEND_BUFFER_BYTES = "send.buffer.bytes";
        public static final String SESSION_TIMEOUT_MS = "session.timeout.ms";
        public static final String SSL_CIPHER_SUITES = "ssl.cipher.suites";
        public static final String SSL_ENABLED_PROTOCOLS = "ssl.enabled.protocols";
        public static final String SSL_ENDPOINT_IDENTIFICATION_ALGORITHM = "ssl.endpoint.identification.algorithm";
        public static final String SSL_KEY_PASSWORD = "ssl.key.password";
        public static final String SSL_KEYMANAGER_ALGORITHM = "ssl.keymanager.algorithm";
        public static final String SSL_KEYSTORE_LOCATION = "ssl.keystore.location";
        public static final String SSL_KEYSTORE_PASSWORD = "ssl.keystore.password";
        public static final String SSL_KEYSTORE_TYPE = "ssl.keystore.type";
        public static final String SSL_PROTOCOL = "ssl.protocol";
        public static final String SSL_PROVIDER = "ssl.provider";
        public static final String SSL_SECURE_RANDOM_IMPLEMENTATION = "ssl.secure.random.implementation";
        public static final String SSL_TRUSTMANAGER_ALGORITHM = "ssl.trustmanager.algorithm";
        public static final String SSL_TRUSTSTORE_LOCATION = "ssl.truststore.location";
        public static final String SSL_TRUSTSTORE_PASSWORD = "ssl.truststore.password";
        public static final String SSL_TRUSTSTORE_TYPE = "ssl.truststore.type";
        public static final String STATUS_STORAGE_PARTITIONS = "status.storage.partitions";
        public static final String STATUS_STORAGE_REPLICATION_FACTOR = "status.storage.replication.factor";
        public static final String STATUS_STORAGE_TOPIC = "status.storage.topic";
        public static final String TASK_SHUTDOWN_GRACEFUL_TIMEOUT_MS = "task.shutdown.graceful.timeout.ms";
        public static final String VALUE_CONVERTER = "value.converter";
        public static final String WORKER_SYNC_TIMEOUT_MS = "worker.sync.timeout.ms";
        public static final String WORKER_UNSYNC_BACKOFF_MS = "worker.unsync.backoff.ms";
    }
}
