package com.patrones.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.patrones.app.models.Order;
import com.patrones.app.models.builders.BuilderOrderCashPayment;
import com.patrones.app.models.builders.BuilderOrderCreditCardPayment;
import com.patrones.app.models.builders.BuilderOrderPaypalMethod;
import com.patrones.app.models.builders.BuilderOrders;
import com.patrones.app.models.director.OrdersDirector;
import com.patrones.app.payment.CashPayment;
import com.patrones.app.payment.CreditCardPayment;
import com.patrones.app.payment.PayPalPayment;
import com.patrones.app.payment.PaymentMethods;
import com.patrones.app.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
    	
    	OrdersDirector director = new OrdersDirector();
    	BuilderOrders builder;
    	Order orderCreated = null;

    	switch (order.getPaymentMethod()) {
	        case PaymentMethods.CREDIT_CARD:
	            builder = new BuilderOrderCreditCardPayment();
	            orderCreated = ((BuilderOrderCreditCardPayment) builder).getOrder();
	            break;
	        case PaymentMethods.PAYPAL:
	        	builder = new BuilderOrderPaypalMethod();
	            orderCreated = ((BuilderOrderPaypalMethod) builder).getOrder();
	            break;
	        case PaymentMethods.CASH:
	        	builder = new BuilderOrderCashPayment();
	            orderCreated = ((BuilderOrderCashPayment) builder).getOrder();
	            break;
	        default:
	            throw new IllegalArgumentException("Invalid payment method: " + order.getPaymentMethod());
	    }
    	
    	director.createOrderMotherDays(builder);
    	
        Order createdOrder = orderService.createOrder(orderCreated);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }
}
