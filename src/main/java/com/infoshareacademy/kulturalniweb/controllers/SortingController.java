package com.infoshareacademy.kulturalniweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SortingController {

    @PostMapping("/sortEventsDirection")
    public String sortingDirection() {

        return "redirect:/main";
    }







}
