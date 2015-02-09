package com.euclid.persistence.Orders.dao;

import com.euclid.persistence.Orders.model.ModifiedItem;

public interface ModifiedItemDAO {
	
		  void persistModifiedItem(ModifiedItem modifiedItem);
		  
		  ModifiedItem findModifiedItemById(String id);
		  
		  void updateModifiedItem(ModifiedItem modifiedItem);
		  
		  void deleteModifiedItem(ModifiedItem modifiedItem);
		  
}