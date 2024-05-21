package com.patrones.app.models;

import com.patrones.app.models.observer.EventManager;
import com.patrones.app.payment.PaymentMethods;

import jakarta.persistence.*;

@Entity
@Table(name = "OORDER")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "order_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double amount;
	private PaymentMethods paymentMethod;
	private double discount;
	private String deliveryDetails;
    private String customerNotes;
    private String status;
    
    @Transient
    public EventManager events;
    
    public Order() {
        this.events = new EventManager();
    }

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public PaymentMethods getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(PaymentMethods typePayment) {
		this.paymentMethod = typePayment;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getDeliveryDetails() {
		return deliveryDetails;
	}
	public void setDeliveryDetails(String deliveryDetails) {
		this.deliveryDetails = deliveryDetails;
	}
	public String getCustomerNotes() {
		return customerNotes;
	}
	public void setCustomerNotes(String customerNotes) {
		this.customerNotes = customerNotes;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
		this.events.notifyObservers(status);
	}
}
