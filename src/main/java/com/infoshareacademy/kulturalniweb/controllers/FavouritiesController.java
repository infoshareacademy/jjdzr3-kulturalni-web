package com.infoshareacademy.kulturalniweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FavouritiesController {

    @GetMapping("/favourities")
    public String favourities () {
        return "favourities";
    }
}
