package com.tallstech.volunteer.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CharityCreateDto(
        @NotNull
        String name,
        @NotNull
        String goal,
        @NotNull
        Location location,
        @NotNull
        String phoneNumber,
        @NotNull
        String slogan,
        @NotNull
        String yearOfFoundation,
        @NotNull
        String founder,
        @NotNull
        int numberOfActiveVolunteers,
        @NotNull
        String officialSite,
        @NotNull
        String awards
) {
}
