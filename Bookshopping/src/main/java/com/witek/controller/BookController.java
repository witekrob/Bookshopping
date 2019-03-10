package com.witek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	this.bookDao=dao;
	this.authorDao=aDao;
}
@RequestMapping("/")
public String goHome() {
	return "index";
}
@GetMapping("/getAllBooks")
public String getAllBooks(Model model) {
	System.out.println("jestem w serwlecie getALlBooks");
	Iterable<Book> books = bookDao.findAll();
	books.forEach(System.out::println);
	model.addAttribute("books",books);
	return "showAll";
}
@GetMapping("/addBook")
public String addBook() {
	return "addBook";
}
@PostMapping("/addBook")
public String addBook(@ModelAttribute Book book, @ModelAttribute Author autor, Model model) {
	System.out.println("jestem w serwlecie addBook");
	book.setAuthor(autor);
	autor.getBooksy().add(book);
System.out.println(book.toString());
System.out.println(autor.toString());
bookDao.save(book);
return "addBook";
}

}