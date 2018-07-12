package com.glarimy.boot.second;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.glarimy.boot.model.Book;

@Repository
public interface SecondRepository extends CrudRepository<Book, Integer> {

}
