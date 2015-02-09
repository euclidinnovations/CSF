package com.euclid.persistence.Orders.dao;

import com.euclid.persistence.Orders.model.OriginalOrder;

public interface OriginalOrderDAO {
	
		  void persistOriginalOrder(OriginalOrder originalOrder);
		  
		  OriginalOrder findOriginalOrderById(String id);
		  
		  void updateOriginalOrder(OriginalOrder originalOrder);
		  
		  void deleteOriginalOrder(OriginalOrder originalOrder);
		  
}