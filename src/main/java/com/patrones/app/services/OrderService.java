package com.patrones.app.services;

import org.springframework.stereotype.Service;

import com.patrones.app.models.Order;
import com.patrones.app.repositories.OrderRepository;

@Service
public class OrderService {
	// Inyecta dependencias necesarias
	private final OrderRepository orderRepository; 
    private final PaymentService paymentService;

    public OrderService(OrderRepository orderRepository, PaymentService paymentService) {
        this.orderRepository = orderRepository;
		this.paymentService = paymentService;
    }

    public Order createOrder(Order order) {
        paymentService.processPayment(order.getPaymentMethod(), order.getAmount());
        return orderRepository.save(order);
    }
}
