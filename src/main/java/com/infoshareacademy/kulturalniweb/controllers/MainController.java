package com.infoshareacademy.kulturalniweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class MainController {

    //przesunac do wlasciwego kontrolera!!!
    @GetMapping("/allevents")
    public String allevents() {
        return "allevents";
    }

    //przesunac do wlasciwego kontrolera!!!
    @GetMapping("/singleevent")
    public String singleevent() {
        return "singleevent";
    }

    @GetMapping("/")
    public String displayMainPage(Model model) {
        return "index";
    }
}
