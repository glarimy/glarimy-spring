package com.glarimy.boot.first;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.glarimy.boot.model.Book;

@Repository
public interface FirstRepository extends CrudRepository<Book, Integer> {

}
