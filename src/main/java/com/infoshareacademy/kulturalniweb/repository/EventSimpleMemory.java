package com.infoshareacademy.kulturalniweb.repository;

import com.infoshareacademy.kulturalniweb.domainData.EventSimple;
import com.infoshareacademy.kulturalniweb.services.RepositoryServiceClass;
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

    public List<EventSimple> getListOfEventSimple() {
        return listOfEventSimple;
    }

    public void setListOfEventSimple(List<EventSimple> listOfEventSimple) {
        this.listOfEventSimple = listOfEventSimple;
    }
}

/*
    public void prepareSimpleEventsListFromRepository() {
        List<EventSimple> listOfEventSimple = new ArrayList<>();

        for (int i = 0; i < listEventRepository.getEventsDB().size(); i++) {
            listOfEventSimple.add(getSingleEventSimpleFromList(i));

            System.out.println(i + " = " + getSingleEventSimpleFromList(i).getEventSimpleDescriptionShort());
        }
        System.out.println("newest= " + listOfEventSimple.size());
        return listOfEventSimple;
    }*/
