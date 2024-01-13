package com.tallstech.volunteer.model;

import java.util.UUID;

import com.tallstech.volunteer.dto.Location;
import lombok.Builder;
import lombok.Data;

/*
* @Data nedir?
* Builder pattern nedir?
* Anotasyon olmadan builder pattern nasıl oluşturulur
* */

@Data
@Builder
public class Volunteer {
    private UUID id;
    private String firstName;
    private String lastName;
    private String identityId;
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
    private String graduationInfo;
    private String work;
}
