package com.tallstech.volunteer.controller;

import com.tallstech.volunteer.dto.ApplicationCreateDto;
import com.tallstech.volunteer.service.ApplicationService;
import com.tallstech.volunteer.service.EventService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApplicationControllerTest {

    @Mock
    ApplicationService mockApplicationService;

    @InjectMocks
    ApplicationController underTest;

    @Test
    void createApplication_shouldCreateSuccessfully() {
        //GIVEN
        UUID volunteerId = UUID.randomUUID();
        UUID eventId = UUID.randomUUID();
        ApplicationCreateDto testApplicationCreate = new ApplicationCreateDto(volunteerId, eventId);
        UUID expectedUUID = UUID.randomUUID();

        when(mockApplicationService.createApplication(testApplicationCreate)).thenReturn(expectedUUID);

        //WHEN
        ResponseEntity<UUID> response = underTest.createApplication(testApplicationCreate);
        UUID actual = response.getBody();

        //System.out.println(expectedUUID);
        //System.out.println(actual);

        //THEN
        assertEquals(expectedUUID, actual);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}