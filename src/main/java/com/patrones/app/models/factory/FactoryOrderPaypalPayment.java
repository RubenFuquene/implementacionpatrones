package com.patrones.app.models.factory;

import com.patrones.app.models.Order;
import com.patrones.app.models.OrderWithPaypalPayment;

public class FactoryOrderPaypalPayment extends FactoryOrder {

	@Override
	public Order createOrder() {
		return new OrderWithPaypalPayment();
	}

}
