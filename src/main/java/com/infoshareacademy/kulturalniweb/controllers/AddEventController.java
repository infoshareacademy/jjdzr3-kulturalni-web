package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.domainData.EventNew;
import com.infoshareacademy.kulturalniweb.models.NewEventDto;
import com.infoshareacademy.kulturalniweb.services.AddEventService;
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
    AddEventService addEventService;

    final String PATH_TO_PICTURES = "images/img/events/";

    public AddEventController(RepositoryServiceClass repositoryServiceClass, AddEventService addEventService) {
        this.repositoryServiceClass = repositoryServiceClass;
        this.addEventService = addEventService;
    }

    @GetMapping("/addevent")
    public String addEvent(Model model) {
        NewEventDto newEventDto = new NewEventDto();

        Integer idForNewEvent = addEventService.getHighestEventId() + 5;

        model.addAttribute("newEventDto", newEventDto);
        model.addAttribute("idForNewEvent", idForNewEvent);

        return "addeventform";
    }





    @PostMapping(value = "/saveevent")
    public String addEvent(@ModelAttribute @Valid NewEventDto newEventDto, BindingResult result, Model model) {
        model.addAttribute("newEventDto", newEventDto);

        if (result.hasFieldErrors()) {
            return "addeventform";
        } else {
            EventNew eventNew = repositoryServiceClass.createEventNewFromNewEventDto(newEventDto);
            repositoryServiceClass.saveEventNew(eventNew);
            return "eventsaved";
        }
    }




}
