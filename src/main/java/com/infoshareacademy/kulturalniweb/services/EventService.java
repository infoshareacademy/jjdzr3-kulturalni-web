package com.infoshareacademy.kulturalniweb.services;

import com.infoshareacademy.kulturalniweb.models.dto.EventDto;
import com.infoshareacademy.kulturalniweb.entities.event.EventEntity;
import com.infoshareacademy.kulturalniweb.jsonData.EventNew;
import com.infoshareacademy.kulturalniweb.mappers.DateMapper;
import com.infoshareacademy.kulturalniweb.mappers.EventMapper;
import com.infoshareacademy.kulturalniweb.repository.EventsRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EventService {

    EventsRepository eventsRepository;
    EventMapper eventMapper;
    DateMapper dateMapper;

    public EventService(EventsRepository eventsRepository, EventMapper eventMapper, DateMapper dateMapper) {
        this.eventsRepository = eventsRepository;
        this.eventMapper = eventMapper;
        this.dateMapper = dateMapper;
    }

    public void eventEntityFromJsonSave(EventNew eventNew) {
        EventEntity eventEntity = eventMapper.mapEventNewToEventEntity(eventNew);
        dateMapper.map(eventEntity);
        eventsRepository.save(eventEntity);
    }

/*    public List<EventNew> eventDtoFindAll() {
        List<EventEntity> list = (List<EventEntity>) eventsRepository.findAll();
        return null;
    }*/

    public EventDto getSingleEvent(Integer id) {
        EventEntity eventEntity = eventsRepository.getSingleEvent(id);
        return eventMapper.mapEventEntityToEventDto(eventEntity);
    }

    public List<EventDto> createListOfSortedEventEntities(Map<String, String> sortingParameters) {
        List<EventEntity> eventEntities = eventsRepository.createListOfSortedEventEntities(sortingParameters);
        List<EventDto> eventDtos = new ArrayList<>();

        for (EventEntity eventEntity : eventEntities) {
            eventDtos.add(eventMapper.mapEventEntityToEventDto(eventEntity));
        }

        return eventDtos;
    }


    public Integer getSizeOfListOfSortedEventEntities(Map<String, String> sortingParameters) {
        List<EventEntity> eventEntities = eventsRepository.getSizeOfListOfSortedEventEntities(sortingParameters);
        return eventEntities.size();
    }

    public void updateFavourite(Integer id, Boolean favStatus) {
        eventsRepository.updateFavourite(id, favStatus);
    }

    public void saveEditedEvent(EventEntity eventEntity) {
        eventsRepository.updateEvent(eventEntity);
    }

    public Integer getSizeOfDB() {
        return eventsRepository.getSizeOfDB();
    }
}
