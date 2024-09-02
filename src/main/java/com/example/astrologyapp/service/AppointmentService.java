package com.example.astrologyapp.service;

import java.time.LocalTime;
import java.util.List;

public interface AppointmentService {
    List<LocalTime> getAvailableSlots(String date, int duration);
}
