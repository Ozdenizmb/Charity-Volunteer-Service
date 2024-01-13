package com.tallstech.volunteer.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.tallstech.volunteer.shared.CustomLocalTimeDeserializer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public record ApplicationDto(
        UUID id,
        UUID charityId,
        UUID volunteerId,
        UUID eventId,

        // Volunteer'a ait özellikler
        String firstName,
        String lastName,
        String gander,
        int age,
        String nationality,
        String phone_number,
        String blood_group,
        String marital_status,
        String health_problem,
        String criminal_record,
        String biography,
        Location volunteerLocation,
        String graduation_info,
        String work,

        //Event'e ait özellikler
        String name,
        String description,
        Location eventLocation,
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


        LocalDateTime applicationCreateDate,
        String applicationResult,
        String status
) {
}
