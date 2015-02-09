package com.euclid.persistence.Orders.service;

import com.euclid.persistence.Orders.model.ModifiedItem;

public interface ModifiedItemService {

	void persistModifiedItem(ModifiedItem modifiedItem);

	ModifiedItem findModifiedItemById(String id);

	void updateModifiedItem(ModifiedItem modifiedItem);

	void deleteModifiedItem(ModifiedItem modifiedItem);
}