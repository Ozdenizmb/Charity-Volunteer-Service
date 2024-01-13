package com.tallstech.volunteer.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.tallstech.volunteer.shared.CustomLocalTimeDeserializer;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record EventCreateDto(
        @NotNull
        UUID charityAdminId,
        @NotNull
        String name,
        @NotNull
        String description,
        @NotNull
        Location location,
        @NotNull
        String category,
        @NotNull
        LocalDate startDate,
        @NotNull
        @JsonDeserialize(using = CustomLocalTimeDeserializer.class)
        LocalTime startTime,
        @NotNull
        @JsonDeserialize(using = CustomLocalTimeDeserializer.class)
        LocalTime duration,
        @NotNull
        String requirement,
        @NotNull
        String condition,
        @NotNull
        int numberOfVolunteers
) {
}
