package com.glarimy.spring.hysterix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RetailService {
	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "findInCache")
	public Book find(int isbn) {
		Book response = restTemplate.exchange("http://localhost:8098/book/{isbn}", HttpMethod.GET, null,
				new ParameterizedTypeReference<Book>() {
				}, isbn).getBody();
		return response;
	}

	@SuppressWarnings("unused")
	private Book findInCache(int isbn) {
		return new Book(isbn, "Cached Title");
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}