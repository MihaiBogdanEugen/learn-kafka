#!/usr/bin/env bash

export PROJECT_HOME=$HOME'/Workspace/learning/learning-kafka'
# echo 'Using PROJECT_HOME='${PROJECT_HOME}

cd ${PROJECT_HOME}
mvn clean package
mvn exec:java -Dexec.mainClass="ro.mbe.SubscribeConsumerApp" -Dexec.args="my-subscribe-producer-app"