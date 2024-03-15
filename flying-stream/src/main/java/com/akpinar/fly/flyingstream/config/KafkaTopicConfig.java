package com.akpinar.fly.flyingstream.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    private final KafkaTopicConfigData kafkaTopicConfigData;

    public KafkaTopicConfig(KafkaTopicConfigData kafkaTopicConfigData) {
        this.kafkaTopicConfigData = kafkaTopicConfigData;
    }

    @Bean
    public NewTopic flyStreamTopic(){
        return TopicBuilder.name(kafkaTopicConfigData.getTopicName())
                .partitions(kafkaTopicConfigData.getPartitions())
                .replicas(kafkaTopicConfigData.getReplicas())
                .build();
    }
}
