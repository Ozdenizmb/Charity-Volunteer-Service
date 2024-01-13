package com.tallstech.volunteer.controller;

import com.tallstech.volunteer.api.CharityApi;
import com.tallstech.volunteer.dto.CharityCreateDto;
import com.tallstech.volunteer.dto.CharityDto;
import com.tallstech.volunteer.service.CharityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
public class CharityController implements CharityApi {

    private CharityService charityService;

    public CharityController(CharityService charityService) {
        this.charityService = charityService;
    }

    @Override
    public ResponseEntity<UUID> createCharity(CharityCreateDto charityCreateDto) {
        return ResponseEntity.ok(charityService.createCharity(charityCreateDto));
    }

    @Override
    public ResponseEntity<CharityDto> getCharityById(UUID id) {
        return ResponseEntity.ok(charityService.getCharityById(id));
    }
}
