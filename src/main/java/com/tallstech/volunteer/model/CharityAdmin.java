package com.tallstech.volunteer.model;

import com.tallstech.volunteer.dto.Location;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CharityAdmin {
    private UUID id;
    private UUID charityId;
    private String firstName;
    private String lastName;
    private String identityId;
    private String password;
    private String gender;
    private int age;
    private String nationality;
    private String phoneNumber;
    private String bloodGroup;
    private String maritalStatus;
    private String healthProblem;
    private String criminalRecord;
    private String biography;
    private Location location;
}
