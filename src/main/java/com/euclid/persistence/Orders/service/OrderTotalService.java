package com.euclid.persistence.Orders.service;

import com.euclid.persistence.Orders.model.OrderTotal;

public interface OrderTotalService {

	void persistOrderTotal(OrderTotal orderTotal);

	OrderTotal findOrderTotalById(String id);

	void updateOrderTotal(OrderTotal orderTotal);

	void deleteOrderTotal(OrderTotal orderTotal);
	
	void deleteAll();
}