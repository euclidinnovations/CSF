package com.euclid.persistence.Orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.euclid.persistence.Orders.dao.OrderTotalDAO;
import com.euclid.persistence.Orders.model.OrderTotal;

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

	@Override
	public void deleteAll() {
		
		orderTotalDAO.deleteAll();
		
	}

}