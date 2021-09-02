package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.jsonData.EventNew;
import com.infoshareacademy.kulturalniweb.models.dto.NewEventDto;
import com.infoshareacademy.kulturalniweb.services.RepositoryServiceClass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AddEventController {

    RepositoryServiceClass repositoryServiceClass;

    public AddEventController(RepositoryServiceClass repositoryServiceClass) {
        this.repositoryServiceClass = repositoryServiceClass;
    }

    @GetMapping("/addEvent")
    public String addEvent(Model model) {
        NewEventDto newEventDto = new NewEventDto();
        model.addAttribute("newEventDto", newEventDto);
        return "addEventForm";
    }

    @PostMapping(value = "/saveEvent")
    public String addEvent(@ModelAttribute @Valid NewEventDto newEventDto, BindingResult result, Model model) {
        model.addAttribute("newEventDto", newEventDto);
        if (result.hasFieldErrors()) {
            return "addEventForm";
        } else {
            EventNew eventNew = repositoryServiceClass.createEventNewFromNewEventDto(newEventDto);
            repositoryServiceClass.saveEventNew(eventNew);
            model.addAttribute("newEventDto", newEventDto);
            return "saveEvent";
        }
    }
}

