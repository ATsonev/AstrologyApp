package com.example.astrologyapp.service.impl;

import com.example.astrologyapp.model.dto.ConsultationDto;
import com.example.astrologyapp.repository.ConsultationRepository;
import com.example.astrologyapp.service.ConsultationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationServiceImpl implements ConsultationService {

    private final ConsultationRepository consultationRepository;
    private final ModelMapper modelMapper;

    public ConsultationServiceImpl(ConsultationRepository consultationRepository, ModelMapper modelMapper) {
        this.consultationRepository = consultationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ConsultationDto> getAllConsultations() {
        return consultationRepository.findAll()
                .stream()
                .map(c -> modelMapper.map(c, ConsultationDto.class))
                .toList();
    }
}
