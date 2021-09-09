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

        EventDto resultDto = recodecategoryId(eventDto);

        model.addAttribute("singleEvent", resultDto);

        return "singleEvent";
    }

    @PostMapping("/toggleFavourite")
    public String toggleFavourite() {
        return "toggleFavourite";
    }

    private EventDto recodecategoryId(EventDto eventDtoFromDB) {
        EventDto result = eventDtoFromDB;
        String code = result.getCategoryId();

        if(code.equals("1")) {
            result.setCategoryId("Kino");
        } else if(code.equals("19")) {
            result.setCategoryId("Teatr");
        } else if(code.equals("1")) {
            result.setCategoryId("Kino");
        } else if(code.equals("51")) {
            result.setCategoryId("Sztuka");
        } else if(code.equals("35")) {
            result.setCategoryId("Muzyka");
        } else if(code.equals("83")) {
            result.setCategoryId("Nauka");
        } else if(code.equals("61")) {
            result.setCategoryId("Literatura");
        } else if(code.equals("69")) {
            result.setCategoryId("Rozrywka");
        } else if(code.equals("77")) {
            result.setCategoryId("Rekreacja");
        } else {
            result.setCategoryId("Inne");
        }

        return result;
    }


}
