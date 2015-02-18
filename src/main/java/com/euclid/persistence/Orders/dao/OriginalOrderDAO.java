package com.euclid.persistence.Orders.dao;

import java.util.List;

import com.euclid.persistence.Orders.model.OriginalOrder;

public interface OriginalOrderDAO {
	
		  void persistOriginalOrder(OriginalOrder originalOrder);
		  
		  OriginalOrder findOriginalOrderById(String id);
		  
		  void updateOriginalOrder(OriginalOrder originalOrder);
		  
		  void deleteOriginalOrder(OriginalOrder originalOrder);

		boolean exists(String orderID, String sku);

		List<String> getAllOriginalItemSKUs(String orderID);
		  
}