package com.felo.springWebApp.repository;

import com.felo.springWebApp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
