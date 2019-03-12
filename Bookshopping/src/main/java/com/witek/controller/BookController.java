package com.witek.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.witek.dao.AuthorDao;
import com.witek.dao.BookDao;
import com.witek.model.Author;
import com.witek.model.Book;

@Controller
public class BookController {
	private BookDao bookDao;
	private AuthorDao authorDao;

	@Autowired
	public BookController(BookDao dao, AuthorDao aDao) {
		this.bookDao = dao;
		this.authorDao = aDao;
	}

	@RequestMapping("/")
	public String goHome() {
		return "index";
	}

	@GetMapping("/getAllBooks")
	public String getAllBooks(Model model) {
		System.out.println("jestem w serwlecie getALlBooks");
		Iterable<Book> books = bookDao.findAll();
		model.addAttribute("books", books);
		return "showAll";
	}

	@GetMapping("/addBook")
	public String addBook() {
		return "addBook";
	}

	@PostMapping("/addBook")
	public String addBook(@ModelAttribute Book book, @ModelAttribute Author autor, Model model) {
		System.out.println("jestem w serwlecie addBook");
		List<Author> autors = authorDao.findByNameAndSurnameAndYearOfBorn(autor.getName(), autor.getSurname(),
				autor.getYearOfBorn());

		if (autors.isEmpty()) {
			book.setAuthor(autor);
			bookDao.save(book);

		} else {
			System.out.println("jest autor o podanych danych");
			book.setAuthor(autors.get(0));
			bookDao.save(book);
		}
		return "addBook";
	}

	@GetMapping("/sortBy")
	public String sortBy(Model model, @RequestParam String criterium) {
		System.out.println("sortujemy według : " + criterium);
		Iterable<Book> books = new ArrayList<Book>();
		switch (criterium) {
		case "title":
			books=bookDao.findAllByOrderByTitle();
			break;
		case "name":
			books = bookDao.findAllByOrderByAuthorName();
			break;

		case "surname":
			books = bookDao.findAllByOrderByAuthorSurname();
			break;

		case "country":
			books = bookDao.findAllByOrderByAuthorCountry();
			break;

		case "pages":
			books = bookDao.findAllByOrderByPages();
			break;

		case "price":
			books = bookDao.findAllByOrderByPrice();
			break;
		}
		model.addAttribute("books", books);
		return "showAll";
	}
}