package com.tallstech.volunteer.service;

import com.tallstech.volunteer.dto.EventCreateDto;
import com.tallstech.volunteer.dto.EventDto;
import com.tallstech.volunteer.dto.EventUpdateDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface EventService {

    UUID createEvent(EventCreateDto eventCreateDto);

    EventDto getEventById(UUID id);

    EventDto updateEventById(UUID id, EventUpdateDto eventUpdateDto);

    ResponseEntity<Void> deleteEventById(UUID id);

}
