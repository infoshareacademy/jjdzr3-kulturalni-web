package com.infoshareacademy.kulturalniweb.services;


import com.infoshareacademy.kulturalniweb.entities.event.EventEntity;
import com.infoshareacademy.kulturalniweb.mappers.EventMapper;
import com.infoshareacademy.kulturalniweb.models.dto.EditEventDto;
import com.infoshareacademy.kulturalniweb.models.dto.EventDto;
import org.springframework.stereotype.Service;

@Service
public class EditEventService {

    EventMapper eventMapper;
    EventService eventService;

    public EditEventService(EventMapper eventMapper, EventService eventService) {
        this.eventMapper = eventMapper;
        this.eventService = eventService;
    }

    public void saveEditedEvent(EditEventDto editEventDto) {
        EventEntity eventEntity = eventMapper.mapEditEventDtoToEventEntity(editEventDto);
        eventService.saveEditedEvent(eventEntity);


    }

    public EventDto getSingleEvent(Integer id) {
        return eventService.getSingleEvent(id);
    }
}
