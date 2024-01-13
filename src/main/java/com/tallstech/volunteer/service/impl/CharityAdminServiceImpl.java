package com.tallstech.volunteer.service.impl;

import com.tallstech.volunteer.dto.ApplicationDto;
import com.tallstech.volunteer.dto.CharityAdminCreateDto;
import com.tallstech.volunteer.dto.CharityAdminDto;
import com.tallstech.volunteer.repository.CharityAdminRepository;
import com.tallstech.volunteer.service.CharityAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class CharityAdminServiceImpl implements CharityAdminService {

    private CharityAdminRepository charityAdminRepository;

    public CharityAdminServiceImpl(CharityAdminRepository charityAdminRepository) {
        this.charityAdminRepository = charityAdminRepository;
    }

    @Override
    public UUID createCharityAdmin(CharityAdminCreateDto charityAdminCreateDto) {
        return charityAdminRepository.save(charityAdminCreateDto);
    }

    @Override
    public CharityAdminDto getCharityAdminById(UUID id) {
        return charityAdminRepository.getCharityAdminById(id);
    }

    @Override
    public List<ApplicationDto> getApplication(UUID charityAdminId) {
        return charityAdminRepository.getApplication(charityAdminId);
    }

}
