package com.infoshareacademy.kulturalniweb.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class EventsController implements ControllerEntity{

    @GetMapping("/events")
    public String displayPage() {
        return "events/index";
    }



}
