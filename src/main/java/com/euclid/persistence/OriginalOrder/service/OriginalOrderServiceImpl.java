package com.euclid.persistence.OriginalOrder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.euclid.persistence.OriginalOrder.dao.OriginalOrderDAO;
import com.euclid.persistence.OriginalOrder.model.OriginalOrder;

@Service("originalOrderService")
public class OriginalOrderServiceImpl implements OriginalOrderService{

	@Autowired
	OriginalOrderDAO originalOrderDAO;
	
	@Override
	@Transactional
	public void persistOriginalOrder(OriginalOrder originalOrder) {
		originalOrderDAO.persistOriginalOrder(originalOrder);
		
	}

	@Override
	@Transactional
	public void updateOriginalOrder(OriginalOrder originalOrder) {
		originalOrderDAO.updateOriginalOrder(originalOrder);
		
	}
	@Override
	@Transactional
	public OriginalOrder findOriginalOrderById(String id) {
		return originalOrderDAO.findOriginalOrderById(id);
	}

	@Override
	@Transactional
	public void deleteOriginalOrder(OriginalOrder originalOrder) {
		originalOrderDAO.deleteOriginalOrder(originalOrder);
		
	}

}