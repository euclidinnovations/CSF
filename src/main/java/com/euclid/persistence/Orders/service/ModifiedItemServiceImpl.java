package com.euclid.persistence.Orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.euclid.persistence.Orders.dao.ModifiedItemDAO;
import com.euclid.persistence.Orders.model.ModifiedItem;

@Service("modifiedItemService")
public class ModifiedItemServiceImpl implements ModifiedItemService{

	@Autowired
	ModifiedItemDAO modifiedItemDAO;
	
	@Override
	@Transactional
	public void persistModifiedItem(ModifiedItem modifiedItem) {
		modifiedItemDAO.persistModifiedItem(modifiedItem);
		
	}

	@Override
	@Transactional
	public void updateModifiedItem(ModifiedItem modifiedItem) {
		modifiedItemDAO.updateModifiedItem(modifiedItem);
		
	}
	@Override
	@Transactional
	public ModifiedItem findModifiedItemById(String id) {
		return modifiedItemDAO.findModifiedItemById(id);
	}

	@Override
	@Transactional
	public void deleteModifiedItem(ModifiedItem modifiedItem) {
		modifiedItemDAO.deleteModifiedItem(modifiedItem);
		
	}
	
	@Override
	@Transactional
	public List<Object[]> getLookupItems(String orderId) {		
		return modifiedItemDAO.getLookupItems(orderId);
		
	}

	@Override
	@Transactional
	public void updateMItem(String orderId, String key, String value) {
		 modifiedItemDAO.updateMItem(orderId,key,value);
		
	}

	@Override
	@Transactional
	public boolean exists(String modID) {
		// TODO Auto-generated method stub
		return modifiedItemDAO.exists(modID);
	}

	@Override
	@Transactional
	public void deleteAll(String orderId) {
		// TODO Auto-generated method stub
		 modifiedItemDAO.deleteAll(orderId);
	}

}