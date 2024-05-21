package com.patrones.app.models;

import com.patrones.app.payment.PaymentMethods;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CashPayment")
public class OrderWithCashPayment extends Order {
	private PaymentMethods cashMethod = PaymentMethods.CASH;

	
	public OrderWithCashPayment() {
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
