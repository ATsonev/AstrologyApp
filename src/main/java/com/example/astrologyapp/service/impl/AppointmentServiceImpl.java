package com.example.astrologyapp.service.impl;

import com.example.astrologyapp.model.Appointment;
import com.example.astrologyapp.model.Consultation;
import com.example.astrologyapp.model.User;
import com.example.astrologyapp.model.dto.AppointmentDto;
import com.example.astrologyapp.model.enums.ConsultationStatus;
import com.example.astrologyapp.model.enums.Location;
import com.example.astrologyapp.repository.AppointmentRepository;
import com.example.astrologyapp.repository.ConsultationRepository;
import com.example.astrologyapp.repository.UserRepository;
import com.example.astrologyapp.service.AppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final ConsultationRepository consultationRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, ConsultationRepository consultationRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.appointmentRepository = appointmentRepository;
        this.consultationRepository = consultationRepository;
        this.userRepository = userRepository;
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

    //This method save the appointment when user submits the form
    @Override
    public void saveAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment();
        appointment.setComment(appointmentDto.getComment());
        Consultation consultation = consultationRepository
                .findById(appointmentDto.getConsultationId()).orElseThrow(NoSuchElementException::new);
        appointment.setConsultation(consultation);
        appointment.setStatus(ConsultationStatus.PENDING);
        appointment.setLocation(Location.valueOf(appointmentDto.getLocation()));

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        LocalDate localDate = LocalDate.parse(appointmentDto.getDate(), dateFormatter);
        LocalTime localTime = LocalTime.parse(appointmentDto.getTime());
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        appointment.setDateTime(localDateTime);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = null;

        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                email = ((UserDetails) principal).getUsername();
            } else {
                email = principal.toString();
            }
        }

        User user = userRepository.findByEmail(email).orElseThrow(NoSuchElementException::new);
        appointment.setUser(user);

        appointmentRepository.save(appointment);
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
