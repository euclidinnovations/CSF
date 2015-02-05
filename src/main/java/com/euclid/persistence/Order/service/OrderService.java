package com.euclid.persistence.Order.service;

import com.euclid.persistence.Order.model.Order;

public interface OrderService {

	void persistOrder(Order order);

	Order findOrderById(String id);

	void updateOrder(Order order);

	void deleteOrder(Order order);
}