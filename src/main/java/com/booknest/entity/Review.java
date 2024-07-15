package com.booknest.entity;

public class Review {

	private Long id;

	private User user;

	private Book book;

	private Integer rating;

	private String comment;

	public Review() {
		super();
	}

	public Review(Long id, User user, Book book, Integer rating, String comment) {
		super();
		this.id = id;
		this.user = user;
		this.book = book;
		this.rating = rating;
		this.comment = comment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
