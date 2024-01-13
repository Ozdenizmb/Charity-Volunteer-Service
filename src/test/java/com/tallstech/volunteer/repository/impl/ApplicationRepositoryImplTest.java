package com.tallstech.volunteer.repository.impl;

import com.tallstech.volunteer.dto.ApplicationCreateDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationRepositoryImplTest {
    @Test
    public void testApplicationSave() {
        //GIVEN
        // Mockito kullanarak sahte applicationRepository oluştur
        ApplicationRepositoryImpl applicationRepositoryMock = Mockito.mock(ApplicationRepositoryImpl.class);

        UUID volunteerId = UUID.randomUUID();
        UUID eventId = UUID.randomUUID();
        ApplicationCreateDto testApplicationCreate = new ApplicationCreateDto(volunteerId, eventId);
        UUID expectedUUID = UUID.randomUUID();

        //WHEN
        // Mockito kullanarak save metodu çağrıldığında bir UUID döndürmesini sağla
        Mockito.when(applicationRepositoryMock.createApplication(Mockito.any())).thenReturn(expectedUUID);

        UUID savedApplicationId = applicationRepositoryMock.createApplication(testApplicationCreate);

        //THEN
        assertNotNull(savedApplicationId);
        assertEquals(expectedUUID, savedApplicationId);
    }

}