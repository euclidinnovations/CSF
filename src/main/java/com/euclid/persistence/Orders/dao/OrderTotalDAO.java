package com.euclid.persistence.Orders.dao;

import com.euclid.persistence.Orders.model.OrderTotal;

public interface OrderTotalDAO {
	
		  void persistOrderTotal(OrderTotal orderTotal);
		  
		  OrderTotal findOrderTotalById(String id);
		  
		  void updateOrderTotal(OrderTotal orderTotal);
		  
		  void deleteOrderTotal(OrderTotal orderTotal);
		  
		  void deleteAll();

		Boolean exists(String id);
		  
}