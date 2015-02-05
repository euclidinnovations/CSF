package com.euclid.persistence.Item.dao;

import com.euclid.persistence.Item.model.Item;

public interface ItemDAO {
	
		  void persistItem(Item item);
		  
		  Item findItemById(String id);
		  
		  void updateItem(Item item);
		  
		  void deleteItem(Item item);
		  
}