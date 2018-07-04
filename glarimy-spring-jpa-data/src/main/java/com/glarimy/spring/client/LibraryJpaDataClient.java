package com.glarimy.spring.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.glarimy.spring.api.Book;
import com.glarimy.spring.api.Library;
import com.glarimy.spring.api.LibraryException;
import com.glarimy.spring.api.Person;

public class LibraryJpaDataClient {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"lib.xml");

		Library lib = (Library) context.getBean(Library.class);
		try {
			lib.add((Book) context.getBean("java"));
			lib.add((Book) context.getBean("spring"));
			lib.add((Book) context.getBean("mvc"));

			Person Person = new Person();
			Person.setName("Koyya");
			Person.setPhoneNumber(9731423166L);
			List<Person> Persons = new ArrayList<>();
			Persons.add(Person);
			Book book = new Book(8789, "Quick Look", 500, false, Persons);

			lib.add(book);

			Book java = lib.find(22071972);
			java.getAuthors().get(0).setName("Koyya");
			lib.update(java);

			lib.find("Koyya");
		} catch (LibraryException e) {
			e.printStackTrace();
		}
	}
}
