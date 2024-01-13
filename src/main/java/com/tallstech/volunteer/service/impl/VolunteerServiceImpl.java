package com.tallstech.volunteer.service.impl;

import java.util.UUID;

import com.tallstech.volunteer.dto.VolunteerCreateDto;
import com.tallstech.volunteer.dto.VolunteerDto;
import com.tallstech.volunteer.repository.VolunteerRepository;
import com.tallstech.volunteer.service.VolunteerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class VolunteerServiceImpl implements VolunteerService {

    private VolunteerRepository volunteerRepository;

    public VolunteerServiceImpl(VolunteerRepository volunteerRepository){
        this.volunteerRepository = volunteerRepository;
    }

    //TODO: Repositorydeki todolar tamamlandıktan sonra, createVolunteer metodun Volunteer dönecek şekilde güncellenecek
    @Override
    public UUID createVolunteer(VolunteerCreateDto volunteerCreateDto) {
        return volunteerRepository.save(volunteerCreateDto);
    }

    @Override
    public VolunteerDto getVolunteerById(UUID id) {
        return volunteerRepository.getById(id);
    }
}
