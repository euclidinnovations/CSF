package com.euclid.persistence.Orders.dao;

import com.euclid.persistence.Orders.model.OrderInstruction;

public interface OrderInstructionDAO {
	
		  void persistOrderInstruction(OrderInstruction orderInstruction);
		  
		  OrderInstruction findOrderInstructionById(String id);
		  
		  void updateOrderInstruction(OrderInstruction orderInstruction);
		  
		  void deleteOrderInstruction(OrderInstruction orderInstruction);

		  void deleteAll();

		Boolean exists(String id);
		  
		  
		  
}