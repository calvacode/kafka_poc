package com.example.poc_kafka.conf.kafka.producer;

import com.example.poc_kafka.conf.properties.KafkaTopicConfigProperties;
import com.example.poc_kafka.gateways.json.OrderJson;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class KafkaOrderProducerConfig {

    private final KafkaTopicConfigProperties kafkaTopicConfigProperties;

    @Bean
    public ProducerFactory<String, OrderJson> producerFactory() {
        final Map<String, Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaTopicConfigProperties.getBootstrapAddress());
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configs);
    }

    @Bean
    public KafkaTemplate<String, OrderJson> orderJsonKafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
