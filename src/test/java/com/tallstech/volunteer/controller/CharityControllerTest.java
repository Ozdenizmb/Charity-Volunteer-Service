package com.tallstech.volunteer.controller;

import com.tallstech.volunteer.dto.CharityCreateDto;
import com.tallstech.volunteer.dto.CharityDto;
import com.tallstech.volunteer.dto.Location;
import com.tallstech.volunteer.service.CharityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CharityControllerTest {

    @Mock
    CharityService mockCharityService;

    @InjectMocks
    CharityController underTest;

    @Test
    void createCharity_shouldCreateSuccessfully() {
        //GIVEN
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        CharityCreateDto testCharityCreateVariable = new CharityCreateDto("Önder","İnsanlara Yardım Etmek", testLocationVariable, "0212 486 25 78", "Birlik için Yarım", "1958", "Mehmet Koç", 1500, "https://onder.com", "2016 Yardım Ödülü");
        UUID expectedUUID = UUID.randomUUID();

        when(mockCharityService.createCharity(testCharityCreateVariable)).thenReturn(expectedUUID);

        //WHEN
        ResponseEntity<UUID> response = underTest.createCharity(testCharityCreateVariable);
        UUID actual = response.getBody();

        //System.out.println(expectedUUID);
        //System.out.println(actual);

        //THEN
        assertEquals(expectedUUID, actual);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getCharityById_shouldSuccessfully() {
        //GIVEN
        UUID id = UUID.randomUUID();
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        CharityDto expected = new CharityDto(id, "Önder","İnsanlara Yardım Etmek", testLocationVariable, "0212 486 25 78", "Birlik için Yarım", "1958", "Mehmet Koç", 1500, "https://onder.com", "2016 Yardım Ödülü", "ACTIVE");

        when(mockCharityService.getCharityById(id)).thenReturn(expected);

        //WHEN
        ResponseEntity<CharityDto> response = underTest.getCharityById(id);
        CharityDto actual = response.getBody();

        //System.out.println(expected);
        //System.out.println(actual);

        //THEN
        assertEquals(expected, actual);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}