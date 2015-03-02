package com.euclid.persistence.Orders.service;

import java.util.List;

import com.euclid.persistence.Orders.model.Order;

public interface OrderService {

	void persistOrder(Order order);

	Order findOrderById(String id);

	void updateOrder(Order order);

	void deleteOrder(Order order);
	
	void deleteAll();

	Boolean exists(String id);

	List<String> getAllOrderIDS();

	List<String> getCompletedOrderIDS();

	List<String> getCurrentOrderIDS();
}