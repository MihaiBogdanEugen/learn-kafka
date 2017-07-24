#!/usr/bin/env bash

export KAFKA_HOME=$HOME'/Applications/kafka'
# echo 'Using KAFKA_HOME='${KAFKA_HOME}
${KAFKA_HOME}/bin/zookeeper-server-stop.sh
rm -rfd /tmp/zookeeper/