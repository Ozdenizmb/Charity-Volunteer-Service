package com.tallstech.volunteer.repository.impl;

import static com.tallstech.volunteer.constant.JdbcConstants.JDBC_TEMPLATE;

import java.sql.PreparedStatement;
import java.util.UUID;

import com.tallstech.volunteer.constant.UserStatuses;
import com.tallstech.volunteer.dto.VolunteerCreateDto;
import com.tallstech.volunteer.dto.VolunteerDto;
import com.tallstech.volunteer.repository.VolunteerRepository;
import com.tallstech.volunteer.repository.mapper.VolunteerRowMapper;
import com.tallstech.volunteer.repository.query.VolunteerSqlQueries;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


@Repository
public class VolunteerRepositoryImpl implements VolunteerRepository {

    private final JdbcTemplate volunteerJdbcTemplate;

    /* @Qualifier nedir? */
    public VolunteerRepositoryImpl(@Qualifier(JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.volunteerJdbcTemplate = jdbcTemplate;
    }

    @Override
    public UUID save(VolunteerCreateDto volunteerCreateDto) {


        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            volunteerJdbcTemplate.update(connection -> {
                        PreparedStatement ps = connection.prepareStatement(VolunteerSqlQueries.INSERT_QUERY, new String[] {"id"});
                        ps.setString(1, volunteerCreateDto.firstName());
                        ps.setString(2, volunteerCreateDto.lastName());
                        ps.setString(3, volunteerCreateDto.identityId());
                        ps.setString(4, volunteerCreateDto.gender());
                        ps.setInt(5, volunteerCreateDto.age());
                        ps.setString(6, volunteerCreateDto.nationality());
                        ps.setString(7, volunteerCreateDto.phoneNumber());
                        ps.setString(8, volunteerCreateDto.bloodGroup());
                        ps.setString(9, volunteerCreateDto.maritalStatus());
                        ps.setString(10, volunteerCreateDto.healthProblem());
                        ps.setString(11, volunteerCreateDto.criminalRecord());
                        ps.setString(12, volunteerCreateDto.biography());
                        ps.setString(13, volunteerCreateDto.location().country());
                        ps.setString(14, volunteerCreateDto.location().city());
                        ps.setString(15, volunteerCreateDto.location().district());
                        ps.setString(16, volunteerCreateDto.location().address());
                        ps.setString(17, volunteerCreateDto.graduationInfo());
                        ps.setString(18, volunteerCreateDto.work());
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
    public VolunteerDto getById(UUID id) {
        try{
           return  volunteerJdbcTemplate.queryForObject(
                   VolunteerSqlQueries.SELECT_QUERY, new VolunteerRowMapper(), id);
        }catch (Exception exception){
            throw new RuntimeException(exception.getMessage());
        }
    }
}
