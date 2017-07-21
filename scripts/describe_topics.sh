#!/usr/bin/env bash

export KAFKA_HOME=$HOME'/Applications/kafka'
# echo 'Using KAFKA_HOME='${KAFKA_HOME}

${KAFKA_HOME}/bin/kafka-topics.sh --describe --zookeeper localhost:2181