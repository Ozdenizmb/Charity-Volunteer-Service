package com.tallstech.volunteer.repository.mapper;

import com.tallstech.volunteer.dto.Location;
import com.tallstech.volunteer.dto.VolunteerDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class VolunteerRowMapper implements RowMapper<VolunteerDto> {
    @Override
    public VolunteerDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        Location location = new Location(
                rs.getString("country"),
                rs.getString("city"),
                rs.getString("district"),
                rs.getString("address")
        );

        return new VolunteerDto(
                UUID.fromString(rs.getString("id")),
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
                location,
                rs.getString("graduation_info"),
                rs.getString("work"),
                rs.getString("status")
        );
    }
}
