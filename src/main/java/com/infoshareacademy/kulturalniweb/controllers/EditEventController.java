package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.models.dto.EventDto;
import com.infoshareacademy.kulturalniweb.mappers.EventMapper;
import com.infoshareacademy.kulturalniweb.models.dto.EditEventDto;
import com.infoshareacademy.kulturalniweb.services.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class EditEventController {

    EventService eventService;
    EventMapper eventMapper;

    public EditEventController(EventService eventService, EventMapper eventMapper) {
        this.eventService = eventService;
        this.eventMapper = eventMapper;
    }

    @GetMapping("/editEvent")
    public String editEvent(Model model) {
        Integer id = 71005;
        EventDto eventDto = eventService.getSingleEvent(id);
        EditEventDto editEventDto = new EditEventDto();
        editEventDto.setEventDto(eventDto);

        model.addAttribute("editEventDto", editEventDto);

        return "editEventForm";
    }

    @PostMapping("/updateEvent")
    public String updateEvent(@ModelAttribute @Valid EditEventDto editEventDto, BindingResult result, Model model) {

        EditEventDto editEventDtoForTemplate = eventMapper.mapEditEventDtoReceivedToEditEventDtoForTemplate(editEventDto);
        System.out.println(editEventDto.getNewEventPlace());

 /*       model.addAttribute("newEventDto", newEventDto);
        if (result.hasFieldErrors()) {
            return "addEventForm";
        } else {
            EventNew eventNew = repositoryServiceClass.createEventNewFromNewEventDto(newEventDto);
            repositoryServiceClass.saveEventNew(eventNew);
            model.addAttribute("newEventDto", newEventDto);
            return "saveEvent";
        }*/

        return "updateEvent";
    }
}
