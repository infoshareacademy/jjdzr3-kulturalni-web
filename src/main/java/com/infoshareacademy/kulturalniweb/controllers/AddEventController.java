package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.jsonData.EventSimple;
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
    Integer idForNewEvent;

    final String PATH_TO_PICTURES = "images/img/events/";

    public AddEventController(AddEventService addEventService) {
        this.addEventService = addEventService;
    }

    @GetMapping("/addevent")
    public String addEvent(Model model) {
        EventSimple eventSimple = new EventSimple();

        idForNewEvent = addEventService.getHighestEventId() + 5;
        eventSimple.setEventSimpleId(idForNewEvent);

        model.addAttribute("eventSimple", eventSimple);
        model.addAttribute("idForEventSimple", idForNewEvent);

        return "addeventform";
    }

    @PostMapping(value = "/saveevent")
    public String addEvent(@ModelAttribute @Valid EventSimple eventSimple, BindingResult result, Model model) {
        //model.addAttribute("idForEventSimple", eventSimple);

        if (result.hasFieldErrors()) {
            return "addeventform";
        } else {
            EventSimple eventSimpleWithFullPicturePath = createEventSimpleWithFullPathForPicture(eventSimple);
            eventSimpleWithFullPicturePath.setEventSimpleId(idForNewEvent);
            addEventService.saveEventSimpleToMemory(eventSimpleWithFullPicturePath);
            model.addAttribute("savedEventSimple", eventSimpleWithFullPicturePath);

            return "eventsaved";
        }
    }

    public EventSimple createEventSimpleWithFullPathForPicture(EventSimple eventSimple) {
        String path = PATH_TO_PICTURES;
        EventSimple result = eventSimple;

        String pictureName = result.getEventSimplePicture();
        path = path + pictureName;
        result.setEventSimplePicture(path);

        return result;
    }


}
