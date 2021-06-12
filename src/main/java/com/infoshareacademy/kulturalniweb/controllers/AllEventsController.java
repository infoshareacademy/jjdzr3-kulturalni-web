package com.infoshareacademy.kulturalniweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AllEventsController {

    @GetMapping("/allEvents")
    public String allEvents (Model model) {
        return "allEvents";
    }
}
