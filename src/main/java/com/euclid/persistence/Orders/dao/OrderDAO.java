package com.euclid.persistence.Orders.dao;

import java.util.List;

import com.euclid.persistence.Orders.model.Order;

public interface OrderDAO {
	
		  void persistOrder(Order order);
		  
		  Order findOrderById(String id);
		  
		  void updateOrder(Order order);
		  
		  void deleteOrder(Order order);

		  void deleteAll();

		  Boolean exists(String id);

		List<String> getAllOrderIDS();
		  
}