package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.jsonData.EventSimple;
import com.infoshareacademy.kulturalniweb.services.EventSimpleMemoryServiceClass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SingleEventController {
    //ListEventRepository listEventRepository;
    EventSimpleMemoryServiceClass eventSimpleMemoryServiceClass;

    public SingleEventController(EventSimpleMemoryServiceClass eventSimpleMemoryServiceClass) {
        this.eventSimpleMemoryServiceClass = eventSimpleMemoryServiceClass;
    }

    @GetMapping(value = "/singleevent")
    public String singleEvent(@RequestParam("id") Integer id, Model model) {

        EventSimple eventSimple = eventSimpleMemoryServiceClass.getSingleEventSimpleFromEventSimpleMemory(id);
        model.addAttribute("singleEventSimpleModel", eventSimple);
        //System.out.println("   Name: " + eventSimple.getEventSimpleName() + "   ID: " + eventSimple.getEventSimpleId());



        return "singleevent";
    }

    @PostMapping("/toggleFavourite")
    public String toggleFavourite() {
        return "toggleFavourite";
    }


}
