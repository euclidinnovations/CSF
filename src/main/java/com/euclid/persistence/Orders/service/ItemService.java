package com.euclid.persistence.Orders.service;

import java.util.List;

import com.euclid.persistence.Orders.model.Item;

public interface ItemService {

	void persistItem(Item item);

	Item findItemById(String id);

	void updateItem(Item item);

	void deleteItem(Item item);

	Boolean exists(String id);

	List<String> getMappedItems(String itemName);
}