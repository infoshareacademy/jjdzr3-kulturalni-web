package com.infoshareacademy.kulturalniweb.services;

import com.infoshareacademy.kulturalniweb.domainData.EventNew;
import com.infoshareacademy.kulturalniweb.domainData.EventSimple;
import com.infoshareacademy.kulturalniweb.repository.EventRepositoryInFile;
import com.infoshareacademy.kulturalniweb.repository.ListEventRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepositoryServiceClass {
    ListEventRepository listEventRepository;

    public RepositoryServiceClass(ListEventRepository listEventRepository) {
        this.listEventRepository = listEventRepository;
    }

    public EventSimple getSingleEventSimpleById(Integer eventNewId) {
        EventSimple eventSimple = new EventSimple();

        for (Integer i=0; i < listEventRepository.getEventsDB().size(); i++){
            if(listEventRepository.getEventsDB().get(i).getId().equals(eventNewId)) {
                eventSimple = createSingleEventSimple(listEventRepository.getEventsDB().get(i));
            }
        }
        return eventSimple;
    }

    public EventSimple getSingleEventSimpleFromList(Integer pointer) {
        System.out.println("list");
        return createSingleEventSimple(listEventRepository.getEventsDB().get(pointer));
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

    public List<EventSimple> getListOfEventSimple(Integer numberOfEventsOnThePage) {
        List<EventSimple> listOfEventSimple = new ArrayList<>();

        for (int i = 0; i < numberOfEventsOnThePage; i++) {
            listOfEventSimple.add(getSingleEventSimpleFromList(i));
        }
        return listOfEventSimple;
    }

    public List<EventSimple> getListOfEventSimple() {
        List<EventSimple> listOfEventSimple = new ArrayList<>();

        for (int i = 0; i < listEventRepository.getEventsDB().size(); i++) {
            listOfEventSimple.add(getSingleEventSimpleFromList(i));

            System.out.println(i + " = " + getSingleEventSimpleFromList(i).getEventSimpleDescriptionShort());
        }
        System.out.println("newest= " + listOfEventSimple.size());
        return listOfEventSimple;
    }
    
    
    
}
