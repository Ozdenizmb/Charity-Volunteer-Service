package com.tallstech.volunteer.controller;

import com.tallstech.volunteer.api.CharityAdminApi;
import com.tallstech.volunteer.dto.ApplicationDto;
import com.tallstech.volunteer.dto.CharityAdminCreateDto;
import com.tallstech.volunteer.dto.CharityAdminDto;
import com.tallstech.volunteer.service.CharityAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
public class CharityAdminController implements CharityAdminApi {

    private CharityAdminService charityAdminService;

    public CharityAdminController(CharityAdminService charityAdminService) {
        this.charityAdminService = charityAdminService;
    }

    @Override
    public ResponseEntity<UUID> createCharityAdmin(CharityAdminCreateDto charityAdminCreateDto) {
        return ResponseEntity.ok(charityAdminService.createCharityAdmin(charityAdminCreateDto));
    }

    @Override
    public ResponseEntity<CharityAdminDto> getCharityAdminById(UUID id) {
        return ResponseEntity.ok(charityAdminService.getCharityAdminById(id));
    }

    @Override
    public ResponseEntity<List<ApplicationDto>> getApplication(UUID applicationAdminId) {
        return ResponseEntity.ok(charityAdminService.getApplication(applicationAdminId));
    }

}
