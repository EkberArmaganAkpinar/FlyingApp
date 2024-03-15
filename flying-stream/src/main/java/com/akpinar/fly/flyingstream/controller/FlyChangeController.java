package com.akpinar.fly.flyingstream.controller;

import com.akpinar.fly.flyingstream.config.KafkaTopicConfigData;
import com.akpinar.fly.flyingstream.dto.FlyChangeDto;
import com.akpinar.fly.flyingstream.producer.impl.FlyStreamProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/akpinar/fly")
public class FlyChangeController {
    private final FlyStreamProducer flyStreamProducer;
    private final KafkaTopicConfigData kafkaTopicConfigData;

    public FlyChangeController(FlyStreamProducer flyStreamProducer, KafkaTopicConfigData kafkaTopicConfigData) {
        this.flyStreamProducer = flyStreamProducer;
        this.kafkaTopicConfigData = kafkaTopicConfigData;
    }

    @PostMapping("/change")
    public ResponseEntity<String> changeFly(@RequestBody FlyChangeDto flyChangeDto){
     flyStreamProducer.send(kafkaTopicConfigData.getTopicName(),flyChangeDto.getId(), flyChangeDto);
        return ResponseEntity.ok("Kafka Message was send");
    }

}
