package com.example.astrologyapp.repository;

import com.example.astrologyapp.model.Appointment;
import com.example.astrologyapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Appointment> findAllByUser(User user);

}
