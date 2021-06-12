package com.infoshareacademy.kulturalniweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FavouritiesController {

    @GetMapping("/favourities")
    public String favourities () {
        return "favourities";
    }

    @PostMapping("/favouritiesAdd")
    public String favouritiesAdd() {

        return "favourities";
    }

    @PostMapping("/favouritiesRemove")
    public String favouritiesRemove() {

        return "favourities";
    }
}
