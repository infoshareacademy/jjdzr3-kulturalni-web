package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.jsonData.EventSimple;
import com.infoshareacademy.kulturalniweb.services.EventSimpleMemoryServiceClass;
import com.infoshareacademy.kulturalniweb.services.RepositoryServiceClass;
import com.infoshareacademy.kulturalniweb.services.SortingServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    EventSimpleMemoryServiceClass eventSimpleMemoryServiceClass;
    RepositoryServiceClass repositoryServiceClass;
    SortingServices sortingServices;

    public MainController(EventSimpleMemoryServiceClass eventSimpleMemoryServiceClass, RepositoryServiceClass repositoryServiceClass, SortingServices sortingServices) {
        this.eventSimpleMemoryServiceClass = eventSimpleMemoryServiceClass;
        this.repositoryServiceClass = repositoryServiceClass;
        this.sortingServices = sortingServices;
    }

    @GetMapping("/home")
    public String displayMainPage(Model model) {

        repositoryServiceClass.readEventsFromGsonToList();
        eventSimpleMemoryServiceClass.clearMemory();
        eventSimpleMemoryServiceClass.prepareSimpleEventsListFromRepository();

        List<EventSimple> closestEventsSimple = sortingServices.createListOfClosestEvents();
        model.addAttribute("firstClosestEventSimple", closestEventsSimple.get(0));
        model.addAttribute("secondClosestEventSimple", closestEventsSimple.get(1));
        model.addAttribute("thirdClosestEventSimple", closestEventsSimple.get(2));

        List<EventSimple> newestEventsSimple = sortingServices.sortByIdDescending();
        model.addAttribute("firstNewestEventSimple", newestEventsSimple.get(0));
        model.addAttribute("secondNewestEventSimple", newestEventsSimple.get(1));
        model.addAttribute("thirdNewestEventSimple", newestEventsSimple.get(2));

        return "index";
    }
    @GetMapping("/")
    public String displayHomePage() {
        return "redirect:home";
    }
}
