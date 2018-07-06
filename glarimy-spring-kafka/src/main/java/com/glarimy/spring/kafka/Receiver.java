package com.glarimy.spring.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver {
	@KafkaListener(topics = {"com.glarimy.book"})
	public void listen(@Payload String message) {
		System.out.println("Received " + message);
	}

}
