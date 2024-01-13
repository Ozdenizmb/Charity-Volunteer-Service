package com.tallstech.volunteer.repository.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class GetCharityIdMapper implements RowMapper<UUID> {
    @Override
    public UUID mapRow(ResultSet rs, int rowNum) throws SQLException {
        return UUID.fromString(rs.getString("charity_id"));
    }
}
