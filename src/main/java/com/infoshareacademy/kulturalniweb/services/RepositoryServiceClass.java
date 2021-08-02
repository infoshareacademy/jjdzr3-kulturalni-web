package com.infoshareacademy.kulturalniweb.services;

import com.infoshareacademy.kulturalniweb.jsonData.EventNew;
import com.infoshareacademy.kulturalniweb.jsonData.EventSimple;
import com.infoshareacademy.kulturalniweb.repository.ListEventRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class RepositoryServiceClass {
    ListEventRepository listEventRepository;

    public RepositoryServiceClass(ListEventRepository listEventRepository) {
        this.listEventRepository = listEventRepository;
    }

    public void readEventsFromGsonToList() {
        listEventRepository.readEventsFromGsonToList();
    }

    public EventSimple createSingleEventSimple(EventNew eventNew) {
        EventSimple eventSimple = new EventSimple();
        eventSimple.setEventSimpleId(eventNew.getId());
        eventSimple.setEventSimpleName(eventNew.getName());
        eventSimple.setEventSimpleDescription(eventNew.getDescLong());

        String[] date = eventNew.getStartDate().split("T");
        eventSimple.setEventSimpleDate(date[0]);

        String time = date[1].substring(0, 8);
        eventSimple.setEventSimpleStartTime(time);
        eventSimple.setEventSimpleEndTime(time);
        eventSimple.setEventSimplePlace(eventNew.getPlace().getName());
        eventSimple.setEventSimpleTicketPrice(0.0);
        eventSimple.setEventSimpleWebPageAddress(eventNew.getUrls().getWww());
        return eventSimple;
    }

    public EventNew createEventNewFromNewEventDto(com.infoshareacademy.kulturalniweb.models.@Valid NewEventDto newEventDto) {
        EventNew eventNew = new EventNew();

        //eventNew.setId(newEventDto.getNewEventID());
        eventNew.setId(95000);
        eventNew.setName(newEventDto.getNewEventName());
        eventNew.setDescLong(newEventDto.getNewEventDescription());
        eventNew.setStartDate(newEventDto.getNewEventStartDate() + "T" + newEventDto.getNewEventStartTime() + "-00:00");
        eventNew.setEndDate(newEventDto.getNewEventEndDate() + "T" + newEventDto.getNewEventEndTime() + "-00:00");


        return eventNew;
    }

    public void saveEventNew(EventNew eventNew) {
        listEventRepository.getEventsDB().add(eventNew);
    }

}
