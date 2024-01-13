package com.tallstech.volunteer.model;

import com.tallstech.volunteer.dto.Location;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class Charity {
    private UUID id;
    private String name;
    private String goal;
    private Location location;
    private String phoneNumber;
    private String slogan;
    private LocalDate yearOfFoundation;
    private String founder;
    private int numberOfActiveVolunteers;
    private String officialSite;
    private String awards;
}
