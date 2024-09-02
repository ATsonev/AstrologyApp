package com.example.astrologyapp.web.controller;

import com.example.astrologyapp.model.dto.FreeAppointmentsDto;
import com.example.astrologyapp.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Controller
public class AppointmentsController {

    private final AppointmentService appointmentService;

    public AppointmentsController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/appointment")
    public String appointments(){
        return "appointment";
    }

    @GetMapping("/appointments")
    public ResponseEntity<List<LocalTime>> getAppointments(@RequestParam String date) {
        List<LocalTime> availableSlots = appointmentService.getAvailableSlots(date);

        if (availableSlots.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(availableSlots);
    }

}
