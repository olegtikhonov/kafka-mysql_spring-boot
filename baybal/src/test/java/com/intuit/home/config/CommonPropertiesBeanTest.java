package com.intuit.home.config;

import org.junit.Before;
import org.junit.Test;

import static com.intuit.home.TestConstants.*;
import static org.junit.Assert.*;

public class CommonPropertiesBeanTest {
    private CommonPropertiesBean commonPropertiesBean;


    @Before
    public void setUp() throws Exception {
        commonPropertiesBean = new CommonPropertiesBean();
    }

    @Test
    public void getBootstrapAddress() {
        commonPropertiesBean.setBootstrapAddress(KAFKA_BOOTSTRAP);
        assertEquals(KAFKA_BOOTSTRAP, commonPropertiesBean.getBootstrapAddress());
    }

    @Test
    public void getKafkaTopicName() {
        commonPropertiesBean.setKafkaTopicName(KAFKA_TOPIC);
        assertEquals(KAFKA_TOPIC, commonPropertiesBean.getKafkaTopicName());
    }

    @Test
    public void getKafkaPartitionAmount() {
        commonPropertiesBean.setKafkaPartitionAmount(PARTITION_NUMBER);
        assertEquals(PARTITION_NUMBER, commonPropertiesBean.getKafkaPartitionAmount());
    }

    @Test
    public void getKafkaReplicationFactor() {
        commonPropertiesBean.setKafkaReplicationFactor(REPLICATION_FACTOR);
        assertEquals(REPLICATION_FACTOR, commonPropertiesBean.getKafkaReplicationFactor());
    }
}
