package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.domainData.EventSimple;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AllEventsController {

    @GetMapping("/allEvents")
    public String allEvents (Model model) {
        System.out.println("AllEvents");

        List<EventSimple> eventSimpleList = appServiceClass.getSimpleEventsList(20);
        model.addAttribute("collectionOfEventSimple", eventSimpleList);


        return "allEvents";
    }
}
