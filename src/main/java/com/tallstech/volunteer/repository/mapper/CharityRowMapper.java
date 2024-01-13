package com.tallstech.volunteer.repository.mapper;

import com.tallstech.volunteer.dto.CharityDto;
import com.tallstech.volunteer.dto.Location;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.UUID;


public class CharityRowMapper implements RowMapper<CharityDto> {
    @Override
    public CharityDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        Location location = new Location(
                rs.getString("country"),
                rs.getString("city"),
                rs.getString("district"),
                rs.getString("address")
        );

        return new CharityDto(
                UUID.fromString(rs.getString("id")),
                rs.getString("name"),
                rs.getString("goal"),
                location,
                rs.getString("phone_number"),
                rs.getString("slogan"),
                rs.getString("year_of_foundation"),
                rs.getString("founder"),
                rs.getInt("number_of_active_volunteers"),
                rs.getString("official_site"),
                rs.getString("awards"),
                rs.getString("status")
        );
    }
}
