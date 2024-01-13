package com.tallstech.volunteer.repository.impl;

import com.tallstech.volunteer.dto.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class EventRepositoryImplTest {
    @Test
    public void testEventSaveAndGetById() {
        //GIVEN
        // Mockito kullanarak sahte EventRepository oluştur
        EventRepositoryImpl eventRepositoryMock = Mockito.mock(EventRepositoryImpl.class);

        UUID id = UUID.randomUUID();
        UUID charityId = UUID.randomUUID();
        UUID charityAdminId = UUID.randomUUID();
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        EventCreateDto testEventCreate = new EventCreateDto(charityAdminId, "Yazılım Eğitimi", "Doğudaki Öğrencilere Yazılım Dersi verilecek.", testLocationVariable, "Eğitim", LocalDate.now(), LocalTime.now(), LocalTime.now(), "Yazılım Bilmek", "Yok", 2);
        EventDto expected = new EventDto(id, charityId, charityAdminId, "Yazılım Eğitimi", "Doğudaki Öğrencilere Yazılım Dersi verilecek.", testLocationVariable, "Eğitim", LocalDate.now(), LocalTime.now(), LocalTime.now(),"Yazılım Bilmek", "Yok", 2, LocalDateTime.now(), LocalDateTime.now(), "ACTIVE");

        //WHEN
        // Mockito kullanarak createEvent metodu çağrıldığında bir UUID döndürmesini sağla
        Mockito.when(eventRepositoryMock.createEvent(Mockito.any())).thenReturn(id);
        UUID savedEventId = eventRepositoryMock.createEvent(testEventCreate);

        Mockito.when(eventRepositoryMock.getEventById(Mockito.any())).thenReturn(expected);
        EventDto getEvent = eventRepositoryMock.getEventById(savedEventId);

        //THEN
        assertNotNull(getEvent);
        assertEquals(id, savedEventId);
        assertEquals(testEventCreate.charityAdminId(), getEvent.charityAdminId());
        assertEquals(testEventCreate.name(), getEvent.name());
        assertEquals(testEventCreate.description(), getEvent.description());
        assertEquals(testEventCreate.location().country(), getEvent.location().country());
        assertEquals(testEventCreate.location().city(), getEvent.location().city());
        assertEquals(testEventCreate.location().district(), getEvent.location().district());
        assertEquals(testEventCreate.location().address(), getEvent.location().address());
        assertEquals(testEventCreate.category(), getEvent.category());
        assertEquals(testEventCreate.startDate(), getEvent.startDate());
        assertEquals(testEventCreate.duration(), getEvent.duration());
        assertEquals(testEventCreate.requirement(), getEvent.requirement());
        assertEquals(testEventCreate.condition(), getEvent.condition());
        assertEquals(testEventCreate.numberOfVolunteers(), getEvent.numberOfVolunteers());
    }

    @Test
    public void testUpdateEventById() {
        //GIVEN
        EventRepositoryImpl eventRepositoryMock = Mockito.mock(EventRepositoryImpl.class);

        UUID id = UUID.randomUUID();
        UUID charityId = UUID.randomUUID();
        UUID charityAdminId = UUID.randomUUID();
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        EventUpdateDto testEventUpdate = new EventUpdateDto("Yazılım Eğitimi", "Doğudaki Öğrencilere Yazılım Dersi verilecek.", testLocationVariable, "Eğitim", LocalDate.now(), LocalTime.now(), LocalTime.now(), "Yazılım Bilmek", "Yok", 2);
        EventDto expected = new EventDto(id, charityId, charityAdminId, "Yazılım Dersi", "Değişti.", testLocationVariable, "Eğitim", LocalDate.now(), LocalTime.now(), LocalTime.now(),"Yazılım Bilmek", "Yok", 2, LocalDateTime.now(), LocalDateTime.now(), "ACTIVE");

        //WHEN
        Mockito.when(eventRepositoryMock.updateEventById(Mockito.any(), Mockito.any())).thenReturn(expected);
        EventDto getUpdatedEvent = eventRepositoryMock.updateEventById(id, testEventUpdate);

        //THEN
        assertNotNull(getUpdatedEvent);
        assertEquals(expected, getUpdatedEvent);

    }

    @Test
    public void testDeleteEventById() {
        //GIVEN
        EventRepositoryImpl eventRepositoryMock = Mockito.mock(EventRepositoryImpl.class);

        UUID charityAdminId = UUID.randomUUID();
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        EventCreateDto testEventCreate = new EventCreateDto(charityAdminId, "Yazılım Eğitimi", "Doğudaki Öğrencilere Yazılım Dersi verilecek.", testLocationVariable, "Eğitim", LocalDate.now(), LocalTime.now(), LocalTime.now(), "Yazılım Bilmek", "Yok", 2);
        UUID expectedUUID = UUID.randomUUID();

        //WHEN
        Mockito.when(eventRepositoryMock.createEvent(Mockito.any())).thenReturn(expectedUUID);
        UUID getEventId = eventRepositoryMock.createEvent(testEventCreate);

        ResponseEntity<Void> actual = eventRepositoryMock.deleteEventById(getEventId);

        //THEN
        assertNull(actual);
    }

}