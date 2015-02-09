package com.euclid.persistence.Orders.service;

import com.euclid.persistence.Orders.model.Item;

public interface ItemService {

	void persistItem(Item item);

	Item findItemById(String id);

	void updateItem(Item item);

	void deleteItem(Item item);
}