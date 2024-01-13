package com.tallstech.volunteer.service.impl;

import com.tallstech.volunteer.dto.EventCreateDto;
import com.tallstech.volunteer.dto.EventDto;
import com.tallstech.volunteer.dto.EventUpdateDto;
import com.tallstech.volunteer.repository.EventRepository;
import com.tallstech.volunteer.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public UUID createEvent(EventCreateDto eventCreateDto) {
        return eventRepository.createEvent(eventCreateDto);
    }

    @Override
    public EventDto getEventById(UUID id) {
        return eventRepository.getEventById(id);
    }

    @Override
    public EventDto updateEventById(UUID id, EventUpdateDto eventUpdateDto) {
        return eventRepository.updateEventById(id, eventUpdateDto);
    }

    @Override
    public ResponseEntity<Void> deleteEventById(UUID id) {
        return eventRepository.deleteEventById(id);
    }
}
