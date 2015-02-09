package com.euclid.persistence.Orders.service;

import com.euclid.persistence.Orders.model.Order;

public interface OrderService {

	void persistOrder(Order order);

	Order findOrderById(String id);

	void updateOrder(Order order);

	void deleteOrder(Order order);
	
	void deleteAll();
}