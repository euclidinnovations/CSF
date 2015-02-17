package com.euclid.persistence.Orders.dao;

import java.util.ArrayList;
import java.util.List;

import com.euclid.persistence.Orders.model.Item;

public interface ItemDAO {
	
		  void persistItem(Item item);
		  
		  Item findItemById(String id);
		  
		  void updateItem(Item item);
		  
		  void deleteItem(Item item);

		Boolean exists(String id);


		List<String[]> getMappedItems(String itemName, String orderId);
		  
}