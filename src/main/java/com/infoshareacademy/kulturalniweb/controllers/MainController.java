package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.models.dto.EventDto;
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

    @GetMapping("/home")
    public String displayMainPage(Model model) {

        if(mainService.getSizeOfDB() == 0) {
            System.out.println("Rozmiar bazy = " + mainService.getSizeOfDB());
            System.out.println("Ładuję wydarzenia z pliku do bazy.");
            repositoryServiceClass.readEventsFromGsonToList();
        } else {
            System.out.println("Rozmiar bazy = " + mainService.getSizeOfDB());
        }

        List<EventDto> closestEvents = sortingServices.createListOfClosestEvents();
        model.addAttribute("firstClosestEvent", closestEvents.get(closestEvents.size() - 1));
        model.addAttribute("secondClosestEvent", closestEvents.get(closestEvents.size() - 2));
        model.addAttribute("thirdClosestEvent", closestEvents.get(closestEvents.size() - 3));

        List<EventDto> newestEvents = sortingServices.createListOfNewestEvents();
        model.addAttribute("firstNewestEvent", newestEvents.get(0));
        model.addAttribute("secondNewestEvent", newestEvents.get(1));
        model.addAttribute("thirdNewestEvent", newestEvents.get(2));

        return "index";
    }
    @GetMapping("/")
    public String displayHomePage() {
        return "redirect:home";
    }
}
