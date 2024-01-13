package com.tallstech.volunteer.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CharityAdminCreateDto(
        @NotNull
        UUID charityId,
        @NotNull
        String firstName,
        @NotNull
        String lastName,
        @NotNull
        String identityId,
        @NotNull
        String password,
        @NotNull
        String gender,
        @NotNull
        int age,
        @NotNull
        String nationality,
        @NotNull
        String phoneNumber,
        @NotNull
        String bloodGroup,
        @NotNull
        String maritalStatus,
        @NotNull
        String healthProblem,
        @NotNull
        String criminalRecord,
        @NotNull
        String biography,
        @NotNull
        Location location
) {
}
