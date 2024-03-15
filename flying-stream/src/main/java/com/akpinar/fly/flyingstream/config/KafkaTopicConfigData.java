package com.akpinar.fly.flyingstream.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "topic-config")
public class KafkaTopicConfigData {
    private String topicName;
    private Integer partitions;
    private Integer replicas;
}
