package com.euclid.persistence.Order.dao;

import com.euclid.persistence.Order.model.Order;

public interface OrderDAO {
	
		  void persistOrder(Order order);
		  
		  Order findOrderById(String id);
		  
		  void updateOrder(Order order);
		  
		  void deleteOrder(Order order);
		  
}