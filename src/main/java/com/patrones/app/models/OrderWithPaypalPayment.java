package com.patrones.app.models;

import com.patrones.app.payment.PaymentMethods;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PaypalPayment")
public class OrderWithPaypalPayment extends Order {

	private PaymentMethods cashMethod = PaymentMethods.CASH;

	public OrderWithPaypalPayment() {
		super();
		this.setPaymentMethod(this.getCashMethod());
	}
	public PaymentMethods getCashMethod() {
		return cashMethod;
	}
	public void setCashMethod(PaymentMethods cashMethod) {
		this.cashMethod = cashMethod;
	}
}
