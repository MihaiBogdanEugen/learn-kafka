#!/usr/bin/env bash

export KAFKA_HOME=$HOME'/Applications/kafka'
# echo 'Using KAFKA_HOME='${KAFKA_HOME}
rm -rfd /tmp/kafka-19103-logs/
${KAFKA_HOME}/bin/kafka-server-start.sh ${KAFKA_HOME}/config/server-103.properties