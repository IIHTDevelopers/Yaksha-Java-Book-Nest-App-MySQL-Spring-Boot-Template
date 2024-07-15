package com.booknest.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class OrderDTO {

	private Long id;

	private Long userId;

	private Date orderDate;

	private String status;

	private BigDecimal totalAmount;

	private Set<OrderItemDTO> items;

	public OrderDTO() {
		super();
	}

	public OrderDTO(Long id, Long userId, Date orderDate, String status, BigDecimal totalAmount,
			Set<OrderItemDTO> items) {
		super();
		this.id = id;
		this.userId = userId;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Set<OrderItemDTO> getItems() {
		return items;
	}

	public void setItems(Set<OrderItemDTO> items) {
		this.items = items;
	}
}
