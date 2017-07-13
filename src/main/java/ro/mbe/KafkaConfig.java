package ro.mbe;

public class KafkaConfig {
    public static class Broker {
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
    }

    public static class Producer {
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

    public static class Consumer {
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
        public static final String INTERNAL_LEAVE_GROUP_ON_CLOSE = "internal.leave.group.on.close";
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
        public static final String UTO_COMMIT_INTERVAL_MS = "uto.commit.interval.ms";
        public static final String VALUE_DESERIALIZER = "value.deserializer";
    }
}