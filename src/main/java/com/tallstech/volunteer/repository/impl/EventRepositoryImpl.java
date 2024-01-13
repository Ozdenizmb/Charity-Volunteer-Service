package com.tallstech.volunteer.repository.impl;

import com.tallstech.volunteer.constant.UserStatuses;
import com.tallstech.volunteer.dto.EventCreateDto;
import com.tallstech.volunteer.dto.EventDto;
import com.tallstech.volunteer.dto.EventUpdateDto;
import com.tallstech.volunteer.repository.EventRepository;
import com.tallstech.volunteer.repository.mapper.EventRowMapper;
import com.tallstech.volunteer.repository.mapper.GetCharityIdMapper;
import com.tallstech.volunteer.repository.query.EventSqlQueries;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.tallstech.volunteer.constant.JdbcConstants.JDBC_TEMPLATE;

@Repository
public class EventRepositoryImpl implements EventRepository {

    private final JdbcTemplate eventJdbcTemplate;

    public EventRepositoryImpl(@Qualifier(JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.eventJdbcTemplate = jdbcTemplate;
    }

    private UUID getCharityId(UUID charityAdminId){
        /*
            Bu kod blogu ile event'i baslatan adminin, charity_id bilgisi otomatik bir
            sekilde cekilecek ve event'teki charity_id icin kullanilmasi saglanacaktir.
        */
        try {
            return eventJdbcTemplate.queryForObject(
                    EventSqlQueries.SELECT_CHARITY_ID, new GetCharityIdMapper(), charityAdminId);
        } catch (Exception exception) {
            throw new RuntimeException("Yanlıs Charity Admin Id'si Girildi.");
        }
    }

    @Override
    public UUID createEvent(EventCreateDto eventCreateDto) {

        UUID charityId = getCharityId(eventCreateDto.charityAdminId());

        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            eventJdbcTemplate.update(connection -> {
                    PreparedStatement ps = connection.prepareStatement(EventSqlQueries.INSERT_QUERY, new String[] {"id"});
                    ps.setObject(1, charityId);
                    ps.setObject(2, eventCreateDto.charityAdminId());
                    ps.setString(3, eventCreateDto.name());
                    ps.setString(4, eventCreateDto.description());
                    ps.setString(5, eventCreateDto.location().country());
                    ps.setString(6, eventCreateDto.location().city());
                    ps.setString(7, eventCreateDto.location().district());
                    ps.setString(8, eventCreateDto.location().address());
                    ps.setString(9, eventCreateDto.category());
                    ps.setObject(10, eventCreateDto.startDate());
                    ps.setObject(11, eventCreateDto.startTime());
                    ps.setObject(12, eventCreateDto.duration());
                    ps.setString(13, eventCreateDto.requirement());
                    ps.setString(14, eventCreateDto.condition());
                    ps.setInt(15, eventCreateDto.numberOfVolunteers());
                    ps.setObject(16, LocalDateTime.now());
                    ps.setObject(17, LocalDateTime.now());
                    ps.setString(18, UserStatuses.ACTIVE.name());
                    return ps;
                }, keyHolder
            );
            return (UUID) keyHolder.getKeys().get("id");
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public EventDto getEventById(UUID id) {
        try {
            return eventJdbcTemplate.queryForObject(
                    EventSqlQueries.SELECT_QUERY, new EventRowMapper(), id);
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public EventDto updateEventById(UUID id, EventUpdateDto eventUpdateDto) {
        EventDto event = getEventById(id);

        if(event != null) {
            try{
                eventJdbcTemplate.update(EventSqlQueries.UPDATE_QUERY,
                        eventUpdateDto.name(),
                        eventUpdateDto.description(),
                        eventUpdateDto.location().country(),
                        eventUpdateDto.location().city(),
                        eventUpdateDto.location().district(),
                        eventUpdateDto.location().address(),
                        eventUpdateDto.category(),
                        eventUpdateDto.startDate(),
                        eventUpdateDto.startTime(),
                        eventUpdateDto.duration(),
                        eventUpdateDto.requirement(),
                        eventUpdateDto.condition(),
                        eventUpdateDto.numberOfVolunteers(),
                        LocalDateTime.now(),
                        id
                );
                return getEventById(id);
            } catch (RuntimeException exception) {
                throw new RuntimeException(exception.getMessage());
            }
        }
        else {
            throw new RuntimeException("Boyle Bir Event Bulunamadi!");
        }
    }

    @Override
    public ResponseEntity<Void> deleteEventById(UUID id) {
        EventDto event = getEventById(id);

        if(event != null) {
            try {
                eventJdbcTemplate.update(EventSqlQueries.DELETE_QUERY, id);
                return ResponseEntity.noContent().build();

            } catch (RuntimeException exception) {
                throw new RuntimeException(exception.getMessage());
            }
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
