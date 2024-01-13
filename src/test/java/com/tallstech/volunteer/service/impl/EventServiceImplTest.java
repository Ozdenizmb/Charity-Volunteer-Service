package com.tallstech.volunteer.service.impl;

import com.tallstech.volunteer.dto.EventCreateDto;
import com.tallstech.volunteer.dto.EventDto;
import com.tallstech.volunteer.dto.EventUpdateDto;
import com.tallstech.volunteer.dto.Location;
import com.tallstech.volunteer.repository.EventRepository;
import com.tallstech.volunteer.repository.VolunteerRepository;
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
class EventServiceImplTest {

    @Mock
    EventRepository mockEventRepository;

    @InjectMocks
    EventServiceImpl underTest;

    @Test
    void createEvent() {
        //GIVEN
        UUID charityAdminId = UUID.randomUUID();
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        EventCreateDto testEventCreate = new EventCreateDto(charityAdminId, "Yazılım Eğitimi", "Doğudaki Öğrencilere Yazılım Dersi verilecek.", testLocationVariable, "Eğitim", LocalDate.now(), LocalTime.now(), LocalTime.now(), "Yazılım Bilmek", "Yok", 2);
        UUID expectedUUID = UUID.randomUUID();

        when(mockEventRepository.createEvent(testEventCreate)).thenReturn(expectedUUID);

        //WHEN
        UUID actual = underTest.createEvent(testEventCreate);

        //System.out.println(expectedUUID);
        //System.out.println(actual);

        //THEN
        assertNotNull(actual);
        assertEquals(expectedUUID, actual);
    }

    @Test
    void getEventById() {
        //GIVEN
        UUID id = UUID.randomUUID();
        UUID charityId = UUID.randomUUID();
        UUID charityAdminId = UUID.randomUUID();
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        EventDto expected = new EventDto(id, charityId, charityAdminId, "Yazılım Eğitimi", "Doğudaki Öğrencilere Yazılım Dersi verilecek.", testLocationVariable, "Eğitim", LocalDate.now(), LocalTime.now(), LocalTime.now(),"Yazılım Bilmek", "Yok", 2, LocalDateTime.now(), LocalDateTime.now(), "ACTIVE");

        when(mockEventRepository.getEventById(id)).thenReturn(expected);

        //WHEN
        EventDto actual = underTest.getEventById(id);

        //System.out.println(expected);
        //System.out.println(actual);

        //THEN
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void updateEventById() {
        //GIVEN
        UUID id = UUID.randomUUID();
        UUID charityId = UUID.randomUUID();
        UUID charityAdminId = UUID.randomUUID();
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        EventUpdateDto testEventUpdateDto = new EventUpdateDto("Yazılım Eğitimi", "Doğudaki Öğrencilere Yazılım Dersi verilecek.", testLocationVariable, "Eğitim", LocalDate.now(), LocalTime.now(), LocalTime.now(), "Yazılım Bilmek", "Yok", 2);
        EventDto expected = new EventDto(id, charityId, charityAdminId, "Yazılım Dersi", "Değişti.", testLocationVariable, "Eğitim", LocalDate.now(), LocalTime.now(), LocalTime.now(),"Yazılım Bilmek", "Yok", 2, LocalDateTime.now(), LocalDateTime.now(), "ACTIVE");

        when(mockEventRepository.updateEventById(id, testEventUpdateDto)).thenReturn(expected);

        //WHEN
        EventDto actual = underTest.updateEventById(id, testEventUpdateDto);

        //System.out.println(expected);
        //System.out.println(actual);

        //THEN
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void deleteEventById() {
        //GIVEN
        UUID charityAdminId = UUID.randomUUID();
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        EventCreateDto testEventCreate = new EventCreateDto(charityAdminId, "Yazılım Eğitimi", "Doğudaki Öğrencilere Yazılım Dersi verilecek.", testLocationVariable, "Eğitim", LocalDate.now(), LocalTime.now(), LocalTime.now(), "Yazılım Bilmek", "Yok", 2);
        UUID expectedUUID = UUID.randomUUID();

        when(mockEventRepository.createEvent(testEventCreate)).thenReturn(expectedUUID);

        //WHEN
        UUID actualUUID = underTest.createEvent(testEventCreate);

        //THEN
        assertNotNull(actualUUID);
        assertEquals(expectedUUID, actualUUID);

        ResponseEntity<Void> actual = underTest.deleteEventById(actualUUID);

        assertNull(actual);
    }
}