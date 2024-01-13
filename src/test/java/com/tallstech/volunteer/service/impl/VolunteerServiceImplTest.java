package com.tallstech.volunteer.service.impl;

import com.tallstech.volunteer.dto.Location;
import com.tallstech.volunteer.dto.VolunteerCreateDto;
import com.tallstech.volunteer.dto.VolunteerDto;
import com.tallstech.volunteer.repository.VolunteerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VolunteerServiceImplTest {

    @Mock
    VolunteerRepository mockVolunteerRepository;

    @InjectMocks
    VolunteerServiceImpl underTest;

    @Test
    void createVolunteer() {
        //GIVEN
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        VolunteerCreateDto testVolunteerCreate = new VolunteerCreateDto("Semih", "Aydın", "75214895125", "Erkek", 32, "Türk", "0539 260 74 89", "ARh-", "Bekar", "Yok", "Yok", "Mühendis", testLocationVariable, "Lisans", "Çalışmıyor");
        UUID expectedUUID = UUID.randomUUID();

        when(mockVolunteerRepository.save(testVolunteerCreate)).thenReturn(expectedUUID);

        //WHEN
        UUID actual = underTest.createVolunteer(testVolunteerCreate);

        //System.out.println(expectedUUID);
        //System.out.println(actual);

        //THEN
        assertNotNull(actual);
        assertEquals(expectedUUID, actual);
    }

    @Test
    void getVolunteerById() {
        //GIVEN
        UUID id = UUID.randomUUID();
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        VolunteerDto expected = new VolunteerDto(id, "Semih", "Aydın", "Erkek", 32, "Türk", "0539 260 74 89", "ARh-", "Bekar", "Yok", "Yok", "Mühendis", testLocationVariable, "Lisans", "Çalışmıyor", "ACTIVE");

        when(mockVolunteerRepository.getById(id)).thenReturn(expected);

        //WHEN
        VolunteerDto actual = underTest.getVolunteerById(id);

        //System.out.println(expected);
        //System.out.println(actual);

        //THEN
        assertNotNull(actual);
        assertEquals(expected, actual);
    }
}