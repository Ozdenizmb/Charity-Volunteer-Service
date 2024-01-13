package com.tallstech.volunteer.controller;

import com.tallstech.volunteer.dto.EventCreateDto;
import com.tallstech.volunteer.dto.EventDto;
import com.tallstech.volunteer.dto.EventUpdateDto;
import com.tallstech.volunteer.dto.Location;
import com.tallstech.volunteer.service.EventService;
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
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventControllerTest {

    @Mock
    EventService mockEventService;

    @InjectMocks
    EventController underTest;

    @Test
    void createEvent_shouldCreateSuccessfully() {
        //GIVEN
        UUID charityAdminId = UUID.randomUUID();
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        EventCreateDto testEventCreate = new EventCreateDto(charityAdminId, "Yazılım Eğitimi", "Doğudaki Öğrencilere Yazılım Dersi verilecek.", testLocationVariable, "Eğitim", LocalDate.now(), LocalTime.now(), LocalTime.now(), "Yazılım Bilmek", "Yok", 2);
        UUID expectedUUID = UUID.randomUUID();

        when(mockEventService.createEvent(testEventCreate)).thenReturn(expectedUUID);

        //WHEN
        ResponseEntity<UUID> response = underTest.createEvent(testEventCreate);
        UUID actual = response.getBody();

        //System.out.println(expectedUUID);
        //System.out.println(actual);

        //THEN
        assertEquals(expectedUUID, actual);
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    void getEventById_shouldSuccessfully() {
        //GIVEN
        UUID id = UUID.randomUUID();
        UUID charityId = UUID.randomUUID();
        UUID charityAdminId = UUID.randomUUID();
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        EventDto expected = new EventDto(id, charityId, charityAdminId, "Yazılım Eğitimi", "Doğudaki Öğrencilere Yazılım Dersi verilecek.", testLocationVariable, "Eğitim", LocalDate.now(), LocalTime.now(), LocalTime.now(),"Yazılım Bilmek", "Yok", 2, LocalDateTime.now(), LocalDateTime.now(), "ACTIVE");

        when(mockEventService.getEventById(id)).thenReturn(expected);

        //WHEN
        ResponseEntity<EventDto> response = underTest.getEventById(id);
        EventDto actual = response.getBody();

        //System.out.println(expected);
        //System.out.println(actual);

        //THEN
        assertEquals(expected, actual);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void updateEventById_shouldSuccessfully() {
        //GIVEN
        UUID id = UUID.randomUUID();
        UUID charityId = UUID.randomUUID();
        UUID charityAdminId = UUID.randomUUID();
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        EventUpdateDto testEventUpdateDto = new EventUpdateDto("Yazılım Eğitimi", "Doğudaki Öğrencilere Yazılım Dersi verilecek.", testLocationVariable, "Eğitim", LocalDate.now(), LocalTime.now(), LocalTime.now(), "Yazılım Bilmek", "Yok", 2);
        EventDto expected = new EventDto(id, charityId, charityAdminId, "Yazılım Dersi", "Değişti.", testLocationVariable, "Eğitim", LocalDate.now(), LocalTime.now(), LocalTime.now(),"Yazılım Bilmek", "Yok", 2, LocalDateTime.now(), LocalDateTime.now(), "ACTIVE");

        when(mockEventService.updateEventById(id, testEventUpdateDto)).thenReturn(expected);

        //WHEN
        ResponseEntity<EventDto> response = underTest.updateEventById(id, testEventUpdateDto);
        EventDto actual = response.getBody();

        //System.out.println(expected);
        //System.out.println(actual);

        //THEN
        assertEquals(expected, actual);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    
    @Test
    void deleteEventById_shouldSuccessfully() {
        //GIVEN
        UUID charityAdminId = UUID.randomUUID();
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        EventCreateDto testEventCreate = new EventCreateDto(charityAdminId, "Yazılım Eğitimi", "Doğudaki Öğrencilere Yazılım Dersi verilecek.", testLocationVariable, "Eğitim", LocalDate.now(), LocalTime.now(), LocalTime.now(), "Yazılım Bilmek", "Yok", 2);
        UUID expectedUUID = UUID.randomUUID();

        when(mockEventService.createEvent(testEventCreate)).thenReturn(expectedUUID);

        //WHEN
        ResponseEntity<UUID> response = underTest.createEvent(testEventCreate);
        UUID actualUUID = response.getBody();

        //THEN
        assertEquals(expectedUUID, actualUUID);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        ResponseEntity<Void> actual = underTest.deleteEventById(actualUUID);

        assertNull(actual);
    }

}