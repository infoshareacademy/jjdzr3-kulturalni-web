package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.domainData.EventSimple;
import com.infoshareacademy.kulturalniweb.repository.EventRepositoryInFile;
import com.infoshareacademy.kulturalniweb.repository.EventSimpleMemory;
import com.infoshareacademy.kulturalniweb.repository.ListEventRepository;
import com.infoshareacademy.kulturalniweb.services.AppServiceClass;
import com.infoshareacademy.kulturalniweb.services.EventSimpleMemoryServiceClass;
import com.infoshareacademy.kulturalniweb.services.RepositoryServiceClass;
import com.infoshareacademy.kulturalniweb.services.SortingServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AllEventsController {
    AppServiceClass appServiceClass;
    ListEventRepository listEventRepository;
    EventSimpleMemory eventSimpleMemory;
    RepositoryServiceClass repositoryServiceClass;
    EventSimpleMemoryServiceClass eventSimpleMemoryServiceClass;
    SortingServices sortingServices;

    private Integer numberOfEventsOnThePage = 20;
    private List<EventSimple> eventsToDisplay = new ArrayList<>();
/*    private String eventFilterType = "all";
    private String eventFilterPlace = "all";
    private String eventSortType = "date";
    private String eventSortDirection = "descending";*/

   // private List<EventSimple> listOfEventSimple;

    public AllEventsController(AppServiceClass appServiceClass, ListEventRepository listEventRepository, EventSimpleMemory eventSimpleMemory, RepositoryServiceClass repositoryServiceClass, EventSimpleMemoryServiceClass eventSimpleMemoryServiceClass, SortingServices sortingServices) {
        this.appServiceClass = appServiceClass;
        this.listEventRepository = listEventRepository;
        this.eventSimpleMemory = eventSimpleMemory;
        this.repositoryServiceClass = repositoryServiceClass;
        this.eventSimpleMemoryServiceClass = eventSimpleMemoryServiceClass;
        this.sortingServices = sortingServices;
    }

    @GetMapping("/alleventsindex")
    public String displayAllEventsFromIndex () {
/*        numberOfEventsOnThePage = 20;
        eventFilterType = "all";
        eventFilterPlace = "all";
        eventSortType = "date";
        eventSortDirection = "descending";*/


        repositoryServiceClass.readEventsFromGsonToList();
        eventSimpleMemoryServiceClass.clearMemory();
        eventSimpleMemoryServiceClass.prepareSimpleEventsListFromRepository();
        prepareEventsToDisplay();

        return "redirect:allevents";
    }

    @GetMapping("/allevents")
    public String allEvents (Model model) {
        //List<EventSimple> listOfEventSimple = eventSimpleMemoryServiceClass.getPartialListOfEventSimple(numberOfEventsOnThePage);
            //List<EventSimple> listOfEventSimple = eventSimpleMemory.getListOfEventSimple();

        //List<EventSimple> result = listOfEventSimple.stream().filter((x) -> x.getEventSimplePlace().equals(sortingServices.getEventFilterPlace())).collect(Collectors.toList());

            //List<EventSimple> result = listOfEventSimple;

        model.addAttribute("listOfEventSimple", eventsToDisplay);
        model.addAttribute("numberOfEventsPerPage", numberOfEventsOnThePage);
        model.addAttribute("eventFilterPlace", sortingServices.getEventFilterPlace());
        model.addAttribute("eventSortType", sortingServices.getEventSortType());
        model.addAttribute("eventSortDirection", sortingServices.getEventSortDirection());
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


/*    @GetMapping("/eventFilterType")
    public String changeEventType (@RequestParam("eventFilterType") String eventFilterType) {
        sortingServices.setEventFilterType(eventFilterType);
        //sortingServices.filterByType();
        return "redirect:allevents";
    }*/

    @GetMapping("/eventFilterPlace")
    public String changeEventPlace (@RequestParam("eventFilterPlace") String eventFilterPlace) {
        sortingServices.setEventFilterPlace(eventFilterPlace);
        eventsToDisplay = sortingServices.filterByPlace();
        return "redirect:allevents";
    }

    @GetMapping("/eventSortType")
    public String changeEventSortType (@RequestParam("eventSortType") String eventSortType) {
        sortingServices.setEventSortType(eventSortType);
        eventsToDisplay = sortingServices.sortByType();
        return "redirect:allevents";
    }

    @GetMapping("/eventSortDirection")
    public String changeEventSortDirection (@RequestParam("eventSortDirection") String eventSortDirection) {
        sortingServices.setEventSortDirection(eventSortDirection);
        eventsToDisplay = sortingServices.sortByType();
        return "redirect:allevents";
    }

    public void prepareEventsToDisplay() {
        List<EventSimple> listOfEventSimpleMemory = eventSimpleMemoryServiceClass.getListOfEventSimpleMemory();
        for (int i = 0; i < listOfEventSimpleMemory.size(); i++) {
            eventsToDisplay.add(listOfEventSimpleMemory.get(i));
        }
    }



}
