package com.tallstech.volunteer.repository.impl;

import com.tallstech.volunteer.dto.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CharityAdminRepositoryImplTest {

    @Test
    public void testVolunteerSaveAndGetById() {
        //GIVEN
        // Mockito kullanarak sahte charityAdminRepository oluştur
        CharityAdminRepositoryImpl charityAdminRepositoryMock = Mockito.mock(CharityAdminRepositoryImpl.class);

        UUID id = UUID.randomUUID();
        UUID charityId = UUID.randomUUID();
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        CharityAdminCreateDto testCharityAdminCreate = new CharityAdminCreateDto(charityId, "Ali", "Korkmaz", "84214074525", "259416", "Erkek", 23, "Türk", "0212 754 36 25", "0Rh-", "Bekar", "Yok", "Yok", "Doktor", testLocationVariable);
        CharityAdminDto expected = new CharityAdminDto(id, charityId, "Ali", "Korkmaz", "Erkek", 23, "Türk", "0212 754 36 25", "0Rh-", "Bekar", "Yok", "Yok", "Doktor", testLocationVariable, "ACTIVE");

        //WHEN
        // Mockito kullanarak save metodu çağrıldığında bir UUID döndürmesini sağla
        Mockito.when(charityAdminRepositoryMock.save(Mockito.any())).thenReturn(id);
        UUID savedCharityAdminId = charityAdminRepositoryMock.save(testCharityAdminCreate);

        Mockito.when(charityAdminRepositoryMock.getCharityAdminById(Mockito.any())).thenReturn(expected);
        CharityAdminDto getCharityAdmin = charityAdminRepositoryMock.getCharityAdminById(savedCharityAdminId);

        //THEN
        assertNotNull(getCharityAdmin);
        assertEquals(id, savedCharityAdminId);
        assertEquals(charityId, getCharityAdmin.charityId());
        assertEquals(testCharityAdminCreate.firstName(), getCharityAdmin.firstName());
        assertEquals(testCharityAdminCreate.lastName(), getCharityAdmin.lastName());
        assertEquals(testCharityAdminCreate.gender(), getCharityAdmin.gender());
        assertEquals(testCharityAdminCreate.age(), getCharityAdmin.age());
        assertEquals(testCharityAdminCreate.nationality(), getCharityAdmin.nationality());
        assertEquals(testCharityAdminCreate.phoneNumber(), getCharityAdmin.phoneNumber());
        assertEquals(testCharityAdminCreate.bloodGroup(), getCharityAdmin.bloodGroup());
        assertEquals(testCharityAdminCreate.maritalStatus(), getCharityAdmin.maritalStatus());
        assertEquals(testCharityAdminCreate.healthProblem(), getCharityAdmin.healthProblem());
        assertEquals(testCharityAdminCreate.criminalRecord(), getCharityAdmin.criminalRecord());
        assertEquals(testCharityAdminCreate.biography(), getCharityAdmin.biography());
        assertEquals(testCharityAdminCreate.location().country(), getCharityAdmin.location().country());
        assertEquals(testCharityAdminCreate.location().city(), getCharityAdmin.location().city());
        assertEquals(testCharityAdminCreate.location().district(), getCharityAdmin.location().district());
        assertEquals(testCharityAdminCreate.location().address(), getCharityAdmin.location().address());
    }

    @Test
    public void testGetApplication() {
        //GIVEN
        CharityAdminRepositoryImpl charityAdminRepositoryMock = Mockito.mock(CharityAdminRepositoryImpl.class);

        UUID id = UUID.randomUUID();
        UUID charityId = UUID.randomUUID();
        UUID volunteerId = UUID.randomUUID();
        UUID eventId = UUID.randomUUID();
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        List<ApplicationDto> expected = Collections.singletonList(new ApplicationDto(id, charityId, volunteerId, eventId, "Semih", "Aydın", "Erkek", 32, "Türk", "0539 260 74 89", "ARh-", "Bekar", "Yok", "Yok", "Mühendis", testLocationVariable, "Lisans", "Çalışmıyor", "Yazılım Eğitimi", "Doğudaki Öğrencilere Yazılım Dersi verilecek.", testLocationVariable, "Eğitim", LocalDate.now(), LocalTime.now(), LocalTime.now(), "Yazılım Bilmek", "Yok", 2, LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), "WAITING", "ACTIVE"));
        UUID charityAdminId = UUID.randomUUID();

        //WHEN
        Mockito.when(charityAdminRepositoryMock.getApplication(Mockito.any())).thenReturn(expected);
        List<ApplicationDto> getApplication = charityAdminRepositoryMock.getApplication(charityAdminId);

        //THEN
        assertNotNull(getApplication);
        assertEquals(expected, getApplication);

    }

}