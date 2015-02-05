package com.euclid.persistence.OrderTotal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.euclid.persistence.OrderTotal.dao.OrderTotalDAO;
import com.euclid.persistence.OrderTotal.model.OrderTotal;

@Service("orderTotalService")
public class OrderTotalServiceImpl implements OrderTotalService{

	@Autowired
	OrderTotalDAO orderTotalDAO;
	
	@Override
	@Transactional
	public void persistOrderTotal(OrderTotal orderTotal) {
		orderTotalDAO.persistOrderTotal(orderTotal);
		
	}

	@Override
	@Transactional
	public void updateOrderTotal(OrderTotal orderTotal) {
		orderTotalDAO.updateOrderTotal(orderTotal);
		
	}
	@Override
	@Transactional
	public OrderTotal findOrderTotalById(String id) {
		return orderTotalDAO.findOrderTotalById(id);
	}

	@Override
	@Transactional
	public void deleteOrderTotal(OrderTotal orderTotal) {
		orderTotalDAO.deleteOrderTotal(orderTotal);
		
	}

}