package com.tallstech.volunteer.repository;

import com.tallstech.volunteer.dto.CharityCreateDto;
import com.tallstech.volunteer.dto.CharityDto;

import java.util.UUID;

public interface CharityRepository {

    UUID save(CharityCreateDto charityCreateDto);

    CharityDto getCharityById(UUID id);

}
