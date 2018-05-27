package com.gomezrondon.kafka.testkafkastreamconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class TestKafkaStreamConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestKafkaStreamConsumerApplication.class, args);
	}
}
