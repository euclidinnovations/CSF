package com.euclid.persistence.Orders.dao;

import com.euclid.persistence.Orders.model.Item;

public interface ItemDAO {
	
		  void persistItem(Item item);
		  
		  Item findItemById(String id);
		  
		  void updateItem(Item item);
		  
		  void deleteItem(Item item);
		  
}