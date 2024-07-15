package com.booknest.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.booknest.dto.OrderDTO;
import com.booknest.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public OrderDTO placeOrder(OrderDTO orderDTO) {
		// write your logic here
		return null;
	}

	@Override
	public OrderDTO getOrderById(Long orderId) {
		// write your logic here
		return null;
	}

	@Override
	public List<OrderDTO> getOrdersForUser(Long userId) {
		// write your logic here
		return null;
	}

	@Override
	public OrderDTO updateOrderStatus(Long orderId, String status) {
		// write your logic here
		return null;
	}

	@Override
	public OrderDTO processPayment(Long orderId) {
		// write your logic here
		return null;
	}

	@Override
	public void cancelOrder(Long orderId) {
		// write your logic here
	}
}
