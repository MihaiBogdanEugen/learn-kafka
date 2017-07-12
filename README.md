# Learning Kafka
## 0. Prerequisites
- Oracle JDK 8u131
- Apache Maven 3.5.0
- Scala 2.12.2
## 1. Installation
#### 1.1. Download Apache Kafka 0.11.0.0
```shell
curl -O http://artfiles.org/apache.org/kafka/0.11.0.0/kafka_2.12-0.11.0.0.tgz
```
#### 1.2. Unpack into $KAFKA\_HOME
```shell
mkdir -p $HOME/Applications/
tar -xzvf kafka_2.12-0.11.0.0.tgz -C $HOME/Applications/
KAFKA_HOME=$HOME'/Applications/kafka_2.12-0.11.0.0/'
```
## 2. Setup
#### 2.1. Copy .properties files from /config to $KAFKA\_HOME/config
```shell
cp config/*.properties $KAFKA_HOME/config/
```
## 3. Zookeeper
#### 3.1. Start Zookeeper
```shell
$KAFKA_HOME/bin/zookeeper-server-start.sh $KAFKA_HOME/config/zookeeper.properties
```
#### 3.2. Stop Zookeeper
```shell
$KAFKA_HOME/bin/zookeeper-server-stop.sh
```
## 4. Kafka
#### 4.1. Start a node #1 (broker.id=101)
```shell
$KAFKA_HOME/bin/kafka-server-start.sh $KAFKA_HOME/config/server-101.properties
```
#### 4.2. Start a node #2 (broker.id=102)
```shell
$KAFKA_HOME/bin/kafka-server-start.sh $KAFKA_HOME/config/server-102.properties
```
#### 4.3. Start a node #3 (broker.id=103)
```shell
$KAFKA_HOME/bin/kafka-server-start.sh $KAFKA_HOME/config/server-103.properties
```
## 5. Topics
#### 5.1. Create topic 'sensors.first' with 1 partitions and a replication factor of 3
```shell
$KAFKA_HOME/bin/kafka-topics.sh --create \
--zookeeper localhost:2181 \
--topic sensors.first \
--replication-factor 3 \
--partitions 1
```
#### 5.2. Create topic 'sensors.second' with 2 partitions and a replication factor of 3
```shell
$KAFKA_HOME/bin/kafka-topics.sh --create \
--zookeeper localhost:2181 \
--topic sensors.second \
--replication-factor 3 \
--partitions 2
```
#### 5.3. Create topic 'sensors.third' with 3 partitions and a replication factor of 3
```shell
$KAFKA_HOME/bin/kafka-topics.sh --create \
--zookeeper localhost:2181 \
--topic sensors.third \
--replication-factor 3 \
--partitions 3
```
#### 5.4. Delete topic 'sensors.first'
```shell
$KAFKA_HOME/bin/kafka-topics.sh --delete \
--zookeeper localhost:2181 \
--topic sensors.first
```
#### 5.5. List all topics
```shell
$KAFKA_HOME/bin/kafka-topics.sh --list \
--zookeeper localhost:2181
```
#### 5.6. Describe all topics
```shell
$KAFKA_HOME/bin/kafka-topics.sh --describe \
--zookeeper localhost:2181 
```
#### 5.7. Describe topic 'sensors.first'
```shell
$KAFKA_HOME/bin/kafka-topics.sh --describe \
--zookeeper localhost:2181 \
--topic 'sensors.first' \
```
#### 5.8. Alter topic 'sensors.first' by increasing the partitions number from 1 to 4
```shell
$KAFKA_HOME/bin/kafka-topics.sh --alter \
--zookeeper localhost:2181 \
--topic 'sensors.first' \
--partitions 4
```
## 6. Produce messages
#### 6.1. Produce a message on topic 'sensors.first'
```shell
$KAFKA_HOME/bin/kafka-console-producer.sh \
--broker-list localhost:19000 \
--topic 'sensors.first'
```
#### 6.2. Produce 999999 random messages, of 100 bytes each, with a throughput of 10 messages per second, on topic 'sesors.first'
```shell
$KAFKA_HOME/bin/kafka-producer-perf-test.sh \
--topic events.emails \
--num-records 999999 \
--record-size 100 \
--throughput 10 \
--producer-props bootstrap.servers=localhost:19000 key.serializer=org.apache.kafka.common.serialization.StringSerializer value.serializer=org.apache.kafka.common.serialization.StringSerializer
```
## 7. Consume messages
#### 7.1. Consume all messages from topic 'sensors.first'
```shell
$KAFKA_HOME/bin/kafka-console-consumer.sh \
--zookeeper localhost:2181 \
--topic 'sensors.first' \
--from-beginning
```
## 8. Run the ProducerApp
```shell
mvn clean package
mvn exec:java -Dexec.mainClass="de.mls.mbe.ProducerApp" -Dexec.args="my-producer-app"
```
## 9. Run the ConsumerApp
```shell
mvn clean package
mvn exec:java -Dexec.mainClass="de.mls.mbe.ConsumerApp" -Dexec.args="my-consumer-app"
```
