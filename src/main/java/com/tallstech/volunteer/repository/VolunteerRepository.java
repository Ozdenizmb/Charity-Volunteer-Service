package com.tallstech.volunteer.repository;

import com.tallstech.volunteer.dto.VolunteerCreateDto;
import com.tallstech.volunteer.dto.VolunteerDto;

import java.util.UUID;

public interface VolunteerRepository{

    UUID save(VolunteerCreateDto volunteerCreateDto);

    VolunteerDto getById(UUID id);

}
