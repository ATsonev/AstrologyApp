package com.example.astrologyapp.model;

import com.example.astrologyapp.model.base.BaseEntity;
import com.example.astrologyapp.model.enums.PaymentMethod;
import com.example.astrologyapp.model.enums.ConsultationStatus;
import jakarta.persistence.*;

import java.util.Set;

@Table
@Entity(name = "consultations")
public class Consultation extends BaseEntity {
    private String name;
    private double price;
    private int duration;
    @ManyToMany
    @JoinTable(name = "consultations_customers",
            joinColumns = @JoinColumn(name = "consultation_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"))
    private Set<User> customers;
    @OneToMany(mappedBy = "consultation")
    private Set<Appointment> appointments;

    public Set<User> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<User> customers) {
        this.customers = customers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
