package com.booknest.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class Order {

	private Long id;

	private User user;

	private Date orderDate;

	private OrderStatus status;

	private BigDecimal totalAmount;

	private Set<OrderItem> items;

	public Order() {
		super();
	}

	public Order(Long id, User user, Date orderDate, OrderStatus status, BigDecimal totalAmount, Set<OrderItem> items) {
		super();
		this.id = id;
		this.user = user;
		this.orderDate = orderDate;
		this.status = status;
		this.totalAmount = totalAmount;
		this.items = items;
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

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}
}
