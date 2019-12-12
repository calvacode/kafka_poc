package com.example.poc_kafka.conf.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "netshoes.kafka.config")
public class KafkaTopicConfigProperties {

    private String bootstrapAddress;
}
