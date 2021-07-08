package com.infoshareacademy.kulturalniweb.services;

import com.infoshareacademy.kulturalniweb.domainData.EventSimple;
import com.infoshareacademy.kulturalniweb.repository.EventSimpleMemory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SortingServices {
    private String eventFilterType = "all";
    private String eventFilterPlace = "all";
    private String eventSortType = "date";
    private String eventSortDirection = "descending";

    EventSimpleMemory eventSimpleMemory;
    EventSimpleMemoryServiceClass eventSimpleMemoryServiceClass;

    public SortingServices(EventSimpleMemory eventSimpleMemory, EventSimpleMemoryServiceClass eventSimpleMemoryServiceClass) {
        this.eventSimpleMemory = eventSimpleMemory;
        this.eventSimpleMemoryServiceClass = eventSimpleMemoryServiceClass;
    }

    public List<EventSimple> sortByType() {
        List<EventSimple> listOfEventSimple = eventSimpleMemory.getListOfEventSimple();
        Comparator<EventSimple> comparator;

        if (eventSortDirection.equals("ascending")) {
            if (eventSortType.equals("date")) {
                comparator = (e1, e2) -> e1.getEventSimpleDate().compareToIgnoreCase(e2.getEventSimpleDate());
            } else if (eventSortType.equals("city")) {
                comparator = (e1, e2) -> e1.getEventSimpleCity().compareToIgnoreCase(e2.getEventSimpleCity());
            } else if (eventSortType.equals("name")) {
                comparator = (e1, e2) -> e1.getEventSimpleName().compareToIgnoreCase(e2.getEventSimpleName());
            } else {
                comparator = (e1, e2) -> e1.getEventSimpleName().compareToIgnoreCase(e2.getEventSimpleName());
            }
            Collections.sort(listOfEventSimple, comparator);
        } else {
            if (eventSortType.equals("date")) {
                comparator = (e1, e2) -> e1.getEventSimpleDate().compareToIgnoreCase(e2.getEventSimpleDate());
            } else if (eventSortType.equals("city")) {
                comparator = (e1, e2) -> e1.getEventSimpleCity().compareToIgnoreCase(e2.getEventSimpleCity());
            } else if (eventSortType.equals("name")) {
                comparator = (e1, e2) -> e1.getEventSimpleName().compareToIgnoreCase(e2.getEventSimpleName());
            } else {
                comparator = (e1, e2) -> e1.getEventSimpleName().compareToIgnoreCase(e2.getEventSimpleName());
            }
            Collections.sort(listOfEventSimple, comparator.reversed());
        }
        eventSimpleMemory.setListOfEventSimple(listOfEventSimple);

        return listOfEventSimple;
    }


    public void updateSortDirection() {
        List<EventSimple> listOfEventSimple = eventSimpleMemory.getListOfEventSimple();
        Comparator<EventSimple> comparator;

        if (eventSortDirection.equals("ascending")) {
            if (eventSortType.equals("date")) {
                comparator = (e1, e2) -> e1.getEventSimpleDate().compareToIgnoreCase(e2.getEventSimpleDate());
            } else if (eventSortType.equals("city")) {
                comparator = (e1, e2) -> e1.getEventSimpleCity().compareToIgnoreCase(e2.getEventSimpleCity());
            } else if (eventSortType.equals("name")) {
                comparator = (e1, e2) -> e1.getEventSimpleName().compareToIgnoreCase(e2.getEventSimpleName());
            } else {
                comparator = (e1, e2) -> e1.getEventSimpleName().compareToIgnoreCase(e2.getEventSimpleName());
            }
            Collections.sort(listOfEventSimple, comparator);
        } else {
            if (eventSortType.equals("date")) {
                comparator = (e1, e2) -> e1.getEventSimpleDate().compareToIgnoreCase(e2.getEventSimpleDate());
            } else if (eventSortType.equals("city")) {
                comparator = (e1, e2) -> e1.getEventSimpleCity().compareToIgnoreCase(e2.getEventSimpleCity());
            } else if (eventSortType.equals("name")) {
                comparator = (e1, e2) -> e1.getEventSimpleName().compareToIgnoreCase(e2.getEventSimpleName());
            } else {
                comparator = (e1, e2) -> e1.getEventSimpleName().compareToIgnoreCase(e2.getEventSimpleName());
            }
            Collections.sort(listOfEventSimple, comparator.reversed());
        }
        eventSimpleMemory.setListOfEventSimple(listOfEventSimple);


    }

    public List<EventSimple> filterByPlace() {
        List<EventSimple> eventsToDisplay = new ArrayList<>();
        List<EventSimple> events = eventSimpleMemoryServiceClass.getListOfEventSimpleMemory();

        if (eventFilterPlace.equals("all")) {
            return events;
        } else if (eventFilterPlace.equals("Miejski Teatr MINIATURA")) {
            eventsToDisplay = events.stream().filter((x) -> x.getEventSimplePlace().equals(getEventFilterPlace())).collect(Collectors.toList());
            return eventsToDisplay;
        } else if (eventFilterPlace.equals("Gdański Archipelag Kultury")) {
            eventsToDisplay = events.stream().filter((x) -> x.getEventSimplePlace().equals(getEventFilterPlace())).collect(Collectors.toList());
            return eventsToDisplay;
        } else {
            return events;
        }
    }









    public String getEventFilterType() {
        return eventFilterType;
    }

    public void setEventFilterType(String eventFilterType) {
        this.eventFilterType = eventFilterType;
    }

    public String getEventFilterPlace() {
        return eventFilterPlace;
    }

    public void setEventFilterPlace(String eventFilterPlace) {
        this.eventFilterPlace = eventFilterPlace;
    }

    public String getEventSortType() {
        return eventSortType;
    }

    public void setEventSortType(String eventSortType) {
        this.eventSortType = eventSortType;
    }

    public String getEventSortDirection() {
        return eventSortDirection;
    }

    public void setEventSortDirection(String eventSortDirection) {
        this.eventSortDirection = eventSortDirection;
    }
}
