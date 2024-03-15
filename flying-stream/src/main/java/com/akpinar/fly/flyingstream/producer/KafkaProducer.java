package com.akpinar.fly.flyingstream.producer;




public interface KafkaProducer<Long ,FlyChangeDto> {

    void send(String topicName, Long key , FlyChangeDto value);
}
