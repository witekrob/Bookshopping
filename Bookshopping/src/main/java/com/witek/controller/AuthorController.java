package com.witek.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.witek.dao.AuthorDao;
import com.witek.model.Author;
import com.witek.model.Book;

@Controller
public class AuthorController {
private AuthorDao authorDao;
@Autowired
public AuthorController(AuthorDao dao) {
	this.authorDao=dao;
}
@GetMapping("/searchBy")
public String findByA() {
	return "searchBy";
}
@PostMapping("/searchBy")
public String findBy(Model model,@RequestParam String findingMethod, @RequestParam String country,@RequestParam String name,@RequestParam String surname ){
	System.out.println("szukam po : " +  findingMethod);
	List<Author> authors = new ArrayList<Author>();
	switch (findingMethod) {
	case "nameAndSurname": 
		authors = authorDao.findByNameAndSurname(name, surname);
		authors.forEach(System.out::println);
		break;
	case "country" :
		authors = authorDao.findByCountry(country);
		authors.forEach(System.out::println);
		break;
	}
	model.addAttribute("authors",authors);
	return "ByAuthor";
}
	
}
