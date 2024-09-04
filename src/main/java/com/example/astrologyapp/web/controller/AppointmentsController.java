package com.example.astrologyapp.web.controller;

import com.example.astrologyapp.model.dto.AppointmentDto;
import com.example.astrologyapp.model.enums.Location;
import com.example.astrologyapp.service.AppointmentService;
import com.example.astrologyapp.service.ConsultationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Controller
public class AppointmentsController {

    private final AppointmentService appointmentService;
    private final ConsultationService consultationService;

    public AppointmentsController(AppointmentService appointmentService, ConsultationService consultationService) {
        this.appointmentService = appointmentService;
        this.consultationService = consultationService;
    }

    @GetMapping("/appointment")
    public String appointments(Model model){
        model.addAttribute("consultations", consultationService.getAllConsultations());
        model.addAttribute("locations", Location.values());
        return "appointment";
    }

    @GetMapping("/appointments")
    public ResponseEntity<List<LocalTime>> getAppointments(@RequestParam String date,
                                                           @RequestParam int duration) {
        List<LocalTime> availableSlots = appointmentService.getAvailableSlots(date, duration);

        if (availableSlots.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(availableSlots);
    }

    @PostMapping("/save-appointment")
    public ResponseEntity<?> saveAppointment(@RequestBody AppointmentDto appointmentDto) {

        return ResponseEntity.ok().body(Map.of("success", true));
    }

}
