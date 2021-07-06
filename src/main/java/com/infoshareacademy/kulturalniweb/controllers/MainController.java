package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.domainData.EventSimple;
import com.infoshareacademy.kulturalniweb.repository.EventRepositoryInFile;
import com.infoshareacademy.kulturalniweb.repository.ListEventRepository;
import com.infoshareacademy.kulturalniweb.services.AppServiceClass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {
    ListEventRepository listEventRepository;
    AppServiceClass appServiceClass;

    public MainController(ListEventRepository listEventRepository, AppServiceClass appServiceClass) {
        this.listEventRepository = listEventRepository;
        this.appServiceClass = appServiceClass;
    }

    @GetMapping("/")
    public String displayMainPage(Model model) {

        listEventRepository.readEventsFromGsonToList();
        List<EventSimple> newestEventsSimple = appServiceClass.getNewestEventSimple();
       // System.out.println("newest2= " + newestEventsSimple.size());

        //model.addAttribute("firstNewestEventSimple", newestEventsSimple.get(0));
        //System.out.println("size=" + newestEventsSimple.get(0).getEventSimpleName());
        //model.addAttribute("secondNewestEventSimple", newestEventsSimple.get(1));
        //model.addAttribute("thirdNewestEventSimple", newestEventsSimple.get(2));


        return "index";
    }
}
