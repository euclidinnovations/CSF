package com.euclid.persistence.Orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.euclid.persistence.Orders.dao.CurrentOrderDAO;
import com.euclid.persistence.Orders.model.CurrentOrder;

@Service("currentOrderService")
public class CurrentOrderServiceImpl implements CurrentOrderService{

	@Autowired
	CurrentOrderDAO currentOrderDAO;
	
	@Override
	@Transactional
	public void persistCurrentOrder(CurrentOrder currentOrder) {
		currentOrderDAO.persistCurrentOrder(currentOrder);
		
	}

	@Override
	@Transactional
	public void updateCurrentOrder(CurrentOrder currentOrder) {
		currentOrderDAO.updateCurrentOrder(currentOrder);
		
	}
	@Override
	@Transactional
	public CurrentOrder findCurrentOrderById(String id) {
		return currentOrderDAO.findCurrentOrderById(id);
	}

	@Override
	@Transactional
	public void deleteCurrentOrder(CurrentOrder currentOrder) {
		currentOrderDAO.deleteCurrentOrder(currentOrder);
		
	}
	
	@Override
	@Transactional
	public List<Object[]> getLookupItems(String orderId) {		
		return currentOrderDAO.getLookupItems(orderId);
		
	}

	@Override
	@Transactional
	public boolean exists(String orderID, String productSKU) {
		// TODO Auto-generated method stub
		return currentOrderDAO.exists(orderID,productSKU);
	}

}