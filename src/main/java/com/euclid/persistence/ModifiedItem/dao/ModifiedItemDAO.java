package com.euclid.persistence.ModifiedItem.dao;

import com.euclid.persistence.ModifiedItem.model.ModifiedItem;

public interface ModifiedItemDAO {
	
		  void persistModifiedItem(ModifiedItem modifiedItem);
		  
		  ModifiedItem findModifiedItemById(String id);
		  
		  void updateModifiedItem(ModifiedItem modifiedItem);
		  
		  void deleteModifiedItem(ModifiedItem modifiedItem);
		  
}