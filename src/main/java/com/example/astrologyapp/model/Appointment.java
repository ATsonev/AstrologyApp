package com.example.astrologyapp.model;

import com.example.astrologyapp.model.base.BaseEntity;
import com.example.astrologyapp.model.enums.ConsultationStatus;
import com.example.astrologyapp.model.enums.Location;
import com.example.astrologyapp.model.enums.PaymentMethod;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table
@Entity(name = "appointments")
public class Appointment extends BaseEntity {

    @Column(name = "date_and_time")
    private LocalDateTime dateTime;
    private String comment;
    @Column
    @Enumerated(EnumType.STRING)
    private Location location;
    @Column
    @Enumerated(EnumType.STRING)
    private ConsultationStatus status;
    @ManyToOne
    @JoinColumn(name = "consultation_id", referencedColumnName = "id")
    private Consultation consultation;
    @Column(name = "date_and_time_made")
    private LocalDateTime dateTimeMade;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public LocalDateTime getDateTimeMade() {
        return dateTimeMade;
    }

    public void setDateTimeMade(LocalDateTime dateTimeMade) {
        this.dateTimeMade = dateTimeMade;
    }
}
