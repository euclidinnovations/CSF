package com.euclid.persistence.OrderInstruction.dao;

import com.euclid.persistence.OrderInstruction.model.OrderInstruction;

public interface OrderInstructionDAO {
	
		  void persistOrderInstruction(OrderInstruction orderInstruction);
		  
		  OrderInstruction findOrderInstructionById(String id);
		  
		  void updateOrderInstruction(OrderInstruction orderInstruction);
		  
		  void deleteOrderInstruction(OrderInstruction orderInstruction);
		  
}