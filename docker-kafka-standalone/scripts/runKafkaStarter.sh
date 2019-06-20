#! /bin/bash
#java -jar kafkaStarter.jar &
# Starts zookeeper
$KAFKA_HOME/bin/zookeeper-server-start.sh $KAFKA_HOME/config/zookeeper.properties &
# Starts kafka
$KAFKA_HOME/bin/kafka-server-start.sh /tmp/custom_config/server.properties &
