package com.example.poc_kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class PocKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocKafkaApplication.class, args);
	}

}
