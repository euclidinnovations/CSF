package com.euclid.persistence.Orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.euclid.persistence.Orders.dao.OrderDAO;
import com.euclid.persistence.Orders.model.Order;

@Service("orderService")
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDAO orderDAO;
	
	@Override
	@Transactional
	public void persistOrder(Order order) {
		orderDAO.persistOrder(order);
		
	}

	@Override
	@Transactional
	public void updateOrder(Order order) {
		orderDAO.updateOrder(order);
		
	}
	@Override
	@Transactional
	public Order findOrderById(String id) {
		return orderDAO.findOrderById(id);
	}

	@Override
	@Transactional
	public void deleteOrder(Order order) {
		orderDAO.deleteOrder(order);
		
	}

	@Override
	@Transactional
	public void deleteAll() {
		orderDAO.deleteAll();		
	}
	
	@Override
	@Transactional
	public Boolean exists(String id) {
		// TODO Auto-generated method stub
		return orderDAO.exists(id);
	}

	@Override
	@Transactional
	public List<String> getAllOrderIDS() {
		// TODO Auto-generated method stub
		return orderDAO.getAllOrderIDS();
	}

}