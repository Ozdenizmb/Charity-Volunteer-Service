package com.tallstech.volunteer.repository.impl;

import com.tallstech.volunteer.constant.ApplicationResult;
import com.tallstech.volunteer.constant.UserStatuses;
import com.tallstech.volunteer.dto.ApplicationCreateDto;
import com.tallstech.volunteer.repository.ApplicationRepository;
import com.tallstech.volunteer.repository.mapper.GetCharityIdMapper;
import com.tallstech.volunteer.repository.query.ApplicationsSqlQueries;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.tallstech.volunteer.constant.JdbcConstants.JDBC_TEMPLATE;

@Repository
public class ApplicationRepositoryImpl implements ApplicationRepository {

    private final JdbcTemplate applyJdbcTemplate;

    public ApplicationRepositoryImpl(@Qualifier(JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.applyJdbcTemplate = jdbcTemplate;
    }

    private UUID getCharityId(UUID eventId){
        try {
            return applyJdbcTemplate.queryForObject(
                    ApplicationsSqlQueries.SELECT_CHARITY_ID, new GetCharityIdMapper(), eventId);
        } catch (Exception exception) {
            throw new RuntimeException("Yanlis Event Id'si Girildi.");
        }
    }

    @Override
    public UUID createApplication(ApplicationCreateDto applicationCreateDto) {

        UUID charityId = getCharityId(applicationCreateDto.eventId());

        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            applyJdbcTemplate.update(connection -> {
                        PreparedStatement ps = connection.prepareStatement(ApplicationsSqlQueries.INSERT_QUERY, new String[] {"id"});
                        ps.setObject(1, applicationCreateDto.volunteerId());
                        ps.setObject(2, charityId);
                        ps.setObject(3, applicationCreateDto.eventId());
                        ps.setObject(4, LocalDateTime.now());
                        ps.setString(5, ApplicationResult.WAITING.name());
                        ps.setString(6, UserStatuses.ACTIVE.name());
                        return ps;
                    }, keyHolder
            );
            return (UUID) keyHolder.getKeys().get("id");
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
