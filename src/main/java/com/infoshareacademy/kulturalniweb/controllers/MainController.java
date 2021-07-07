package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.domainData.EventSimple;
import com.infoshareacademy.kulturalniweb.repository.EventRepositoryInFile;
import com.infoshareacademy.kulturalniweb.repository.ListEventRepository;
import com.infoshareacademy.kulturalniweb.services.AppServiceClass;
import com.infoshareacademy.kulturalniweb.services.EventSimpleMemoryServiceClass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {
    ListEventRepository listEventRepository;
    AppServiceClass appServiceClass;
    EventSimpleMemoryServiceClass eventSimpleMemoryServiceClass;

    public MainController(ListEventRepository listEventRepository, AppServiceClass appServiceClass, EventSimpleMemoryServiceClass eventSimpleMemoryServiceClass) {
        this.listEventRepository = listEventRepository;
        this.appServiceClass = appServiceClass;
        this.eventSimpleMemoryServiceClass = eventSimpleMemoryServiceClass;
    }

    @GetMapping("/")
    public String displayMainPage(Model model) {

        listEventRepository.readEventsFromGsonToList();
        List<EventSimple> newestEventsSimple = eventSimpleMemoryServiceClass.getListOfEventSimple();
       // System.out.println("newest2= " + newestEventsSimple.size());

        model.addAttribute("firstNewestEventSimple", newestEventsSimple.get(0));
        System.out.println("size=" + newestEventsSimple.get(0).getEventSimpleName());
        model.addAttribute("secondNewestEventSimple", newestEventsSimple.get(1));
        model.addAttribute("thirdNewestEventSimple", newestEventsSimple.get(2));


        return "index";
    }
}
