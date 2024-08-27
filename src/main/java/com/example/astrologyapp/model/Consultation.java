package com.example.astrologyapp.model;

import com.example.astrologyapp.model.base.BaseEntity;
import com.example.astrologyapp.model.enums.PaymentMethod;
import com.example.astrologyapp.model.enums.ConsultationStatus;
import jakarta.persistence.*;

import java.util.Set;

@Table
@Entity(name = "consultations")
public class Consultation extends BaseEntity {

    private ConsultationStatus status;
    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;
    @ManyToMany
    @JoinTable(name = "consultations_customers",
            joinColumns = @JoinColumn(name = "consultation_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"))
    private Set<Customer> customers;

    @ManyToMany
    @JoinTable(name = "consultations_products",
            joinColumns = @JoinColumn(name = "consultation_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private Set<Product> products;

    public ConsultationStatus getStatus() {
        return status;
    }

    public void setStatus(ConsultationStatus status) {
        this.status = status;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
