package com.infoshareacademy.kulturalniweb.services;

import com.infoshareacademy.kulturalniweb.entities.event.EventEntity;
import com.infoshareacademy.kulturalniweb.mappers.EventMapper;
import com.infoshareacademy.kulturalniweb.models.dto.EventDto;
import com.infoshareacademy.kulturalniweb.repository.EventsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavouritesService {

    EventsRepository eventsRepository;
    EventMapper eventMapper;

    public FavouritesService(EventsRepository eventsRepository, EventMapper eventMapper) {
        this.eventsRepository = eventsRepository;
        this.eventMapper = eventMapper;
    }

    public List<EventDto> getFavourites() {
        List<EventEntity> eventEntities = eventsRepository.getFavourites();
        List<EventDto> eventDtos = new ArrayList<>();

        for (EventEntity eventEntity : eventEntities) {
            eventDtos.add(eventMapper.mapEventEntityToEventDto(eventEntity));
        }

        return eventDtos;
    }

    public void updateFavourite(Integer id, Boolean favStatus) {
        eventsRepository.updateFavourite(id, favStatus);
    }
}
