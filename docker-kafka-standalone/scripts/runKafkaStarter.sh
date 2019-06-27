#! /bin/bash
#java -jar kafkaStarter.jar &
# Starts zookeeper

echo "testing kafka run script" >> /tmp/script_run_log.log

sleep 15

# Starts zookeeper
$KAFKA_HOME/bin/zookeeper-server-start.sh $KAFKA_HOME/config/zookeeper.properties &
sleep 30

# Starts kafka
$KAFKA_HOME/bin/kafka-server-start.sh /tmp/custom_config/server.properties
