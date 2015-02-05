package com.euclid.persistence.OrderTotal.service;

import com.euclid.persistence.OrderTotal.model.OrderTotal;

public interface OrderTotalService {

	void persistOrderTotal(OrderTotal orderTotal);

	OrderTotal findOrderTotalById(String id);

	void updateOrderTotal(OrderTotal orderTotal);

	void deleteOrderTotal(OrderTotal orderTotal);
}