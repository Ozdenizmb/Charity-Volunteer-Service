package com.tallstech.volunteer.service;

import com.tallstech.volunteer.dto.CharityCreateDto;
import com.tallstech.volunteer.dto.CharityDto;

import java.util.UUID;

public interface CharityService {

    UUID createCharity(CharityCreateDto charityCreateDto);

    CharityDto getCharityById(UUID id);

}
