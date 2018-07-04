package com.glarimy.spring.api;

import java.util.List;

public interface Library {
	public void add(Book book) throws LibraryException;

	public Book find(int isbn) throws LibraryException;

	public void update(Book book) throws LibraryException;

	public List<Book> find(String author) throws LibraryException;
}
