package com.euclid.persistence.ModifiedItem.service;

import com.euclid.persistence.ModifiedItem.model.ModifiedItem;

public interface ModifiedItemService {

	void persistModifiedItem(ModifiedItem modifiedItem);

	ModifiedItem findModifiedItemById(String id);

	void updateModifiedItem(ModifiedItem modifiedItem);

	void deleteModifiedItem(ModifiedItem modifiedItem);
}