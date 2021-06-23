package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.domainData.EventSimple;
import com.infoshareacademy.kulturalniweb.repository.EventRepositoryInFile;
import com.infoshareacademy.kulturalniweb.repository.ListEventRepository;
import com.infoshareacademy.kulturalniweb.services.AppServiceClass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AllEventsController {
    AppServiceClass appServiceClass;
    ListEventRepository listEventRepository;

    public AllEventsController(AppServiceClass appServiceClass, ListEventRepository listEventRepository) {
        this.appServiceClass = appServiceClass;
        this.listEventRepository = listEventRepository;
    }

    @GetMapping("/allevents")
    public String allEvents (Model model) {
        System.out.println("AllEvents");
        listEventRepository.readEventsFromGsonToList();

        List<EventSimple> listOfEventSimple = appServiceClass.getSimpleEventsList(20);
        System.out.println(listOfEventSimple.size());
        model.addAttribute("listOfEventSimple", listOfEventSimple);
        return "allevents";
    }
}
