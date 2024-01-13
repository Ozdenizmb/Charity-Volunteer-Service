package com.tallstech.volunteer.controller;

import com.tallstech.volunteer.dto.ApplicationDto;
import com.tallstech.volunteer.dto.CharityAdminCreateDto;
import com.tallstech.volunteer.dto.CharityAdminDto;
import com.tallstech.volunteer.dto.Location;
import com.tallstech.volunteer.service.CharityAdminService;
import com.tallstech.volunteer.service.CharityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CharityAdminControllerTest {

    @Mock
    CharityAdminService mockCharityAdminService;

    @InjectMocks
    CharityAdminController underTest;

    @Test
    void createCharityAdmin_shouldCreateSuccessfully() {
        //GIVEN
        UUID charityId = UUID.randomUUID();
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        CharityAdminCreateDto testCharityAdminCreateDto = new CharityAdminCreateDto(charityId, "Ali", "Korkmaz", "84214074525", "259416", "Erkek", 23, "Türk", "0212 754 36 25", "0Rh-", "Bekar", "Yok", "Yok", "Doktor", testLocationVariable);
        UUID expectedUUID = UUID.randomUUID();

        when(mockCharityAdminService.createCharityAdmin(testCharityAdminCreateDto)).thenReturn(expectedUUID);

        //WHEN
        ResponseEntity<UUID> response = underTest.createCharityAdmin(testCharityAdminCreateDto);
        UUID actual = response.getBody();

        //System.out.println(expectedUUID);
        //System.out.println(actual);

        //THEN
        assertEquals(expectedUUID, actual);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getCharityAdminById_shouldSuccessfully() {
        //GIVEN
        UUID id = UUID.randomUUID();
        UUID charityId = UUID.randomUUID();
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        CharityAdminDto expected = new CharityAdminDto(id, charityId, "Ali", "Korkmaz", "Erkek", 23, "Türk", "0212 754 36 25", "0Rh-", "Bekar", "Yok", "Yok", "Doktor", testLocationVariable, "ACTIVE");

        when(mockCharityAdminService.getCharityAdminById(id)).thenReturn(expected);

        //WHEN
        ResponseEntity<CharityAdminDto> response = underTest.getCharityAdminById(id);
        CharityAdminDto actual = response.getBody();

        //System.out.println(expected);
        //System.out.println(actual);

        //THEN
        assertEquals(expected, actual);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getApplicationById_shouldSuccessfully() {
        //GIVEN
        UUID id = UUID.randomUUID();
        UUID charityId = UUID.randomUUID();
        UUID volunteerId = UUID.randomUUID();
        UUID eventId = UUID.randomUUID();
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        List<ApplicationDto> expected = Collections.singletonList(new ApplicationDto(id, charityId, volunteerId, eventId, "Semih", "Aydın", "Erkek", 32, "Türk", "0539 260 74 89", "ARh-", "Bekar", "Yok", "Yok", "Mühendis", testLocationVariable, "Lisans", "Çalışmıyor", "Yazılım Eğitimi", "Doğudaki Öğrencilere Yazılım Dersi verilecek.", testLocationVariable, "Eğitim", LocalDate.now(), LocalTime.now(), LocalTime.now(), "Yazılım Bilmek", "Yok", 2, LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), "WAITING", "ACTIVE"));
        UUID charityAdminId = UUID.randomUUID();

        when(mockCharityAdminService.getApplication(charityAdminId)).thenReturn(expected);

        //WHEN
        ResponseEntity<List<ApplicationDto>> response = underTest.getApplication(charityAdminId);
        List<ApplicationDto> actual = response.getBody();

        //System.out.println(expected);
        //System.out.println(actual);

        //THEN
        assertEquals(expected, actual);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}