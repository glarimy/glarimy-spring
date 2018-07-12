package com.glarimy.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.glarimy.boot.biz.BookService;
import com.glarimy.boot.model.Book;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Autowired
	private BookService service;

	@Autowired
	@Bean
	public CommandLineRunner run() {
		return (args) -> {
			service.add(new Book(12345, "First Book"));
			service.copy(12345);
		};
	}

}
