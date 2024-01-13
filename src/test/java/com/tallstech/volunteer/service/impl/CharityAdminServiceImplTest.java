package com.tallstech.volunteer.service.impl;

import com.tallstech.volunteer.dto.ApplicationDto;
import com.tallstech.volunteer.dto.CharityAdminCreateDto;
import com.tallstech.volunteer.dto.CharityAdminDto;
import com.tallstech.volunteer.dto.Location;
import com.tallstech.volunteer.repository.CharityAdminRepository;
import com.tallstech.volunteer.repository.VolunteerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CharityAdminServiceImplTest {

    @Mock
    CharityAdminRepository mockCharityAdminRepository;

    @InjectMocks
    CharityAdminServiceImpl underTest;

    @Test
    void createCharityAdmin() {
        //GIVEN
        UUID charityId = UUID.randomUUID();
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        CharityAdminCreateDto testCharityAdminCreateDto = new CharityAdminCreateDto(charityId, "Ali", "Korkmaz", "84214074525", "259416", "Erkek", 23, "Türk", "0212 754 36 25", "0Rh-", "Bekar", "Yok", "Yok", "Doktor", testLocationVariable);
        UUID expectedUUID = UUID.randomUUID();

        when(mockCharityAdminRepository.save(testCharityAdminCreateDto)).thenReturn(expectedUUID);

        //WHEN
        UUID actual = underTest.createCharityAdmin(testCharityAdminCreateDto);

        //System.out.println(expectedUUID);
        //System.out.println(actual);

        //THEN
        assertNotNull(actual);
        assertEquals(expectedUUID, actual);
    }

    @Test
    void getCharityAdminById() {
        //GIVEN
        UUID id = UUID.randomUUID();
        UUID charityId = UUID.randomUUID();
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        CharityAdminDto expected = new CharityAdminDto(id, charityId, "Ali", "Korkmaz", "Erkek", 23, "Türk", "0212 754 36 25", "0Rh-", "Bekar", "Yok", "Yok", "Doktor", testLocationVariable, "ACTIVE");

        when(mockCharityAdminRepository.getCharityAdminById(id)).thenReturn(expected);

        //WHEN
        CharityAdminDto actual = underTest.getCharityAdminById(id);

        //System.out.println(expected);
        //System.out.println(actual);

        //THEN
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void getApplication() {
        //GIVEN
        UUID id = UUID.randomUUID();
        UUID charityId = UUID.randomUUID();
        UUID volunteerId = UUID.randomUUID();
        UUID eventId = UUID.randomUUID();
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        List<ApplicationDto> expected = Collections.singletonList(new ApplicationDto(id, charityId, volunteerId, eventId, "Semih", "Aydın", "Erkek", 32, "Türk", "0539 260 74 89", "ARh-", "Bekar", "Yok", "Yok", "Mühendis", testLocationVariable, "Lisans", "Çalışmıyor", "Yazılım Eğitimi", "Doğudaki Öğrencilere Yazılım Dersi verilecek.", testLocationVariable, "Eğitim", LocalDate.now(), LocalTime.now(), LocalTime.now(), "Yazılım Bilmek", "Yok", 2, LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), "WAITING", "ACTIVE"));
        UUID charityAdminId = UUID.randomUUID();

        when(mockCharityAdminRepository.getApplication(charityAdminId)).thenReturn(expected);

        //WHEN
        List<ApplicationDto> actual = underTest.getApplication(charityAdminId);

        //System.out.println(expected);
        //System.out.println(actual);

        //THEN
        assertNotNull(actual);
        assertEquals(expected, actual);
    }
}