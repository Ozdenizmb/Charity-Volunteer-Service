package com.tallstech.volunteer.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.tallstech.volunteer.dto.Location;
import com.tallstech.volunteer.shared.CustomLocalTimeDeserializer;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Data
@Builder
public class Event {
    private UUID id;
    private UUID charityId;
    private UUID charityAdminId;
    private String name;
    private String description;
    private Location location;
    private String category;
    private LocalDate startDate;
    @JsonDeserialize(using = CustomLocalTimeDeserializer.class)
    private LocalTime startTime;
    @JsonDeserialize(using = CustomLocalTimeDeserializer.class)
    private LocalTime duration;
    private String requirement;
    private String condition;
    private int numberOfVolunteers;
    private LocalDateTime eventCreateTime;
    private LocalDateTime eventUpdateTime;
    private String status;
}
