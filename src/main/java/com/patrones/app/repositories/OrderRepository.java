package com.patrones.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patrones.app.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	// Métodos de consulta
}
