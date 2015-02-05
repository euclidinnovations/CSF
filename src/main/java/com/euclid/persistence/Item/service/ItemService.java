package com.euclid.persistence.Item.service;

import com.euclid.persistence.Item.model.Item;

public interface ItemService {

	void persistItem(Item item);

	Item findItemById(String id);

	void updateItem(Item item);

	void deleteItem(Item item);
}