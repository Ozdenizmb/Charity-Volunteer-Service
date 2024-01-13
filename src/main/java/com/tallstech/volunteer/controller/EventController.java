package com.tallstech.volunteer.controller;

import com.tallstech.volunteer.api.EventApi;
import com.tallstech.volunteer.dto.EventCreateDto;
import com.tallstech.volunteer.dto.EventDto;
import com.tallstech.volunteer.dto.EventUpdateDto;
import com.tallstech.volunteer.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class EventController implements EventApi {

    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    public ResponseEntity<UUID> createEvent(EventCreateDto eventCreateDto) {
        return ResponseEntity.ok(eventService.createEvent(eventCreateDto));
    }

    @Override
    public ResponseEntity<EventDto> getEventById(UUID id) {
        return ResponseEntity.ok(eventService.getEventById(id));
    }

    @Override
    public ResponseEntity<EventDto> updateEventById(UUID id, EventUpdateDto eventUpdateDto) {
        return ResponseEntity.ok(eventService.updateEventById(id, eventUpdateDto));
    }

    @Override
    public ResponseEntity<Void> deleteEventById(UUID id) {
        return eventService.deleteEventById(id);
    }
}
