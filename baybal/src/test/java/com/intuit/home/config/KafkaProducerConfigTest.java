package com.intuit.home.config;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import static com.intuit.home.TestConstants.KAFKA_BOOTSTRAP;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


public class KafkaProducerConfigTest {
    @InjectMocks KafkaProducerConfig kafkaProducerConfig;
    @Mock CommonPropertiesBean commonPropertiesBean;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        when(commonPropertiesBean.getBootstrapAddress()).thenReturn(KAFKA_BOOTSTRAP);
    }

    @Test
    public void producerFactory() {
        ProducerFactory<String, String> producerFactory = kafkaProducerConfig.producerFactory();
        assertNotNull(producerFactory.createProducer());
    }

    @Test
    public void kafkaTemplate() {
        KafkaTemplate<String, String> kafkaTemplate = kafkaProducerConfig.kafkaTemplate();
        assertNotNull(kafkaTemplate);
    }
}
