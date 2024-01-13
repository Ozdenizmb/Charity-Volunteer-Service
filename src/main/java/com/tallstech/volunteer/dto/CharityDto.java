package com.tallstech.volunteer.dto;

import java.util.UUID;

public record CharityDto(
        UUID id,
        String name,
        String goal,
        Location location,
        String phoneNumber,
        String slogan,
        String yearOfFoundation,
        String founder,
        int numberOfActiveVolunteers,
        String officialSite,
        String awards,
        String status
) {
}
