package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.dto.AddEventDto;
import com.infoshareacademy.kulturalniweb.dto.EventDto;
import com.infoshareacademy.kulturalniweb.services.AddEventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class AddEventController {

    AddEventService addEventService;

    public AddEventController(AddEventService addEventService) {
        this.addEventService = addEventService;
    }

    @GetMapping("/addEvent")
    public String addEvent(Model model) {
        AddEventDto addEventDto = new AddEventDto();
        model.addAttribute("addEventDto", addEventDto);
        return "addEventForm1";
    }

    @PostMapping(value = "/saveEvent")
    public String addEvent(@ModelAttribute @Valid AddEventDto addEventDto, BindingResult result, Model model) {
        model.addAttribute("addEventDto", addEventDto);
        if (result.hasFieldErrors()) {
            return "addEventForm1";
        } else {
            String path = "images/img/events/" + addEventDto.getPicture();
            addEventDto.setPicture(path);
            addEventService.save(addEventDto);

            Integer maximumId = addEventService.getMaximumId();
            EventDto eventDtoFromDB = addEventService.getSingleEvent(maximumId);
            EventDto resultDto = recodecategoryId(eventDtoFromDB);

            model.addAttribute("eventDto", resultDto);

            return "saveEvent";
        }
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

