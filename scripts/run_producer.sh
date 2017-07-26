#!/usr/bin/env bash

export PROJECT_HOME=$HOME'/Workspace/learning/learning-kafka'
# echo 'Using PROJECT_HOME='${PROJECT_HOME}

cd ${PROJECT_HOME}
mvn clean package
mvn exec:java -Dexec.mainClass="ro.mbe.ProducerApp" -Dexec.args="my-producer-app"