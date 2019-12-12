package com.example.poc_kafka.gateways.kafka.consumer;

import com.example.poc_kafka.gateways.json.OrderJson;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    @KafkaListener(topics = {"TOPIC_3"}, containerFactory = "concurrentKafkaListenerContainerFactory")
    public void listen(final OrderJson message) {
        System.out.println("!!!!!!!!!! RECEBI UMA MENSAGEM!!!!!!!!!!! ORDER: " + message);
    }
}
