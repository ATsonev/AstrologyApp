package com.example.astrologyapp.service;

import com.example.astrologyapp.model.Consultation;
import com.example.astrologyapp.model.dto.ConsultationDto;

import java.util.List;

public interface ConsultationService {
    List<ConsultationDto> getAllConsultations();
}
