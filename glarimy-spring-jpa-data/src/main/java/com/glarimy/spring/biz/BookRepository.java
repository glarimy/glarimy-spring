package com.glarimy.spring.biz;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.glarimy.spring.api.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
	List<Book> findByTitle(String title);
	List<Book> findByTitleOrAuthor(String title, String authorName);
}
