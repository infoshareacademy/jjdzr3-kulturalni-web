package com.infoshareacademy.kulturalniweb.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class SortingServices {

    @PostMapping("/sortEventsDirection")
    public String sortingDirection() {

        return "allEvents";
    }

    @PostMapping("/sortEventsDate")
    public String sortEventsDate() {

        return "allEvents";
    }

    @PostMapping("/sortEventsPlace")
    public String sortEventsPlace() {

        return "sortEventsPlace";
    }
}
