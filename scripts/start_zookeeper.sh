#!/usr/bin/env bash

export KAFKA_HOME=$HOME'/Applications/kafka'
# echo 'Using KAFKA_HOME='${KAFKA_HOME}
rm -rfd /tmp/zookeeper/
${KAFKA_HOME}/bin/zookeeper-server-start.sh ${KAFKA_HOME}/config/zookeeper.properties
