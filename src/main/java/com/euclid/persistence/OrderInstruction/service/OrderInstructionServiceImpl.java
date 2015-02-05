package com.euclid.persistence.OrderInstruction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.euclid.persistence.OrderInstruction.dao.OrderInstructionDAO;
import com.euclid.persistence.OrderInstruction.model.OrderInstruction;

@Service("orderInstructionService")
public class OrderInstructionServiceImpl implements OrderInstructionService{

	@Autowired
	OrderInstructionDAO orderInstructionDAO;
	
	@Override
	@Transactional
	public void persistOrderInstruction(OrderInstruction orderInstruction) {
		orderInstructionDAO.persistOrderInstruction(orderInstruction);
		
	}

	@Override
	@Transactional
	public void updateOrderInstruction(OrderInstruction orderInstruction) {
		orderInstructionDAO.updateOrderInstruction(orderInstruction);
		
	}
	@Override
	@Transactional
	public OrderInstruction findOrderInstructionById(String id) {
		return orderInstructionDAO.findOrderInstructionById(id);
	}

	@Override
	@Transactional
	public void deleteOrderInstruction(OrderInstruction orderInstruction) {
		orderInstructionDAO.deleteOrderInstruction(orderInstruction);
		
	}

}