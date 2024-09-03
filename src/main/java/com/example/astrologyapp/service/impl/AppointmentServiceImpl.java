package com.example.astrologyapp.service.impl;

import com.example.astrologyapp.model.Appointment;
import com.example.astrologyapp.repository.AppointmentRepository;
import com.example.astrologyapp.service.AppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final ModelMapper modelMapper;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, ModelMapper modelMapper) {
        this.appointmentRepository = appointmentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<LocalTime> getAvailableSlots(String date, int duration) {
        LocalDate localDate = LocalDate.parse(date);
        List<LocalDateTime> availableSlots = getSlots(localDate);

        LocalDateTime startDate = localDate.atStartOfDay();
        LocalDateTime endDate = localDate.atTime(23, 59, 59, 999999999);
        List<Appointment> appointments = appointmentRepository.findAllByDateTimeBetween(startDate, endDate);

        for (Appointment appointment : appointments) {
            LocalDateTime appointmentStart = appointment.getDateTime();
            int durationMinutes = appointment.getConsultation().getDuration();
            LocalDateTime appointmentEnd = appointmentStart.plusMinutes(durationMinutes);

            while (!appointmentStart.isEqual(appointmentEnd)){
                availableSlots.remove(appointmentStart);
                appointmentStart = appointmentStart.plusMinutes(30);
            }
        }

        List<LocalTime> availableTimes = new ArrayList<>();
        for (LocalDateTime availableSlot : availableSlots) {
            availableTimes.add(availableSlot.toLocalTime());
        }

        return  getAvailableSlots(availableTimes, duration);
    }

    public List<LocalTime> getAvailableSlots(List<LocalTime> slots, int duration){
        List<LocalTime> availableSlots = new ArrayList<>();
        var result = Double.valueOf(duration);
        var requiredSlots = Math.ceil(result / 30);

        for (int i = 0; i <= slots.size() - requiredSlots; i++) {
            boolean isSlotAvailable = true;
            for (int j = 0; j < requiredSlots - 1; j++) {
                if (!slots.get(i + j).plusMinutes(30).equals(slots.get(i + j + 1))) {
                    isSlotAvailable = false;
                    break;
                }
            }
            if (isSlotAvailable) {
                availableSlots.add(slots.get(i));
            }
        }

        return availableSlots;
    }

    public List<LocalDateTime> getSlots(LocalDate date) {
        List<LocalDateTime> slots = new ArrayList<>();
        LocalTime startTime = LocalTime.of(10, 0);
        LocalTime endTime = LocalTime.of(21, 0);

        LocalDateTime current = date.atTime(startTime);

        do {
            slots.add(current);
            current = current.plusMinutes(30);
        }while (!current.isEqual(date.atTime(endTime)));

        return slots;
    }
}
