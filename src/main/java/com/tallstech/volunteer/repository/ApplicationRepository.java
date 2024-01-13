package com.tallstech.volunteer.repository;

import com.tallstech.volunteer.dto.ApplicationCreateDto;

import java.util.UUID;

public interface ApplicationRepository {

    UUID createApplication(ApplicationCreateDto applicationCreateDto);

}
