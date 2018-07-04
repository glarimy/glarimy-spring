package com.glarimy.spring.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.glarimy.spring.api.Book;
import com.glarimy.spring.api.Library;
import com.glarimy.spring.api.LibraryException;

@Service
@EnableTransactionManagement
public class GlarimyLibrary implements Library {
	@Autowired
	LibraryDAO dao;
	
	@Autowired
	private BookRepository repo;

	@Override
	@Transactional
	public Book find(int isbn) throws LibraryException {
		return dao.read(isbn);
	}

	@Override
	@Transactional
	public void add(Book book) throws LibraryException {
		book.setTitle("Spring-Data");
		System.out.println("Persisiting");
		repo.save(book);
		System.out.println("Done");
		//dao.create(book);

	}

	@Override
	@Transactional
	public void update(Book book) throws LibraryException {
		dao.update(book);

	}

	@Override
	public List<Book> find(String author) throws LibraryException {
		return dao.find(author);
	}

}
