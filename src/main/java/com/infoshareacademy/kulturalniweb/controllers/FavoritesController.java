package com.infoshareacademy.kulturalniweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class FavoritesController implements ControllerEntity{

    @GetMapping("/favorites")
    public String displayPage() {
        return "favorites/index";
    }


}
