package com.tallstech.volunteer.service.impl;

import com.tallstech.volunteer.dto.ApplicationCreateDto;
import com.tallstech.volunteer.repository.ApplicationRepository;
import com.tallstech.volunteer.service.ApplicationService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public UUID createApplication(ApplicationCreateDto applicationCreateDto) {
        return applicationRepository.createApplication(applicationCreateDto);
    }
}
