package com.patrones.app.models;

import com.patrones.app.models.observer.ObserverOrders;

import jakarta.persistence.*;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements ObserverOrders {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public void update(String status) {
        System.out.println("Hola " + name + ", el estado de su pedido ha cambiado a: " + status);
    }

    // Getters y setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
