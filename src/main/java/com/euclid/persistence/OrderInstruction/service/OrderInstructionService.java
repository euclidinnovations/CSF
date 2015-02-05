package com.euclid.persistence.OrderInstruction.service;

import com.euclid.persistence.OrderInstruction.model.OrderInstruction;

public interface OrderInstructionService {

	void persistOrderInstruction(OrderInstruction orderInstruction);

	OrderInstruction findOrderInstructionById(String id);

	void updateOrderInstruction(OrderInstruction orderInstruction);

	void deleteOrderInstruction(OrderInstruction orderInstruction);
}