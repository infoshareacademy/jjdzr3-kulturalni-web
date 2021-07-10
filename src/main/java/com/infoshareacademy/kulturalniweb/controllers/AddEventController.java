package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.models.NewEventDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AddEventController {

    @GetMapping("/addEvent")
    public String addEvent(Model model) {
        return "addeventform";
    }

    @PostMapping(value = "/saveEvent")
    public String addEvent(@ModelAttribute @Valid NewEventDto newEventDto, BindingResult result, Model model) {
        model.addAttribute("newEventDto", newEventDto);
        if (result.hasFieldErrors()) {
            return "addeventform";
        } else {
            return "saveEvent";
        }
    }
}

