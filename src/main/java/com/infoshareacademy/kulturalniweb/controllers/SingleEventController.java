package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.domainData.EventSimple;
import com.infoshareacademy.kulturalniweb.repository.ListEventRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SingleEventController {
    ListEventRepository listEventRepository;


    public SingleEventController(ListEventRepository listEventRepository) {
        this.listEventRepository = listEventRepository;
    }

    @GetMapping(value = "/singleevent")
    public String singleEvent(@RequestParam("id") Integer id, Model model) {
        System.out.println("singleEvent " + id);
        listEventRepository.readEventsFromGsonToList();

        EventSimple eventSimple = listEventRepository.getSingleEventSimple(id);
        model.addAttribute("singleEventSimpleModel", eventSimple);
        System.out.println(eventSimple.getEventSimpleName());

        return "singleevent";
    }

    @PostMapping("/toggleFavourite")
    public String toggleFavourite() {
        return "toggleFavourite";
    }


}
