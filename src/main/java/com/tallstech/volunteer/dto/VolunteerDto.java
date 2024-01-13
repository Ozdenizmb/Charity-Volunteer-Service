package com.tallstech.volunteer.dto;

import java.util.UUID;


public record VolunteerDto(
        UUID id,
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
        String graduationInfo,
        String work,
        String status
) {
}

