package com.booknest.dto;

public class ReviewDTO {

	private Long id;

	private Long userId;

	private Long bookId;

	private Integer rating;

	private String comment;

	public ReviewDTO() {
		super();
	}

	public ReviewDTO(Long id, Long userId, Long bookId, Integer rating, String comment) {
		super();
		this.id = id;
		this.userId = userId;
		this.bookId = bookId;
		this.rating = rating;
		this.comment = comment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
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
