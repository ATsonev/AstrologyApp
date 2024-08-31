package com.example.astrologyapp.repository;

import com.example.astrologyapp.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Appointment, Long> {
}
