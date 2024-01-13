package com.tallstech.volunteer.repository.mapper;

import com.tallstech.volunteer.dto.CharityAdminDto;
import com.tallstech.volunteer.dto.Location;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CharityAdminRowMapper implements RowMapper<CharityAdminDto> {
    @Override
    public CharityAdminDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        Location location = new Location(
                rs.getString("country"),
                rs.getString("city"),
                rs.getString("district"),
                rs.getString("address")
        );

        return new CharityAdminDto(
                UUID.fromString(rs.getString("id")),
                UUID.fromString(rs.getString("charity_id")),
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
                rs.getString("status")
        );
    }
}
