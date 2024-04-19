package com.stackroute.consumer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableRabbit
@SpringBootApplication
public class ConsumerRecommendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerRecommendApplication.class, args);
	}

}
