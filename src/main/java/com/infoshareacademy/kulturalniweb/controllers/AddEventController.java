package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.models.NewEventDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AddEventController {

    @GetMapping("/addevent")
    public String addEvent(Model model) {
        NewEventDto newEventDto = new NewEventDto();

        model.addAttribute("newEventDto", newEventDto);

        return "addeventform";
    }





    @PostMapping(value = "/saveevent")
    public String addEvent(@ModelAttribute @Valid NewEventDto newEventDto, BindingResult result, Model model) {
        model.addAttribute("newEventDto", newEventDto);

        if (result.hasFieldErrors()) {
            return "addeventform";
        } else {

            return "eventsaved";
        }
    }




}
