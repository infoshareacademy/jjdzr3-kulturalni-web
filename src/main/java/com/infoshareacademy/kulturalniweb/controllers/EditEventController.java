package com.infoshareacademy.kulturalniweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EditEventController {


    @GetMapping("/editEvent")
    public String editEvent(Model model) {


        return "editevent";
    }
}
