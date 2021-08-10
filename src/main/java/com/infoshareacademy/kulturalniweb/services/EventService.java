package com.infoshareacademy.kulturalniweb.services;

import com.infoshareacademy.kulturalniweb.dto.EventDto;
import com.infoshareacademy.kulturalniweb.entities.event.EventEntity;
import com.infoshareacademy.kulturalniweb.jsonData.EventNew;
import com.infoshareacademy.kulturalniweb.mappers.EventMapper;
import com.infoshareacademy.kulturalniweb.repository.EventsRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EventService {

    EventsRepository eventsRepository;
    EventMapper eventMapper;

    public EventService(EventsRepository eventsRepository, EventMapper eventMapper) {
        this.eventsRepository = eventsRepository;
        this.eventMapper = eventMapper;
    }

    public void eventDtoSave(EventNew eventNew) {
        System.out.println("DTO    " + eventNew.toString());
        EventEntity eventEntity = eventMapper.mapEventNewToEventEntity(eventNew);
        System.out.println("ENTITY " + eventEntity.toString());

        eventsRepository.save(eventEntity);
    }

    public List<EventNew> eventDtoFindAll() {
        List<EventEntity> list = (List<EventEntity>) eventsRepository.findAll();
       // List<EventDto> result = eventMapper.
        return null;
    }

    public EventDto getSingleEvent(Integer id) {
        EventEntity eventEntity = eventsRepository.getSingleEvent(id);

        return eventMapper.mapEventEntityToEventDto(eventEntity);
    }


}
