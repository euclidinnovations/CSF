package com.euclid.persistence.Orders.service;

import java.util.List;

import com.euclid.persistence.Orders.model.ModifiedItem;

public interface ModifiedItemService {

	void persistModifiedItem(ModifiedItem modifiedItem);

	ModifiedItem findModifiedItemById(String id);

	void updateModifiedItem(ModifiedItem modifiedItem);

	void deleteModifiedItem(ModifiedItem modifiedItem);
	
	List<Object[]> getLookupItems(String orderId);

	boolean exists(String modID);

	void updateMItem(String orderId, String key, String value);
	
	
	
}