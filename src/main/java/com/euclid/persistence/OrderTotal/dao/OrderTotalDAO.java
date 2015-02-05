package com.euclid.persistence.OrderTotal.dao;

import com.euclid.persistence.OrderTotal.model.OrderTotal;

public interface OrderTotalDAO {
	
		  void persistOrderTotal(OrderTotal orderTotal);
		  
		  OrderTotal findOrderTotalById(String id);
		  
		  void updateOrderTotal(OrderTotal orderTotal);
		  
		  void deleteOrderTotal(OrderTotal orderTotal);
		  
}