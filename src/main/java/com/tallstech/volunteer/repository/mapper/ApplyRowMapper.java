package com.tallstech.volunteer.repository.mapper;

import com.tallstech.volunteer.dto.ApplicationDto;
import com.tallstech.volunteer.dto.Location;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public class ApplyRowMapper implements RowMapper<ApplicationDto> {
    @Override
    public ApplicationDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        Location volunteerLocation = new Location(
                rs.getString("volunteer_country"),
                rs.getString("volunteer_city"),
                rs.getString("volunteer_district"),
                rs.getString("volunteer_address")
        );

        Location eventLocation = new Location(
                rs.getString("event_country"),
                rs.getString("event_city"),
                rs.getString("event_district"),
                rs.getString("event_address")
        );

        LocalDate date = rs.getObject("start_date", LocalDate.class);
        LocalTime time = LocalTime.parse(rs.getString("start_time"));
        LocalTime duration = LocalTime.parse(rs.getString("duration"));

        LocalDateTime eventCreateTime = rs.getTimestamp("event_create_time").toLocalDateTime();
        LocalDateTime eventUpdateTime = rs.getTimestamp("event_update_time").toLocalDateTime();
        LocalDateTime applicationDate = rs.getTimestamp("application_create_date").toLocalDateTime();

        return new ApplicationDto(
                UUID.fromString(rs.getString("id")),
                UUID.fromString(rs.getString("charity_id")),
                UUID.fromString(rs.getString("volunteer_id")),
                UUID.fromString(rs.getString("event_id")),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("gender"),
                rs.getInt("age"),
                rs.getString("nationality"),
                rs.getString("phone_number"),
                rs.getString("blood_group"),
                rs.getString("marital_status"),
                rs.getString("health_problem"),
                rs.getString("criminal_record"),
                rs.getString("biography"),
                volunteerLocation,
                rs.getString("graduation_info"),
                rs.getString("work"),
                rs.getString("name"),
                rs.getString("description"),
                eventLocation,
                rs.getString("category"),
                date,
                time,
                duration,
                rs.getString("requirement"),
                rs.getString("condition"),
                rs.getInt("number_of_volunteers"),
                eventCreateTime,
                eventUpdateTime,
                applicationDate,
                rs.getString("application_result"),
                rs.getString("status")
        );
    }
}
