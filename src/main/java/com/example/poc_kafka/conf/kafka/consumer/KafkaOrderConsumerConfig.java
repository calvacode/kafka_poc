package com.example.poc_kafka.conf.kafka.consumer;

import com.example.poc_kafka.conf.properties.KafkaTopicConfigProperties;
import com.example.poc_kafka.gateways.json.OrderJson;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class KafkaOrderConsumerConfig {

    private final KafkaTopicConfigProperties kafkaTopicConfigProperties;

    private ConsumerFactory<String, OrderJson> consumerFactory(){
        Map<String, Object> configs = new HashMap<>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaTopicConfigProperties.getBootstrapAddress());
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaTopicConfigProperties.getGroup());
        configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, kafkaTopicConfigProperties.getOffsetConfig());

        return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(), new JsonDeserializer<>(OrderJson.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, OrderJson> concurrentKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, OrderJson> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}
