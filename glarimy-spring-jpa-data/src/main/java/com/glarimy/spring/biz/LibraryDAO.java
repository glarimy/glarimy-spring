package com.glarimy.spring.biz;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.glarimy.spring.api.Book;

@Repository
public class LibraryDAO {
	@PersistenceContext(unitName = "lib")
	private EntityManager entityManager;

	public Book read(int isbn) {
		Book book = entityManager.find(Book.class, isbn);
		return book;
	}

	public void create(Book book) {
		entityManager.persist(book);
	}

	public void update(Book book) {
		entityManager.merge(book);
	}

	public List<Book> find(String author) {
		return entityManager
				.createQuery(
						"select b from Book b join b.authors a where a.name=:author")
				.setParameter("author", author).getResultList();
	}
}
