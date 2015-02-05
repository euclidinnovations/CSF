package com.euclid.persistence.Item.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.euclid.persistence.Item.dao.ItemDAO;
import com.euclid.persistence.Item.model.Item;

@Service("itemService")
public class ItemServiceImpl implements ItemService{

	@Autowired
	ItemDAO itemDAO;
	
	@Override
	@Transactional
	public void persistItem(Item item) {
		itemDAO.persistItem(item);
		
	}

	@Override
	@Transactional
	public void updateItem(Item item) {
		itemDAO.updateItem(item);
		
	}
	@Override
	@Transactional
	public Item findItemById(String id) {
		return itemDAO.findItemById(id);
	}

	@Override
	@Transactional
	public void deleteItem(Item item) {
		itemDAO.deleteItem(item);
		
	}

}