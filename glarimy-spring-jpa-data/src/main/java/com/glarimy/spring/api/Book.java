package com.glarimy.spring.api;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Book {
	@Id
	protected int isbn;
	protected String title;
	protected double price;
	protected boolean reference;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected List<Person> authors;

	public Book() {
	}

	public Book(int isbn, String title, double price, boolean reference,
			List<Person> authors) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.reference = reference;
		this.authors = authors;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isReference() {
		return reference;
	}

	public void setReference(boolean reference) {
		this.reference = reference;
	}

	public List<Person> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Person> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", isbn=" + isbn + ", price=" + price
				+ ", reference=" + reference + ", authors=" + authors + "]";
	}

}
