package com.euclid.persistence.Orders.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.euclid.persistence.Orders.dao.ItemDAO;
import com.euclid.persistence.Orders.model.Item;

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
	
	@Override
	@Transactional
	public Boolean exists(String id) {
		// TODO Auto-generated method stub
		return itemDAO.exists(id);
	}

	@Override
	@Transactional
	public List<String[]> getMappedItems(String itemName, String orderId) {
		// TODO Auto-generated method stub
		return itemDAO.getMappedItems(itemName, orderId);
	}

}