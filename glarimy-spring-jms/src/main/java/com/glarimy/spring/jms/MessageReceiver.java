package com.glarimy.spring.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

	@JmsListener(destination = "com.glarimy.book")
	public void receiveMessage(@Payload Book book, @Header(name = "sender") String sender) {
		System.out.println("Received " + book + " from " + sender);
	}
}
