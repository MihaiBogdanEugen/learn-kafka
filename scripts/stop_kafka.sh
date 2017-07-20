#!/usr/bin/env bash

export KAFKA_HOME=$HOME'/Applications/kafka'
# echo 'Using KAFKA_HOME='${KAFKA_HOME}
${KAFKA_HOME}/bin/kafka-server-stop.sh
${KAFKA_HOME}/bin/kafka-server-stop.sh
${KAFKA_HOME}/bin/kafka-server-stop.sh

rm -rfd /tmp/kafka-19101-logs/
rm -rfd /tmp/kafka-19102-logs/
rm -rfd /tmp/kafka-19103-logs/

