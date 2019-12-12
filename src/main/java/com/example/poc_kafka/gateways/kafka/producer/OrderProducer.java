package com.example.poc_kafka.gateways.kafka.producer;

import com.example.poc_kafka.gateways.json.OrderJson;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String, OrderJson> customerJsonKafkaTemplate;

    public void publish(final OrderJson orderJson) {
        customerJsonKafkaTemplate.send("TOPIC_3", orderJson);
    }
}
