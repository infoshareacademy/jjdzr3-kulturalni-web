package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.domainData.EventSimple;
import com.infoshareacademy.kulturalniweb.repository.EventRepositoryInFile;
import com.infoshareacademy.kulturalniweb.repository.ListEventRepository;
import com.infoshareacademy.kulturalniweb.services.AppServiceClass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AllEventsController {
    AppServiceClass appServiceClass;
    ListEventRepository listEventRepository;

    private Integer numberOfEventsOnThePage = 20;
    private String eventFilterType = "all";
    private String eventFilterPlace = "all";
    private String eventSortType = "date";
    private String eventSortDirection = "descending";

    public AllEventsController(AppServiceClass appServiceClass, ListEventRepository listEventRepository) {
        this.appServiceClass = appServiceClass;
        this.listEventRepository = listEventRepository;
    }

    @GetMapping("/alleventsindex")
    public String displayAllEventsFromIndex () {
        System.out.println("AllEvents from index");

        numberOfEventsOnThePage = 20;

        return "redirect:allevents";
    }

    @GetMapping("/allevents")
    public String allEvents (Model model) {
        System.out.println("AllEvents");
        listEventRepository.readEventsFromGsonToList();

        List<EventSimple> listOfEventSimple = appServiceClass.getSimpleEventsList(numberOfEventsOnThePage);
        System.out.println(listOfEventSimple.size());
        model.addAttribute("listOfEventSimple", listOfEventSimple);
        model.addAttribute("numberOfEventsperpage", numberOfEventsOnThePage);
        return "allevents";
    }

    @GetMapping("/eventsPerPage")
    public String changeNumberOfEventsPerPage (@RequestParam("eventsPerPage") Integer eventsPerPage) {
        System.out.println("eventsPerPage = " + eventsPerPage);

        if (eventsPerPage == 20) {
            numberOfEventsOnThePage = 20;
        } else if (eventsPerPage == 40) {
            numberOfEventsOnThePage = 40;
        } else if (eventsPerPage == 60) {
            numberOfEventsOnThePage = 60;
        }

        System.out.println("numberOfEventsOnThePage = " + numberOfEventsOnThePage);

        return "redirect:allevents";
    }






}
