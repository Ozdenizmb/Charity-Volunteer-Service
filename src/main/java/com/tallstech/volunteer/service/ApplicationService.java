package com.tallstech.volunteer.service;

import com.tallstech.volunteer.dto.ApplicationCreateDto;

import java.util.UUID;

public interface ApplicationService {

    UUID createApplication(ApplicationCreateDto applicationCreateDto);

}
