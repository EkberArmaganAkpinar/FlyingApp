package com.akpinar.fly.flyingstream.producer.impl;

import com.akpinar.fly.flyingstream.dto.FlyChangeDto;
import com.akpinar.fly.flyingstream.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class FlyStreamProducer implements KafkaProducer<Long, FlyChangeDto> {
    private Logger LOG = LoggerFactory.getLogger(FlyStreamProducer.class);
    private final KafkaTemplate<Long,FlyChangeDto> kafkaTemplate;

    public FlyStreamProducer(KafkaTemplate<Long, FlyChangeDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(String topicName, Long key, FlyChangeDto value) {
        LOG.info("Sending message = '{}' to topic '{}'", value, topicName);
        kafkaTemplate.send(topicName, value);
    }

}

