package com.example.astrologyapp.service;

import com.example.astrologyapp.model.dto.AppointmentDto;

import java.time.LocalTime;
import java.util.List;

public interface AppointmentService {
    List<LocalTime> getAvailableSlots(String date, int duration);

    void saveAppointment(AppointmentDto appointmentDto);
}
