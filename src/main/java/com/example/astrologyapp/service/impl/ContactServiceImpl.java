package com.example.astrologyapp.service.impl;

import com.example.astrologyapp.model.Contact;
import com.example.astrologyapp.model.dto.ContactDto;
import com.example.astrologyapp.repository.ContactRepository;
import com.example.astrologyapp.service.ContactService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;

    public ContactServiceImpl(ContactRepository contactRepository, ModelMapper modelMapper) {
        this.contactRepository = contactRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void submitContact(ContactDto contactDto) {
        Contact contact = modelMapper.map(contactDto, Contact.class);
        contact.setDateAndTimeSubmitted(LocalDateTime.now());
        contactRepository.save(contact);
    }
}
