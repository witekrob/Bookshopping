package com.witek.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;
private String name;
private String surname;
private String country;
@OneToMany(cascade=CascadeType.PERSIST,mappedBy="author")
private List<Book> booksy=new ArrayList<Book>();

public Author() {}
public  Author(String name, String surname,String country) {
	this.country=country;
	this.name=name;
	this.surname=surname;
}


@Override
public String toString() {
	return "Author [id=" + id + ", name=" + name + ", surname=" + surname + ", country=" + country + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((country == null) ? 0 : country.hashCode());
	result = prime * result + (int) (id ^ (id >>> 32));
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
	Author other = (Author) obj;
	if (country == null) {
		if (other.country != null)
			return false;
	} else if (!country.equals(other.country))
		return false;
	if (id != other.id)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (surname == null) {
		if (other.surname != null)
			return false;
	} else if (!surname.equals(other.surname))
		return false;
	return true;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public List<Book> getBooksy() {
	return booksy;
}
public void setBooksy(List<Book> booksy) {
	this.booksy = booksy;
}
}
