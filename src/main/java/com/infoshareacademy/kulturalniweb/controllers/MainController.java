package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.dto.EventDto;
import com.infoshareacademy.kulturalniweb.jsonData.EventSimple;
import com.infoshareacademy.kulturalniweb.services.EventSimpleMemoryServiceClass;
import com.infoshareacademy.kulturalniweb.services.MainService;
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
    MainService mainService;

    public MainController(EventSimpleMemoryServiceClass eventSimpleMemoryServiceClass, RepositoryServiceClass repositoryServiceClass, SortingServices sortingServices, MainService mainService) {
        this.eventSimpleMemoryServiceClass = eventSimpleMemoryServiceClass;
        this.repositoryServiceClass = repositoryServiceClass;
        this.sortingServices = sortingServices;
        this.mainService = mainService;
    }

    @GetMapping("/")
    public String displayMainPage(Model model) {

        if(mainService.getSizeOfDB() == 0) {
            System.out.println("Rozmiar bazy = " + mainService.getSizeOfDB());
            System.out.println("Ładuję wydarzenia z pliku do bazy.");
            repositoryServiceClass.readEventsFromGsonToList();
        } else {
            System.out.println("Rozmiar bazy = " + mainService.getSizeOfDB());
        }

        List<EventDto> closestEvents = sortingServices.createListOfClosestEvents();
        model.addAttribute("firstClosestEvent", closestEvents.get(0));
        model.addAttribute("secondClosestEvent", closestEvents.get(1));
        model.addAttribute("thirdClosestEvent", closestEvents.get(2));

        List<EventDto> newestEvents = sortingServices.createListOfNewestEvents();
        model.addAttribute("firstNewestEvent", newestEvents.get(0));
        model.addAttribute("secondNewestEvent", newestEvents.get(1));
        model.addAttribute("thirdNewestEvent", newestEvents.get(2));

        return "index";
    }
}
