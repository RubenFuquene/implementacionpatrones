package com.patrones.app.models.builders;

import com.patrones.app.models.Order;
import com.patrones.app.models.factory.FactoryOrder;
import com.patrones.app.models.factory.FactoryOrderCreditCardPayment;

public class BuilderOrderCreditCardPayment implements BuilderOrders {

	@SuppressWarnings("unused")
	private double discount;
	
	@Override
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Order getOrder() {
		FactoryOrder factory = new FactoryOrderCreditCardPayment();
		Order newOrder = factory.createOrder();
		return newOrder;
	}
}
