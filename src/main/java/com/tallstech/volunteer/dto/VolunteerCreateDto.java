package com.tallstech.volunteer.dto;

import jakarta.validation.constraints.NotNull;


public record VolunteerCreateDto(
        @NotNull
        String firstName,
        @NotNull
        String lastName,
        @NotNull
        String identityId,
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
        Location location,
        @NotNull
        String graduationInfo,
        @NotNull
        String work
) {
}
