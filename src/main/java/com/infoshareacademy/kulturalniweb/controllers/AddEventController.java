package com.infoshareacademy.kulturalniweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddEventController {

    @GetMapping("/addEvent")
    public String addEvent(Model model) {
        return "addeventform";
    }
}
