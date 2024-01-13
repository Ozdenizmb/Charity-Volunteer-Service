package com.tallstech.volunteer.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.tallstech.volunteer.shared.CustomLocalTimeDeserializer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public record EventDto(
        UUID id,
        UUID charityId,
        UUID charityAdminId,
        String name,
        String description,
        Location location,
        String category,
        LocalDate startDate,
        @JsonDeserialize(using = CustomLocalTimeDeserializer.class)
        LocalTime startTime,
        @JsonDeserialize(using = CustomLocalTimeDeserializer.class)
        LocalTime duration,
        String requirement,
        String condition,
        int numberOfVolunteers,
        LocalDateTime eventCreateTime,
        LocalDateTime eventUpdateTime,
        String status
) {
}
