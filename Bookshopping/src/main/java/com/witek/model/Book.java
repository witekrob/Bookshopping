package com.witek.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.witek.model.Author;
@Entity
public class Book {

@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", pages=" + pages + ", price=" + price + "]";
	}
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;
private String title;
private int pages;
private int price;
@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
private Author author;


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((author == null) ? 0 : author.hashCode());
	result = prime * result + (int) (id ^ (id >>> 32));
	result = prime * result + pages;
	result = prime * result + price;
	result = prime * result + ((title == null) ? 0 : title.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Book other = (Book) obj;
	if (author == null) {
		if (other.author != null)
			return false;
	} else if (!author.equals(other.author))
		return false;
	if (id != other.id)
		return false;
	if (pages != other.pages)
		return false;
	if (price != other.price)
		return false;
	if (title == null) {
		if (other.title != null)
			return false;
	} else if (!title.equals(other.title))
		return false;
	return true;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getPages() {
	return pages;
}
public void setPages(int pages) {
	this.pages = pages;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public Author getAuthor() {
	return author;
}
public void setAuthor(Author author) {
	this.author = author;
}
}
