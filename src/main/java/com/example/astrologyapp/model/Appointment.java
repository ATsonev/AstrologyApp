package com.example.astrologyapp.model;

import com.example.astrologyapp.model.base.BaseEntity;
import com.example.astrologyapp.model.enums.ConsultationStatus;
import com.example.astrologyapp.model.enums.PaymentMethod;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table
@Entity(name = "appointments")
public class Appointment extends BaseEntity {

    @Column(name = "date_and_time")
    private LocalDateTime dateTime;
    private String comment;
    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;
    private ConsultationStatus status;
    @ManyToOne
    @JoinColumn(name = "consultation_id", referencedColumnName = "id")
    private Consultation consultation;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

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

    public ConsultationStatus getStatus() {
        return status;
    }

    public void setStatus(ConsultationStatus status) {
        this.status = status;
    }
}
