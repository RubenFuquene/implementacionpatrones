package com.patrones.app.services;

import org.springframework.stereotype.Service;

import com.patrones.app.payment.CashPayment;
import com.patrones.app.payment.CreditCardPayment;
import com.patrones.app.payment.PayPalPayment;
import com.patrones.app.payment.PaymentContext;
import com.patrones.app.payment.PaymentMethods;

@Service
public class PaymentService {
	
	private final PaymentContext paymentContext;
	
	public PaymentService(PaymentContext paymentContext) {
		this.paymentContext = paymentContext;
	}
	
	public void processPayment(PaymentMethods method, double amount) {
		switch (method) {
	        case PaymentMethods.CREDIT_CARD:
	            paymentContext.setPaymentStrategy(new CreditCardPayment());
	            break;
	        case PaymentMethods.PAYPAL:
	            paymentContext.setPaymentStrategy(new PayPalPayment());
	            break;
	        case PaymentMethods.CASH:
	            paymentContext.setPaymentStrategy(new CashPayment());
	            break;
	        default:
	            throw new IllegalArgumentException("Invalid payment method: " + method);
	    }
		paymentContext.executePayment(amount);
    }
}
