package com.example.astrologyapp.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ShowAppointmentsDto {
    private String consultation;
    private String location;
    private String dateTime;
    private String dateTimeMade;
    private String comment;
    private String status;

    public String getConsultation() {
        return consultation;
    }

    public void setConsultation(String consultation) {
        this.consultation = consultation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateTimeMade() {
        return dateTimeMade;
    }

    public void setDateTimeMade(String dateTimeMade) {
        this.dateTimeMade = dateTimeMade;
    }
}
