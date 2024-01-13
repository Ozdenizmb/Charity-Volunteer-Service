package com.tallstech.volunteer.repository.impl;

import com.tallstech.volunteer.dto.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CharityRepositoryImplTest {
    @Test
    public void testCharitySaveAndGetById() {
        //GIVEN
        // Mockito kullanarak sahte CharityRepository oluştur
        CharityRepositoryImpl charityRepositoryMock = Mockito.mock(CharityRepositoryImpl.class);

        UUID id = UUID.randomUUID();
        Location testLocationVariable = new Location("Türkiye", "İstanbul", "Şişli", "Yeşil Mahallesi, Altın Sokak");
        CharityCreateDto testCharityCreateVariable = new CharityCreateDto("Önder","İnsanlara Yardım Etmek", testLocationVariable, "0212 486 25 78", "Birlik için Yarım", "1958", "Mehmet Koç", 1500, "https://onder.com", "2016 Yardım Ödülü");
        CharityDto expected = new CharityDto(id, "Önder","İnsanlara Yardım Etmek", testLocationVariable, "0212 486 25 78", "Birlik için Yarım", "1958", "Mehmet Koç", 1500, "https://onder.com", "2016 Yardım Ödülü", "ACTIVE");

        //WHEN
        // Mockito kullanarak save metodu çağrıldığında bir UUID döndürmesini sağla
        Mockito.when(charityRepositoryMock.save(Mockito.any())).thenReturn(id);
        UUID savedCharityId = charityRepositoryMock.save(testCharityCreateVariable);

        Mockito.when(charityRepositoryMock.getCharityById(Mockito.any())).thenReturn(expected);
        CharityDto getCharity = charityRepositoryMock.getCharityById(savedCharityId);

        //THEN
        assertNotNull(getCharity);
        assertEquals(id, savedCharityId);
        assertEquals(testCharityCreateVariable.name(), getCharity.name());
        assertEquals(testCharityCreateVariable.goal(), getCharity.goal());
        assertEquals(testCharityCreateVariable.location().country(), getCharity.location().country());
        assertEquals(testCharityCreateVariable.location().city(), getCharity.location().city());
        assertEquals(testCharityCreateVariable.location().district(), getCharity.location().district());
        assertEquals(testCharityCreateVariable.location().address(), getCharity.location().address());
        assertEquals(testCharityCreateVariable.phoneNumber(), getCharity.phoneNumber());
        assertEquals(testCharityCreateVariable.slogan(), getCharity.slogan());
        assertEquals(testCharityCreateVariable.yearOfFoundation(), getCharity.yearOfFoundation());
        assertEquals(testCharityCreateVariable.founder(), getCharity.founder());
        assertEquals(testCharityCreateVariable.numberOfActiveVolunteers(), getCharity.numberOfActiveVolunteers());
        assertEquals(testCharityCreateVariable.officialSite(), getCharity.officialSite());
        assertEquals(testCharityCreateVariable.awards(), getCharity.awards());
    }

}