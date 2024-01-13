package com.tallstech.volunteer.controller;

import com.tallstech.volunteer.dto.Location;
import com.tallstech.volunteer.dto.VolunteerCreateDto;
import com.tallstech.volunteer.dto.VolunteerDto;
import com.tallstech.volunteer.service.VolunteerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VolunteerControllerTest {

    @Mock
    VolunteerService mockVolunteerService;

    @InjectMocks
    VolunteerController underTest;

    @Test
    void createVolunteer_shouldCreateSuccessfully() {
        //GIVEN
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        VolunteerCreateDto testVolunteerCreate = new VolunteerCreateDto("Semih", "Aydın", "75214895125", "Erkek", 32, "Türk", "0539 260 74 89", "ARh-", "Bekar", "Yok", "Yok", "Mühendis", testLocationVariable, "Lisans", "Çalışmıyor");
        UUID expectedUUID = UUID.randomUUID();

        when(mockVolunteerService.createVolunteer(testVolunteerCreate)).thenReturn(expectedUUID);

        //WHEN
        ResponseEntity<UUID> response = underTest.createVolunteer(testVolunteerCreate);
        UUID actual = response.getBody();

        //THEN
        assertEquals(expectedUUID, actual);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getVolunteerById_shouldSuccessfully() {
        //GIVEN
        UUID id = UUID.randomUUID();
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        VolunteerDto expected = new VolunteerDto(id, "Semih", "Aydın", "Erkek", 32, "Türk", "0539 260 74 89", "ARh-", "Bekar", "Yok", "Yok", "Mühendis", testLocationVariable, "Lisans", "Çalışmıyor", "ACTIVE");

        when(mockVolunteerService.getVolunteerById(id)).thenReturn(expected);

        //WHEN
        ResponseEntity<VolunteerDto> response = underTest.getVolunteerById(id);
        VolunteerDto actual = response.getBody();
        //THEN
        assertEquals(expected, actual);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}