package com.infoshareacademy.kulturalniweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FavouritesController {

    @GetMapping("/favourites")
    public String favourites() {
        return "favourites";
    }

    /*@PostMapping("/favouritesAdd")
    public String favouritesAdd() {

        return "favourites";
    }

    @PostMapping("/favouritesRemove")
    public String favouritesRemove() {

        return "favourites";
    }*/
}
