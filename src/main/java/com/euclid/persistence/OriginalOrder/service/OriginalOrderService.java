package com.euclid.persistence.OriginalOrder.service;

import com.euclid.persistence.OriginalOrder.model.OriginalOrder;

public interface OriginalOrderService {

	void persistOriginalOrder(OriginalOrder originalOrder);

	OriginalOrder findOriginalOrderById(String id);

	void updateOriginalOrder(OriginalOrder originalOrder);

	void deleteOriginalOrder(OriginalOrder originalOrder);
}