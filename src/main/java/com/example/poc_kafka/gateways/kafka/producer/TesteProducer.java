package com.example.poc_kafka.gateways.kafka.producer;

import com.example.poc_kafka.gateways.json.OrderJson;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TesteProducer {

    private final OrderProducer orderProducer;

    @EventListener(ApplicationReadyEvent.class)
    public void teste(){
        final OrderJson orderJson = OrderJson.builder().amount(9000L).orderId("123456").build();
//        orderProducer.publish(orderJson);
    }
}
