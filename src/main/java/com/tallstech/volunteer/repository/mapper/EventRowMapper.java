package com.tallstech.volunteer.repository.mapper;

import com.tallstech.volunteer.dto.EventDto;
import com.tallstech.volunteer.dto.Location;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public class EventRowMapper implements RowMapper<EventDto> {
    @Override
    public EventDto mapRow(ResultSet rs, int rowNum) throws SQLException {

        Location location = new Location(
                rs.getString("country"),
                rs.getString("city"),
                rs.getString("district"),
                rs.getString("address")
        );

        LocalDate date = rs.getObject("start_date", LocalDate.class);
        LocalTime time = LocalTime.parse(rs.getString("start_time"));
        LocalTime duration = LocalTime.parse(rs.getString("duration"));
        LocalDateTime eventCreateTime = rs.getTimestamp("event_create_time").toLocalDateTime();
        LocalDateTime eventUpdateTime = rs.getTimestamp("event_update_time").toLocalDateTime();

        return new EventDto(
                UUID.fromString(rs.getString("id")),
                UUID.fromString(rs.getString("charity_id")),
                UUID.fromString(rs.getString("charity_admin_id")),
                rs.getString("name"),
                rs.getString("description"),
                location,
                rs.getString("category"),
                date,
                time,
                duration,
                rs.getString("requirement"),
                rs.getString("condition"),
                rs.getInt("number_of_volunteers"),
                eventCreateTime,
                eventUpdateTime,
                rs.getString("status")
        );
    }
}
