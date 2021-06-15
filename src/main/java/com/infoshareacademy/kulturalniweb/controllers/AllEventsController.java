package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.domainData.EventSimple;
import com.infoshareacademy.kulturalniweb.services.AppServiceClass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AllEventsController {
    AppServiceClass appServiceClass;

    public AllEventsController(AppServiceClass appServiceClass) {
        this.appServiceClass = appServiceClass;
    }

    @GetMapping("/allEvents")
    public String allEvents (Model model) {
        System.out.println("AllEvents");

        List<EventSimple> listOfEventSimple = appServiceClass.getSimpleEventsList(20);
        model.addAttribute("listOfEventSimple", listOfEventSimple);
        return "allEvents";
    }
}
