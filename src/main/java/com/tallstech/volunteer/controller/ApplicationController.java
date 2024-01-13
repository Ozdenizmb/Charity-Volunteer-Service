package com.tallstech.volunteer.controller;

import com.tallstech.volunteer.api.ApplicationApi;
import com.tallstech.volunteer.dto.ApplicationCreateDto;
import com.tallstech.volunteer.service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ApplicationController implements ApplicationApi {

    private ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @Override
    public ResponseEntity<UUID> createApplication(ApplicationCreateDto applicationCreateDto) {
        return ResponseEntity.ok(applicationService.createApplication(applicationCreateDto));
    }
}
