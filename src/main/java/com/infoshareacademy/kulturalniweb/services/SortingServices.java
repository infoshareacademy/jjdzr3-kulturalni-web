package com.infoshareacademy.kulturalniweb.services;

import com.infoshareacademy.kulturalniweb.domainData.EventSimple;
import com.infoshareacademy.kulturalniweb.repository.EventSimpleMemory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.*;
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


    public void sortBySelectedCriteria() {
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

    public void filterByPlace() {
        List<EventSimple> listOfEventSimple = eventSimpleMemory.getListOfEventSimple();
        List<EventSimple> result = new ArrayList<>();

        if (eventFilterPlace.equals("all")) {
            eventSimpleMemory.setListOfEventSimple(listOfEventSimple);
        } else if (eventFilterPlace.equals("Miejski Teatr MINIATURA")) {
            result = listOfEventSimple.stream().filter((x) -> x.getEventSimplePlace().equals(eventFilterPlace)).collect(Collectors.toList());
            eventSimpleMemory.setListOfEventSimple(result);
        } else if (eventFilterPlace.equals("Gdański Archipelag Kultury")) {
            result = listOfEventSimple.stream().filter((x) -> x.getEventSimplePlace().equals(eventFilterPlace)).collect(Collectors.toList());
            eventSimpleMemory.setListOfEventSimple(result);
        } else {
            eventSimpleMemory.setListOfEventSimple(listOfEventSimple);
        }
    }

    public List<EventSimple> sortByIdDescending () {
        List<EventSimple> listOfEventSimple = eventSimpleMemory.getListOfEventSimple();

        Comparator<EventSimple> comparator;
        comparator = (e1, e2) -> e1.getEventSimpleId() - e2.getEventSimpleId();
        Collections.sort(listOfEventSimple, comparator.reversed());

        return listOfEventSimple;
    }

    public List<EventSimple> createListOfClosestEvents() {
        List<EventSimple> listOfEventSimple = eventSimpleMemory.getListOfEventSimple();

        Comparator<EventSimple> comparator;
        comparator = (e1, e2) -> e1.getEventSimpleDate().compareToIgnoreCase(e2.getEventSimpleDate());
        Collections.sort(listOfEventSimple, comparator.reversed());

        String todaysDate = "2021-03-29";
        LocalDate todaysDatelocalDate = LocalDate.parse(todaysDate);
        List<EventSimple> result = new ArrayList<>();

        for (int i = 0; i < listOfEventSimple.size(); i++) {
            String date = listOfEventSimple.get(i).getEventSimpleDate();
            LocalDate eventSimpleLocalDate = LocalDate.parse(date);

            if (eventSimpleLocalDate.isAfter(todaysDatelocalDate.minusDays(1))) {
                result.add(listOfEventSimple.get(i));
            }
        }

        List<EventSimple> resultShortList = new ArrayList<>();
        resultShortList.add(result.get(result.size() - 1));
        resultShortList.add(result.get(result.size() - 2));
        resultShortList.add(result.get(result.size() - 3));

        System.out.println(resultShortList.size());
        return resultShortList;
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
