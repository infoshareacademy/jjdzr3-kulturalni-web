package com.infoshareacademy.kulturalniweb.repository;

import com.infoshareacademy.kulturalniweb.domainData.EventSimple;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventSimpleMemory {
    ListEventRepository listEventRepository;
    private List<EventSimple> listOfEventSimple = new ArrayList<>();

    public EventSimpleMemory(ListEventRepository listEventRepository) {
        this.listEventRepository = listEventRepository;
    }

    public void clear() {
        listOfEventSimple.clear();
    }

    public List<EventSimple> getListOfEventSimple() {
        return listOfEventSimple;
    }

    public void setListOfEventSimple(List<EventSimple> listOfEventSimple) {
        this.listOfEventSimple = listOfEventSimple;
    }

    public void saveEventSimpleToMemory (EventSimple eventSimple) {
        listOfEventSimple.add(eventSimple);
        System.out.println("rozmiar bazy: " + listOfEventSimple.size());
    }
}

