package com.booknest.entity;

import java.util.Set;

public class Author {

	private Long id;

	private String name;

	private Set<Book> books;

	public Author() {
		super();
	}

	public Author(String name) {
		super();
		this.name = name;
	}

	public Author(Long id, String name, Set<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.books = books;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
}
