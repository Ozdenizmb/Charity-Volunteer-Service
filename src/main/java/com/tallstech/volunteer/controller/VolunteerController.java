package com.tallstech.volunteer.controller;

import java.util.UUID;

import com.tallstech.volunteer.api.VolunteerApi;
import com.tallstech.volunteer.dto.VolunteerCreateDto;
import com.tallstech.volunteer.dto.VolunteerDto;
import com.tallstech.volunteer.service.VolunteerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class VolunteerController implements VolunteerApi {

    private VolunteerService volunteerService;

    public VolunteerController(VolunteerService volunteerService){
        this.volunteerService = volunteerService;
    }

    @Override
    public ResponseEntity<UUID> createVolunteer(VolunteerCreateDto volunteerCreateDto) {
        return ResponseEntity.ok(volunteerService.createVolunteer(volunteerCreateDto));
    }

    @Override
    public ResponseEntity<VolunteerDto> getVolunteerById(UUID id) {
        return ResponseEntity.ok(volunteerService.getVolunteerById(id));
    }
}
