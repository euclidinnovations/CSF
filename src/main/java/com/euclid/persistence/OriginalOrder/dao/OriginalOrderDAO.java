package com.euclid.persistence.OriginalOrder.dao;

import com.euclid.persistence.OriginalOrder.model.OriginalOrder;

public interface OriginalOrderDAO {
	
		  void persistOriginalOrder(OriginalOrder originalOrder);
		  
		  OriginalOrder findOriginalOrderById(String id);
		  
		  void updateOriginalOrder(OriginalOrder originalOrder);
		  
		  void deleteOriginalOrder(OriginalOrder originalOrder);
		  
}