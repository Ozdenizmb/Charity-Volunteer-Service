package com.tallstech.volunteer.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class Application {
    UUID id;
    UUID volunteerId;
    UUID charityId;
    UUID eventId;
    LocalDateTime applicataionCreateDate;
    String result;
}
