package com.witek.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.witek.model.Author;
@Repository
@Transactional
public interface AuthorDao extends CrudRepository<Author, Long> {

List<Author> findByNameAndSurname(String name, String surname);
List<Author> findByCountry(String country);
List<Author> findByNameAndSurnameAndYearOfBorn(String name, String surname,int yearOfBorn);
}
