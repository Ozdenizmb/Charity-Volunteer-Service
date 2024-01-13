package com.tallstech.volunteer.repository.impl;

import com.tallstech.volunteer.constant.UserStatuses;
import com.tallstech.volunteer.dto.ApplicationDto;
import com.tallstech.volunteer.dto.CharityAdminCreateDto;
import com.tallstech.volunteer.dto.CharityAdminDto;
import com.tallstech.volunteer.repository.CharityAdminRepository;
import com.tallstech.volunteer.repository.mapper.ApplyRowMapper;
import com.tallstech.volunteer.repository.mapper.CharityAdminRowMapper;
import com.tallstech.volunteer.repository.mapper.GetCharityIdMapper;
import com.tallstech.volunteer.repository.query.CharityAdminSqlQueries;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.UUID;

import static com.tallstech.volunteer.constant.JdbcConstants.JDBC_TEMPLATE;

@Repository
public class CharityAdminRepositoryImpl implements CharityAdminRepository {

    private final JdbcTemplate charityAdminJdbcTemplate;

    public CharityAdminRepositoryImpl(@Qualifier(JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.charityAdminJdbcTemplate = jdbcTemplate;
    }

    @Override
    public UUID save(CharityAdminCreateDto charityAdminCreateDto) {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            charityAdminJdbcTemplate.update(connection -> {
                        PreparedStatement ps = connection.prepareStatement(CharityAdminSqlQueries.INSERT_QUERY, new String[] {"id"});
                        ps.setObject(1, charityAdminCreateDto.charityId());
                        ps.setString(2, charityAdminCreateDto.firstName());
                        ps.setString(3, charityAdminCreateDto.lastName());
                        ps.setString(4, charityAdminCreateDto.identityId());
                        ps.setString(5, charityAdminCreateDto.password());
                        ps.setString(6, charityAdminCreateDto.gender());
                        ps.setInt(7, charityAdminCreateDto.age());
                        ps.setString(8, charityAdminCreateDto.nationality());
                        ps.setString(9, charityAdminCreateDto.phoneNumber());
                        ps.setString(10, charityAdminCreateDto.bloodGroup());
                        ps.setString(11, charityAdminCreateDto.maritalStatus());
                        ps.setString(12, charityAdminCreateDto.healthProblem());
                        ps.setString(13, charityAdminCreateDto.criminalRecord());
                        ps.setString(14, charityAdminCreateDto.biography());
                        ps.setString(15, charityAdminCreateDto.location().country());
                        ps.setString(16, charityAdminCreateDto.location().city());
                        ps.setString(17, charityAdminCreateDto.location().district());
                        ps.setString(18, charityAdminCreateDto.location().address());
                        ps.setString(19, UserStatuses.ACTIVE.name());
                        return ps;
                    }, keyHolder
            );
            return (UUID) keyHolder.getKeys().get("id");
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public CharityAdminDto getCharityAdminById(UUID id) {
        try {
            return charityAdminJdbcTemplate.queryForObject(
                    CharityAdminSqlQueries.SELECT_QUERY, new CharityAdminRowMapper(), id);
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    private UUID getCharityId(UUID charityAdminId){
        try {
            return charityAdminJdbcTemplate.queryForObject(
                    CharityAdminSqlQueries.SELECT_CHARITY_ID, new GetCharityIdMapper(), charityAdminId);
        } catch (Exception exception) {
            throw new RuntimeException("Yanlis Charity Admin Id'si Girildi.");
        }
    }

    @Override
    public List<ApplicationDto> getApplication(UUID charityAdminId) {
        UUID charityId = getCharityId(charityAdminId);

        try {
            //Liste turunde bir çiktiya ihtiyacimiz oldugu icin query kullandik
            return charityAdminJdbcTemplate.query(
                    CharityAdminSqlQueries.SELECT_APPLICATION, new ApplyRowMapper(), charityId);
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

}
