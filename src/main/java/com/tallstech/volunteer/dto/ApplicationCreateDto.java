package com.tallstech.volunteer.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ApplicationCreateDto(
        @NotNull
        UUID volunteerId,
        @NotNull
        UUID eventId
) {
}
