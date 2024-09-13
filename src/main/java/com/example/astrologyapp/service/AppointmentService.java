package com.example.astrologyapp.service;

import com.example.astrologyapp.model.dto.AppointmentDto;
import com.example.astrologyapp.model.dto.ShowAppointmentsDto;

import java.time.LocalTime;
import java.util.List;

public interface AppointmentService {
    List<LocalTime> getAvailableSlots(String date, int duration);

    void saveAppointment(AppointmentDto appointmentDto);

    List<ShowAppointmentsDto> getAppointmentForUser();

}
