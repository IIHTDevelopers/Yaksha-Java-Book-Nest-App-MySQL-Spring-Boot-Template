package com.booknest.entity;

import java.math.BigDecimal;

public class OrderItem {

	private Long id;

	private Order order;

	private Book book;

	private Integer quantity;

	private BigDecimal price;

	public OrderItem() {
		super();
	}

	public OrderItem(Long id, Order order, Book book, Integer quantity, BigDecimal price) {
		super();
		this.id = id;
		this.order = order;
		this.book = book;
		this.quantity = quantity;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
