package com.tallstech.volunteer.service.impl;

import com.tallstech.volunteer.dto.CharityCreateDto;
import com.tallstech.volunteer.dto.CharityDto;
import com.tallstech.volunteer.repository.CharityRepository;
import com.tallstech.volunteer.service.CharityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CharityServiceImpl implements CharityService {

    private CharityRepository charityRepository;

    public CharityServiceImpl(CharityRepository charityRepository) {
        this.charityRepository = charityRepository;
    }

    @Override
    public UUID createCharity(CharityCreateDto charityCreateDto) {
        return charityRepository.save(charityCreateDto);
    }

    @Override
    public CharityDto getCharityById(UUID id) {
        return charityRepository.getCharityById(id);
    }
}
