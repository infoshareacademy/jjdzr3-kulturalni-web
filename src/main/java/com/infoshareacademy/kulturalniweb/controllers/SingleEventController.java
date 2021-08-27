package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.dto.EventDto;
import com.infoshareacademy.kulturalniweb.jsonData.EventSimple;
import com.infoshareacademy.kulturalniweb.services.EventService;
import com.infoshareacademy.kulturalniweb.services.EventSimpleMemoryServiceClass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SingleEventController {
    //ListEventRepository listEventRepository;
    EventSimpleMemoryServiceClass eventSimpleMemoryServiceClass;
    EventService eventService;

    public SingleEventController(EventSimpleMemoryServiceClass eventSimpleMemoryServiceClass, EventService eventService) {
        this.eventSimpleMemoryServiceClass = eventSimpleMemoryServiceClass;
        this.eventService = eventService;
    }

    @GetMapping(value = "/singleevent")
    public String singleEvent(@RequestParam("id") Integer id, Model model) {
        EventDto eventDto = eventService.getSingleEvent(id);

        if(eventDto.getTicket().equals("unknown")) {
            eventDto.setTicket("Brak informacji");
        }

        model.addAttribute("singleEvent", eventDto);

        return "singleevent";
    }

    @PostMapping("/toggleFavourite")
    public String toggleFavourite() {
        return "toggleFavourite";
    }


}
