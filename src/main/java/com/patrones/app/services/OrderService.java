package com.patrones.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrones.app.models.Order;

@Service
public class OrderService {
	// Inyecta dependencias necesarias
    private final PaymentService paymentService;

    @Autowired
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public Order createOrder(Order order) {
        // Lógica para crear un pedido
        // Utiliza paymentService para procesar el pago
        paymentService.processPayment(order.getAmount());
        return order;
    }
}
