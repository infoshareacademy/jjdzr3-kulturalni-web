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
    private final String GRAPHICS_PATH = "images/img/events/";

    public AddEventController(AddEventService addEventService) {
        this.addEventService = addEventService;
    }

    @GetMapping("/addEvent")
    public String addEvent(Model model) {
        AddEventDto addEventDto = new AddEventDto();
        model.addAttribute("addEventDto", addEventDto);
        return "addEventForm";
    }

    @PostMapping(value = "/saveEvent")
    public String addEvent(@ModelAttribute @Valid AddEventDto addEventDto, BindingResult result, Model model) {
        model.addAttribute("addEventDto", addEventDto);
        if (result.hasFieldErrors()) {
            return "addEventForm";
        } else {

            addEventService.saveAddedEvent(addEventDto);

            //String filePath = GRAPHICS_PATH + addEventDto.getPicture();
            //addEventDto.setPicture(filePath);

            Integer maximumId = addEventService.getMaximumId();
            EventDto eventDtoFromDB = addEventService.getSingleEvent(maximumId);

            model.addAttribute("eventDto", eventDtoFromDB);


            return "saveEvent";
        }
    }
}

