package com.tallstech.volunteer.repository.impl;

import com.tallstech.volunteer.constant.UserStatuses;
import com.tallstech.volunteer.dto.CharityCreateDto;
import com.tallstech.volunteer.dto.CharityDto;
import com.tallstech.volunteer.repository.CharityRepository;
import com.tallstech.volunteer.repository.mapper.CharityRowMapper;
import com.tallstech.volunteer.repository.query.CharitySqlQueries;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.UUID;

import static com.tallstech.volunteer.constant.JdbcConstants.JDBC_TEMPLATE;


@Repository
public class CharityRepositoryImpl implements CharityRepository {

    private final JdbcTemplate charityJdbcTemplate;

    public CharityRepositoryImpl(@Qualifier(JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.charityJdbcTemplate = jdbcTemplate;
    }

    @Override
    public UUID save(CharityCreateDto charityCreateDto) {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            charityJdbcTemplate.update(connection -> {
                    PreparedStatement ps = connection.prepareStatement(CharitySqlQueries.INSERT_QUERY, new String[] {"id"});
                    ps.setString(1, charityCreateDto.name());
                    ps.setString(2, charityCreateDto.goal());
                    ps.setString(3, charityCreateDto.location().country());
                    ps.setString(4, charityCreateDto.location().city());
                    ps.setString(5, charityCreateDto.location().district());
                    ps.setString(6, charityCreateDto.location().address());
                    ps.setString(7, charityCreateDto.phoneNumber());
                    ps.setString(8, charityCreateDto.slogan());
                    ps.setObject(9, charityCreateDto.yearOfFoundation());
                    ps.setString(10, charityCreateDto.founder());
                    ps.setInt(11, charityCreateDto.numberOfActiveVolunteers());
                    ps.setString(12, charityCreateDto.officialSite());
                    ps.setString(13, charityCreateDto.awards());
                    ps.setString(14, UserStatuses.PASSIVE.name());
                    return ps;
                    }, keyHolder
            );
            return (UUID) keyHolder.getKeys().get("id");
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public CharityDto getCharityById(UUID id) {
        try {
            return charityJdbcTemplate.queryForObject(
                    CharitySqlQueries.SELECT_QUERY, new CharityRowMapper(), id);
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
