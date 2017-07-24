#!/usr/bin/env bash

export KAFKA_HOME=$HOME'/Applications/kafka'
# echo 'Using KAFKA_HOME='${KAFKA_HOME}

${KAFKA_HOME}/bin/kafka-topics.sh --create --zookeeper localhost:2181 --topic sensors.first --replication-factor 3 --partitions 1

${KAFKA_HOME}/bin/kafka-topics.sh --create --zookeeper localhost:2181 --topic sensors.second --replication-factor 3 --partitions 2

${KAFKA_HOME}/bin/kafka-topics.sh --create --zookeeper localhost:2181 --topic sensors.third --replication-factor 3 --partitions 3