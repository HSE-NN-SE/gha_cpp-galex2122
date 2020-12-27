package com.giggle.team.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    @Value("chat-topic")
    String kafkaTopic;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String data) {
        logger.info("KafkaProducer.send:: Topic : {} Data: {}", kafkaTopic, data);
        kafkaTemplate.send(kafkaTopic, data);
    }

}