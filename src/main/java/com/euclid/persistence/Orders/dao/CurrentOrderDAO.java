package com.euclid.persistence.Orders.dao;

import java.util.ArrayList;
import java.util.List;

import com.euclid.persistence.Orders.model.CurrentOrder;

public interface CurrentOrderDAO {
	
		  void persistCurrentOrder(CurrentOrder currentOrder);
		  
		  CurrentOrder findCurrentOrderById(String id);
		  
		  void updateCurrentOrder(CurrentOrder currentOrder);
		  
		  void deleteCurrentOrder(CurrentOrder currentOrder);

		  List<Object[]> getLookupItems(String orderId);

		boolean exists(String orderID, String productSKU);
}