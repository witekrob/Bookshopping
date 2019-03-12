package com.witek.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.witek.model.Book;
@Repository
@Transactional
public interface BookDao extends CrudRepository<Book, Long>  {
	
public List<Book> findAllByOrderByTitle();

public List<Book> findAllByOrderByAuthorName();

public List<Book> findAllByOrderByAuthorSurname();

public List<Book> findAllByOrderByAuthorCountry();

public List<Book> findAllByOrderByPages();

public List<Book> findAllByOrderByPrice();
	
}
