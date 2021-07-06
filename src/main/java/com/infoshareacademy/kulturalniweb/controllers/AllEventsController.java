package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.domainData.EventSimple;
import com.infoshareacademy.kulturalniweb.repository.EventRepositoryInFile;
import com.infoshareacademy.kulturalniweb.repository.EventSimpleMemory;
import com.infoshareacademy.kulturalniweb.repository.ListEventRepository;
import com.infoshareacademy.kulturalniweb.services.AppServiceClass;
import com.infoshareacademy.kulturalniweb.services.EventSimpleMemoryServiceClass;
import com.infoshareacademy.kulturalniweb.services.RepositoryServiceClass;
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
    EventSimpleMemory eventSimpleMemory;
    RepositoryServiceClass repositoryServiceClass;
    EventSimpleMemoryServiceClass eventSimpleMemoryServiceClass;

    private Integer numberOfEventsOnThePage = 20;
    private String eventFilterType = "all";
    private String eventFilterPlace = "all";
    private String eventSortType = "date";
    private String eventSortDirection = "descending";

    private List<EventSimple> listOfEventSimple;

    public AllEventsController(AppServiceClass appServiceClass, ListEventRepository listEventRepository, EventSimpleMemory eventSimpleMemory, RepositoryServiceClass repositoryServiceClass, EventSimpleMemoryServiceClass eventSimpleMemoryServiceClass) {
        this.appServiceClass = appServiceClass;
        this.listEventRepository = listEventRepository;
        this.eventSimpleMemory = eventSimpleMemory;
        this.repositoryServiceClass = repositoryServiceClass;
        this.eventSimpleMemoryServiceClass = eventSimpleMemoryServiceClass;
    }

    @GetMapping("/alleventsindex")
    public String displayAllEventsFromIndex () {
        numberOfEventsOnThePage = 20;
        eventFilterType = "all";
        eventFilterPlace = "all";
        eventSortType = "date";
        eventSortDirection = "descending";


        repositoryServiceClass.readEventsFromGsonToList();
        //listEventRepository.readEventsFromGsonToList();
        //listOfEventSimple = appServiceClass.getSimpleEventsList();
        eventSimpleMemoryServiceClass.clearMemory();
        eventSimpleMemoryServiceClass.prepareSimpleEventsListFromRepository();



        return "redirect:allevents";
    }

    @GetMapping("/allevents")
    public String allEvents (Model model) {
/*        listEventRepository.readEventsFromGsonToList();
        List<EventSimple> listOfEventSimple = appServiceClass.getSimpleEventsList(numberOfEventsOnThePage);
        System.out.println(listOfEventSimple.size());
        model.addAttribute("listOfEventSimple", listOfEventSimple);
        model.addAttribute("numberOfEventsperpage", numberOfEventsOnThePage);*/

        List<EventSimple> listOfEventSimple = eventSimpleMemoryServiceClass.getPartialListOfEventSimple(numberOfEventsOnThePage);
        System.out.println(listOfEventSimple.size());
        model.addAttribute("listOfEventSimple", listOfEventSimple);
        model.addAttribute("numberOfEventsperpage", numberOfEventsOnThePage);


        return "allevents";
    }

    @GetMapping("/eventsPerPage")
    public String changeNumberOfEventsPerPage (@RequestParam("eventsPerPage") Integer eventsPerPage) {

        if (eventsPerPage == 20) {
            numberOfEventsOnThePage = 20;
        } else if (eventsPerPage == 40) {
            numberOfEventsOnThePage = 40;
        } else if (eventsPerPage == 60) {
            numberOfEventsOnThePage = 60;
        }

        return "redirect:allevents";
    }


    @GetMapping("/eventFilterType")
    public String changeEventType (@RequestParam("eventFilterType") String eventFilterType) {



        return "redirect:allevents";
    }




}
