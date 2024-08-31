package com.example.astrologyapp.model;

import com.example.astrologyapp.model.base.BaseEntity;
import com.example.astrologyapp.model.enums.PaymentMethod;
import com.example.astrologyapp.model.enums.ConsultationStatus;
import jakarta.persistence.*;

import java.util.Set;

@Table
@Entity(name = "consultations")
public class Consultation extends BaseEntity {
    private String type;
    private double price;
    private int duration;
    @ManyToMany
    @JoinTable(name = "consultations_customers",
            joinColumns = @JoinColumn(name = "consultation_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"))
    private Set<Customer> customers;
    @OneToMany(mappedBy = "consultation")
    private Set<Appointment> appointments;
    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }
}
