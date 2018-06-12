package com.glarimy.library.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.glarimy.library.api.Book;
import com.glarimy.library.api.BookNotFoundExcetion;
import com.glarimy.library.api.Library;

public class LibraryConsole {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("basic.xml");
		Library library = (Library) context.getBean("library");
		try {
			Book book = library.find(1234);
			System.out.println(book.getTitle());
		} catch (BookNotFoundExcetion bnfe) {
			System.out.println("Sorry ... not found!");
		} catch (Exception e) {
			System.out.println("Internal error!");
		}
	}
}
