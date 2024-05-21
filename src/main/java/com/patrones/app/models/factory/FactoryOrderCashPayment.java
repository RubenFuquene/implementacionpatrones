package com.patrones.app.models.factory;

import com.patrones.app.models.Order;
import com.patrones.app.models.OrderWithCashPayment;

public class FactoryOrderCashPayment extends FactoryOrder {

	@Override
	public Order createOrder() {
		return new OrderWithCashPayment();
	}

}
