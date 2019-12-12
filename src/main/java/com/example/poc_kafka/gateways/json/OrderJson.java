package com.example.poc_kafka.gateways.json;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderJson {

    private final String orderId;

    private final Long amount;
}
