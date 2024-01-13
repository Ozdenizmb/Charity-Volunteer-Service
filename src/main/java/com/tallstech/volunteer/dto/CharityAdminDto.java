package com.tallstech.volunteer.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CharityAdminDto(
        UUID id,
        UUID charityId,
        String firstName,
        String lastName,
        String gender,
        int age,
        String nationality,
        String phoneNumber,
        String bloodGroup,
        String maritalStatus,
        String healthProblem,
        String criminalRecord,
        String biography,
        Location location,
        String status
) {
}
