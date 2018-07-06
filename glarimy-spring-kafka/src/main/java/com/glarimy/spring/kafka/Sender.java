package com.glarimy.spring.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Value("com.glarimy.book")
	private String topic;

	public void send(String message) {
		kafkaTemplate.send(topic, message);
	}
}
