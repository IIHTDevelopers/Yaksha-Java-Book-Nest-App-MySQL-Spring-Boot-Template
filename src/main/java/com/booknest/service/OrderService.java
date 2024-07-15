package com.booknest.service;

import java.util.List;

import com.booknest.dto.OrderDTO;

public interface OrderService {

	OrderDTO placeOrder(OrderDTO orderDTO);

	OrderDTO getOrderById(Long orderId);

	List<OrderDTO> getOrdersForUser(Long userId);

	OrderDTO updateOrderStatus(Long orderId, String status);

	OrderDTO processPayment(Long orderId);

	void cancelOrder(Long orderId);
}
