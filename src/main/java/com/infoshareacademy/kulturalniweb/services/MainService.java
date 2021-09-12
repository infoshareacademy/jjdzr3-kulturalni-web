package com.infoshareacademy.kulturalniweb.services;

import org.springframework.stereotype.Service;

@Service
public class MainService {

    EventService eventService;

    public MainService(EventService eventService) {
        this.eventService = eventService;
    }

    public Integer getSizeOfDB() {
        return eventService.getSizeOfDB();
    }
}
