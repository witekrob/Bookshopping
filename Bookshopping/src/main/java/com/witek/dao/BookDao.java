package com.witek.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.witek.model.Book;
@Repository
@Transactional
public interface BookDao extends CrudRepository<Book, Long>  {

}
