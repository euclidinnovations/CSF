package com.euclid.persistence.Orders.dao;

import java.util.ArrayList;
import java.util.List;

import com.euclid.persistence.Orders.model.ModifiedItem;

public interface ModifiedItemDAO {
	
		  void persistModifiedItem(ModifiedItem modifiedItem);
		  
		  ModifiedItem findModifiedItemById(String id);
		  
		  void updateModifiedItem(ModifiedItem modifiedItem);
		  
		  void deleteModifiedItem(ModifiedItem modifiedItem);

		  List<Object[]> getLookupItems(String orderId);
}