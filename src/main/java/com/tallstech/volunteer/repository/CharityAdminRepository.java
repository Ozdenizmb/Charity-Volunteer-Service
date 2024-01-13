package com.tallstech.volunteer.repository;

import com.tallstech.volunteer.dto.ApplicationDto;
import com.tallstech.volunteer.dto.CharityAdminCreateDto;
import com.tallstech.volunteer.dto.CharityAdminDto;

import java.util.List;
import java.util.UUID;

public interface CharityAdminRepository {

    UUID save(CharityAdminCreateDto charityAdminCreateDto);

    CharityAdminDto getCharityAdminById(UUID id);

    List<ApplicationDto> getApplication(UUID charityAdminId);

}
