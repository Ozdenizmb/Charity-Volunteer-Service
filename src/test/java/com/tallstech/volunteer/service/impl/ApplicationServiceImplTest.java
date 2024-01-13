package com.tallstech.volunteer.service.impl;

import com.tallstech.volunteer.dto.ApplicationCreateDto;
import com.tallstech.volunteer.repository.ApplicationRepository;
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
class ApplicationServiceImplTest {

    @Mock
    ApplicationRepository mockApplicationRepository;

    @InjectMocks
    ApplicationServiceImpl underTest;

    @Test
    void createApplication() {
        //GIVEN
        UUID volunteerId = UUID.randomUUID();
        UUID eventId = UUID.randomUUID();
        ApplicationCreateDto testApplicationCreate = new ApplicationCreateDto(volunteerId, eventId);
        UUID expectedUUID = UUID.randomUUID();

        when(mockApplicationRepository.createApplication(testApplicationCreate)).thenReturn(expectedUUID);

        //WHEN
        UUID actual = underTest.createApplication(testApplicationCreate);

        //System.out.println(expectedUUID);
        //System.out.println(actual);

        //THEN
        assertNotNull(actual);
        assertEquals(expectedUUID, actual);
    }
}