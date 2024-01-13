package com.tallstech.volunteer.service;

import java.util.UUID;

import com.tallstech.volunteer.dto.VolunteerCreateDto;
import com.tallstech.volunteer.dto.VolunteerDto;


public interface VolunteerService {

    UUID createVolunteer(VolunteerCreateDto volunteerCreateDto);

    VolunteerDto getVolunteerById(UUID id);
}
