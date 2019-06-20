Kafka in Docker
===

This repository provides everything you need to run Kafka in Docker.


Why?
---
The main hurdle of running Kafka in Docker is that it depends on Zookeeper.
Compared to other Kafka docker images, this one runs both Zookeeper and Kafka
in the same container. This means:

* No dependency on an external Zookeeper host, or linking to another container
* Zookeeper and Kafka are configured to work together out of the box

```
docker build -t arm/kafka:221 .
```

Run
---

```bash
docker run -p 2181:2181 -p 9092 -p 8085:8085 --name kafka -it kafka
```

```bash
export KAFKA=<dockerHostIP>:9092
kafka-console-producer.sh --broker-list $KAFKA --topic test
```

```bash
export ZOOKEEPER=<dockerHostIP>:2181
kafka-console-consumer.sh --zookeeper $ZOOKEEPER --topic test
```
```
 docker run -p 2181:2181 -p 9092:9092 --env KAFKA_LISTENERS=LISTENER_BOB://localhost:9092,LISTENER_ALICE://172.17.0.1:9092 --name kafka -d -it arm/kafka:221 sleep 50000
```


## Run kafka inside the container
```
$KAFKA_HOME/bin/zookeeper-server-start.sh $KAFKA_HOME/config/zookeeper.properties &
```
And another one
```
$KAFKA_HOME/bin/kafka-server-start.sh /tmp/custom_config/server.properties &
```


## Show kafka topics
```
$KAFKA_HOME/bin/kafka-topics.sh --bootstrap-server 172.17.0.2:9092 --list 

$KAFKA_HOME/bin/kafka-consumer-groups.sh --bootstrap-server 172.17.0.2:9092 --list

$KAFKA_HOME/bin/kafka-consumer-groups.sh --bootstrap-server 172.17.0.2:9092 --group payments_group --describe

```

## Show Messages in the topic
```
$KAFKA_HOME/bin/kafka-console-consumer.sh --bootstrap-server 172.17.0.2:9092 --topic payments --from-beginning
```

## Setting up MySql
This one will be used: https://hub.docker.com/_/mysql
```
docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=intuit -d mysql
```

Inside the container
```
mysql -u root -p
```

Show databases
```
show databases;
```

Create database
```
CREATE DATABASE payment_system;
```

Create tables
CURRENCY
```
CREATE TABLE currency (id smallint unsigned not null auto_increment, name varchar(20) not null, constraint pk_example primary key (id) );
```

Copy sql script into docker container
```
docker cp /home/oleg/Downloads/intuit/riskengine/src/main/resources/schema.sql d602652edf97:/tmp
```
```
mysql -u root -p payment_system < schema.sql
```

select BIN_TO_UUID(payer_id), first_name, last_name, email from payer;

select BIN_TO_UUID(payment_method_id), bank_account, BIN_TO_UUID(payer_id), payment_method_type_id from payment_method;

select * from payment_method_type;

select BIN_TO_UUID(payment_method_id), bank_account, BIN_TO_UUID(payer_id), payment_method_type_id from payment_method where payer_id=UUID_TO_BIN('6a6e193f-9270-11e9-b2fe-0242ac110003');

https://phauer.com/2016/uuids-hibernate-mysql/
