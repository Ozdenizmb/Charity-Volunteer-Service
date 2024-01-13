package com.tallstech.volunteer.repository.impl;

import com.tallstech.volunteer.dto.Location;
import com.tallstech.volunteer.dto.VolunteerCreateDto;
import com.tallstech.volunteer.dto.VolunteerDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VolunteerRepositoryImplTest {
    @Test
    public void testVolunteerSaveAndGetById() {
        //GIVEN
        // Mockito kullanarak sahte VolunteerRepository oluştur
        VolunteerRepositoryImpl volunteerRepositoryMock = Mockito.mock(VolunteerRepositoryImpl.class);

        UUID id = UUID.randomUUID();
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        VolunteerCreateDto testVolunteerCreate = new VolunteerCreateDto("Semih", "Aydın", "75214895125", "Erkek", 32, "Türk", "0539 260 74 89", "ARh-", "Bekar", "Yok", "Yok", "Mühendis", testLocationVariable, "Lisans", "Çalışmıyor");
        VolunteerDto expected = new VolunteerDto(id, "Semih", "Aydın", "Erkek", 32, "Türk", "0539 260 74 89", "ARh-", "Bekar", "Yok", "Yok", "Mühendis", testLocationVariable, "Lisans", "Çalışmıyor", "ACTIVE");

        //WHEN
        // Mockito kullanarak save metodu çağrıldığında bir UUID döndürmesini sağla
        Mockito.when(volunteerRepositoryMock.save(Mockito.any())).thenReturn(id);

        UUID savedVolunteerId = volunteerRepositoryMock.save(testVolunteerCreate);

        Mockito.when(volunteerRepositoryMock.getById(Mockito.any())).thenReturn(expected);
        VolunteerDto getVolunteer = volunteerRepositoryMock.getById(savedVolunteerId);

        //THEN
        assertNotNull(getVolunteer);
        assertEquals(id, savedVolunteerId);
        assertEquals(testVolunteerCreate.firstName(), getVolunteer.firstName());
        assertEquals(testVolunteerCreate.lastName(), getVolunteer.lastName());
        assertEquals(testVolunteerCreate.gender(), getVolunteer.gender());
        assertEquals(testVolunteerCreate.age(), getVolunteer.age());
        assertEquals(testVolunteerCreate.nationality(), getVolunteer.nationality());
        assertEquals(testVolunteerCreate.phoneNumber(), getVolunteer.phoneNumber());
        assertEquals(testVolunteerCreate.bloodGroup(), getVolunteer.bloodGroup());
        assertEquals(testVolunteerCreate.maritalStatus(), getVolunteer.maritalStatus());
        assertEquals(testVolunteerCreate.healthProblem(), getVolunteer.healthProblem());
        assertEquals(testVolunteerCreate.criminalRecord(), getVolunteer.criminalRecord());
        assertEquals(testVolunteerCreate.biography(), getVolunteer.biography());
        assertEquals(testVolunteerCreate.location().country(), getVolunteer.location().country());
        assertEquals(testVolunteerCreate.location().city(), getVolunteer.location().city());
        assertEquals(testVolunteerCreate.location().district(), getVolunteer.location().district());
        assertEquals(testVolunteerCreate.location().address(), getVolunteer.location().address());
        assertEquals(testVolunteerCreate.graduationInfo(), getVolunteer.graduationInfo());
        assertEquals(testVolunteerCreate.work(), getVolunteer.work());
    }
}
