package com.infoshareacademy.kulturalniweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddEventController {

    @GetMapping("/addevent")
    public String addEvent() {

        return "addevent";
    }




}
