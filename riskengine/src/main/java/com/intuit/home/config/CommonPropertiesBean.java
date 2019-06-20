package com.intuit.home.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * Holds all properties which are in application.properties
 */
@Component
public class CommonPropertiesBean {
    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Value(value = "${kafka.topic.name}")
    private String kafkaTopicName;

    @Value(value = "${kafka.group.id}")
    private String kafkaGroupId;


    public String getBootstrapAddress() {
        return bootstrapAddress;
    }

    public void setBootstrapAddress(String bootstrapAddress) {
        this.bootstrapAddress = bootstrapAddress;
    }

    public String getKafkaTopicName() {
        return kafkaTopicName;
    }

    public void setKafkaTopicName(String kafkaTopicName) {
        this.kafkaTopicName = kafkaTopicName;
    }

    public String getKafkaGroupId() {
        return kafkaGroupId;
    }

    public void setKafkaGroupId(String kafkaGroupId) {
        this.kafkaGroupId = kafkaGroupId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{bootstrapAddress='").append(bootstrapAddress).append('\'');
        sb.append(", kafkaTopicName='").append(kafkaTopicName).append('\'');
        sb.append(", kafkaGroupId='").append(kafkaGroupId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
