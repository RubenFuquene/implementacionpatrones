package com.patrones.app.models;

import com.patrones.app.payment.PaymentMethods;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CreditCardPayment")
public class OrderWithCreditCardPayment extends Order {
	
	private PaymentMethods cashMethod = PaymentMethods.CASH;

	public OrderWithCreditCardPayment() {
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
