package com.infoshareacademy.kulturalniweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SingleEventController {

    //@PostMapping("/singleEvent")
    @GetMapping("/singleevent")
    public String singleEvent() {

        return "singleevent";
    }

    @PostMapping("/toggleFavourite")
    public String toggleFavourite() {
        return "toggleFavourite";
    }


}
