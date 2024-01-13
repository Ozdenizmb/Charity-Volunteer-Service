package com.tallstech.volunteer.service.impl;

import com.tallstech.volunteer.dto.CharityCreateDto;
import com.tallstech.volunteer.dto.CharityDto;
import com.tallstech.volunteer.dto.Location;
import com.tallstech.volunteer.repository.CharityRepository;
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
class CharityServiceImplTest {

    @Mock
    CharityRepository mockCharityRepository;

    @InjectMocks
    CharityServiceImpl underTest;

    @Test
    void createCharity() {
        //GIVEN
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        CharityCreateDto testCharityCreateVariable = new CharityCreateDto("Önder","İnsanlara Yardım Etmek", testLocationVariable, "0212 486 25 78", "Birlik için Yarım", "1958", "Mehmet Koç", 1500, "https://onder.com", "2016 Yardım Ödülü");
        UUID expectedUUID = UUID.randomUUID();

        when(mockCharityRepository.save(testCharityCreateVariable)).thenReturn(expectedUUID);

        //WHEN
        UUID actual = underTest.createCharity(testCharityCreateVariable);

        //System.out.println(expectedUUID);
        //System.out.println(actual);

        //THEN
        assertNotNull(actual);
        assertEquals(expectedUUID, actual);
    }

    @Test
    void getCharityById() {
        //GIVEN
        UUID id = UUID.randomUUID();
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        CharityDto expected = new CharityDto(id, "Önder","İnsanlara Yardım Etmek", testLocationVariable, "0212 486 25 78", "Birlik için Yarım", "1958", "Mehmet Koç", 1500, "https://onder.com", "2016 Yardım Ödülü", "ACTIVE");

        when(mockCharityRepository.getCharityById(id)).thenReturn(expected);

        //WHEN
        CharityDto actual = underTest.getCharityById(id);

        //System.out.println(expected);
        //System.out.println(actual);

        //THEN
        assertNotNull(actual);
        assertEquals(expected, actual);
    }
}