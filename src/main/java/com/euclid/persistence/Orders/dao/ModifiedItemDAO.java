package com.euclid.persistence.Orders.dao;

import java.util.List;

import com.euclid.persistence.Orders.model.ModifiedItem;

public interface ModifiedItemDAO {
	
		  void persistModifiedItem(ModifiedItem modifiedItem);
		  
		  ModifiedItem findModifiedItemById(String id);
		  
		  void updateModifiedItem(ModifiedItem modifiedItem);
		  
		  void deleteModifiedItem(ModifiedItem modifiedItem);

		  List<Object[]> getLookupItems(String orderId);


		void updateMItem(String orderId, String key, String value);

		String getModId(String orderId, String key, String value);

		boolean exists(String modID);
}