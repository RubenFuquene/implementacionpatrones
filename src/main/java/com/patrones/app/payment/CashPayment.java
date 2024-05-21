package com.patrones.app.payment;

import org.springframework.stereotype.Component;

@Component
public class CashPayment implements PaymentStrategy {

	@Override
	public void pay(double amount) {
		System.out.println("Paid " + amount + " using Cash.");
	}

}
