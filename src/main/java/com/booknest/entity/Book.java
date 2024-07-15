package com.booknest.entity;

import java.math.BigDecimal;
import java.util.Set;

public class Book {

	private Long id;

	private String title;

	private Author author; // Change from String to Author entity

	private Set<Category> categories;

	private BigDecimal price;

	private String description;

	public Book() {
		super();
	}

	public Book(Long id, String title, Author author, Set<Category> categories, BigDecimal price, String description) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.categories = categories;
		this.price = price;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
