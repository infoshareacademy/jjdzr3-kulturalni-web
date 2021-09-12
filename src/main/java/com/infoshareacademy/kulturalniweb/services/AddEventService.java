package com.infoshareacademy.kulturalniweb.services;


import com.infoshareacademy.kulturalniweb.entities.event.EventEntity;
import com.infoshareacademy.kulturalniweb.mappers.EventMapper;
import com.infoshareacademy.kulturalniweb.models.dto.AddEventDto;
import com.infoshareacademy.kulturalniweb.models.dto.EventDto;
import com.infoshareacademy.kulturalniweb.repository.EventsRepository;
import org.springframework.stereotype.Service;

@Service
public class AddEventService {
    EventSimpleMemoryServiceClass eventSimpleMemoryServiceClass;
    EventMapper eventMapper;
    EventsRepository eventsRepository;

    public AddEventService(EventSimpleMemoryServiceClass eventSimpleMemoryServiceClass, EventMapper eventMapper, EventsRepository eventsRepository) {
        this.eventSimpleMemoryServiceClass = eventSimpleMemoryServiceClass;
        this.eventMapper = eventMapper;
        this.eventsRepository = eventsRepository;
    }

/*    public Integer getHighestEventId() {
        Integer highestId = 0;
        List<EventSimple> list = eventSimpleMemoryServiceClass.getListOfEventSimpleFromMemory();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEventSimpleId() >= highestId) {
                highestId = list.get(i).getEventSimpleId();
            }
        }
        return highestId;
    }*/

/*    public void saveEventSimpleToMemory(EventSimple eventSimple) {
        eventSimpleMemoryServiceClass.saveEventSimpleToMemory(eventSimple);
    }

    public void saveAddedEvent(AddEventDto addEventDto) {
        EventEntity eventEntity = eventMapper.mapAddEventDtoToEventEntity(addEventDto);
        eventsRepository.updateEvent(eventEntity);
    }*/

    public void save(AddEventDto addEventDto) {
        EventEntity eventEntity = eventMapper.mapAddEventDtoToEventEntity(addEventDto);
        eventsRepository.save(eventEntity);
    }

    public Integer getMaximumId() {
        return eventsRepository.getMaximumId();
    }

    public EventDto getSingleEvent(Integer maximumId) {
        EventEntity eventEntity = eventsRepository.getSingleEvent(maximumId);
        return eventMapper.mapEventEntityToEventDto(eventEntity);
    }
}
