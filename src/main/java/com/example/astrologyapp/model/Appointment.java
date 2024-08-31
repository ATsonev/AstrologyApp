package com.example.astrologyapp.model;

import com.example.astrologyapp.model.base.BaseEntity;
import com.example.astrologyapp.model.enums.PaymentMethod;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table
@Entity(name = "products")
public class Appointment extends BaseEntity {

    @Column(name = "date_and_time")
    private LocalDateTime dateTime;
    private String comment;
    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;
    @ManyToOne
    @JoinColumn(name = "consultation_id", referencedColumnName = "id")
    private Consultation consultation;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }
}
