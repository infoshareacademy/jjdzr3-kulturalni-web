package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.jsonData.EventSimple;
import com.infoshareacademy.kulturalniweb.models.dto.PaginationDto;
import com.infoshareacademy.kulturalniweb.repository.EventSimpleMemory;
import com.infoshareacademy.kulturalniweb.repository.ListEventRepository;
import com.infoshareacademy.kulturalniweb.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AllEventsController {
    AppServiceClass appServiceClass;
    ListEventRepository listEventRepository;
    EventSimpleMemory eventSimpleMemory;
    RepositoryServiceClass repositoryServiceClass;
    EventSimpleMemoryServiceClass eventSimpleMemoryServiceClass;
    SortingServices sortingServices;
    PaginationServiceClass paginationServiceClass;

    Boolean fileNotReadYet = true;
    Integer favId = 0;

    private Integer totalNumberOfEvents = 0;
    private Integer numberOfEventsOnThePage = 20;
    private Integer numberOfPageThatIsBeeingDisplayed = 0;
    private Integer requestedPageNumber = 0;
    private Integer requestedPageChange = 0;
    private List<EventSimple> eventsToDisplay = new ArrayList<>();


    public AllEventsController(AppServiceClass appServiceClass, ListEventRepository listEventRepository, EventSimpleMemory eventSimpleMemory, RepositoryServiceClass repositoryServiceClass, EventSimpleMemoryServiceClass eventSimpleMemoryServiceClass, SortingServices sortingServices, PaginationServiceClass paginationServiceClass) {
        this.appServiceClass = appServiceClass;
        this.listEventRepository = listEventRepository;
        this.eventSimpleMemory = eventSimpleMemory;
        this.repositoryServiceClass = repositoryServiceClass;
        this.eventSimpleMemoryServiceClass = eventSimpleMemoryServiceClass;
        this.sortingServices = sortingServices;
        this.paginationServiceClass = paginationServiceClass;
    }

    @GetMapping("/allEventsIndex")
    public String displayAllEventsFromIndex () {
        sortingServices.setEventFilterType("all");
        sortingServices.setEventFilterPlace("all");
        sortingServices.setEventSortType("date");
        sortingServices.setEventSortDirection("descending");
        paginationServiceClass.setVirtualDisplayedPageNumber(1);

        numberOfEventsOnThePage = 10;
        totalNumberOfEvents = eventsToDisplay.size();
        numberOfPageThatIsBeeingDisplayed = 1;

        return "redirect:allEvents";
    }

    @GetMapping("/allEvents")
    public String allEvents (Model model) {

        // Usunąć ifa - przy naprawieniu listy wydarzeń do bazy
        if (fileNotReadYet) {
            repositoryServiceClass.readEventsFromGsonToList();
            eventSimpleMemoryServiceClass.clearMemory();
            eventSimpleMemoryServiceClass.prepareSimpleEventsListFromRepository();
            fileNotReadYet = false;
        }


        sortingServices.sortBySelectedCriteria();
        sortingServices.filterByPlace();

        totalNumberOfEvents = eventSimpleMemory.getListOfEventSimple().size();

        paginationServiceClass.setNumberOfEventsOnThePage(numberOfEventsOnThePage);
        paginationServiceClass.setTotalNumberOfEvents(totalNumberOfEvents);
        paginationServiceClass.setRequestedPageNumber(numberOfPageThatIsBeeingDisplayed);
        paginationServiceClass.setRequestedPageChange(requestedPageChange);

        model.addAttribute("numberOfEventsPerPage", numberOfEventsOnThePage);
        model.addAttribute("eventFilterPlace", sortingServices.getEventFilterPlace());
        model.addAttribute("eventSortType", sortingServices.getEventSortType());
        model.addAttribute("eventSortDirection", sortingServices.getEventSortDirection());

        PaginationDto paginationDto = paginationServiceClass.getPaginationDto();

        model.addAttribute("paginationDto", paginationDto);
        model.addAttribute("numberOfPageThatIsBeeingDisplayed", numberOfPageThatIsBeeingDisplayed);

        List<EventSimple> paginatedEventsToDisplay = selectEventsForEachPage();

        model.addAttribute("listOfEventSimple", paginatedEventsToDisplay);
        model.addAttribute("favouriteEvent", favId);
 //       log();
        return "allEvents";
    }

    @GetMapping("/eventsPerPage")
    public String changeNumberOfEventsPerPage (@RequestParam("eventsPerPage") Integer eventsPerPage) {

        if (eventsPerPage == 10) {
            numberOfEventsOnThePage = 10;
        } else if (eventsPerPage == 30) {
            numberOfEventsOnThePage = 30;
        } else if (eventsPerPage == 50) {
            numberOfEventsOnThePage = 50;
        }

        return "redirect:allEvents";
    }

    @GetMapping("/eventFilterPlace")
    public String changeEventPlace (@RequestParam("eventFilterPlace") String eventFilterPlace) {
        sortingServices.setEventFilterPlace(eventFilterPlace);
        return "redirect:allEvents";
    }

    @GetMapping("/eventSortType")
    public String changeEventSortType (@RequestParam("eventSortType") String eventSortType) {
        sortingServices.setEventSortType(eventSortType);
        return "redirect:allEvents";
    }

    @GetMapping("/eventSortDirection")
    public String changeEventSortDirection (@RequestParam("eventSortDirection") String eventSortDirection) {
        sortingServices.setEventSortDirection(eventSortDirection);
        return "redirect:allEvents";
    }

    @GetMapping("/alleventsChangePage")
    public String changeNumberOfPageBeeingDisplayed(@RequestParam("page") Integer requestedPageNumber) {


        if (requestedPageNumber == -1) {
            numberOfPageThatIsBeeingDisplayed = numberOfPageThatIsBeeingDisplayed - 1;
            requestedPageChange = -1;
        } else if (requestedPageNumber == -2) {
            numberOfPageThatIsBeeingDisplayed = numberOfPageThatIsBeeingDisplayed + 1;
            requestedPageChange = -2;
        } else {
            numberOfPageThatIsBeeingDisplayed = requestedPageNumber;
            requestedPageChange = 0;
        }
        System.out.println("Req Page number: " + requestedPageNumber + "    newpagenum: " + numberOfPageThatIsBeeingDisplayed);
        return "redirect:allEvents";
    }

    private List<EventSimple> selectEventsForEachPage() {
        List<EventSimple> eventSimpleMemoryList = eventSimpleMemoryServiceClass.getListOfEventSimpleFromMemory();
        List<EventSimple> result = new ArrayList<>();

        if (numberOfPageThatIsBeeingDisplayed < paginationServiceClass.getTotalNumberOfPages()) {
            Integer startIndex = (numberOfPageThatIsBeeingDisplayed - 1) * numberOfEventsOnThePage;
            Integer endIndex = (startIndex + (numberOfEventsOnThePage -1));

            for (int i = startIndex; i <= endIndex; i++) {
                result.add(eventSimpleMemoryList.get(i));
            }
        } else {
            Integer startIndex = (numberOfPageThatIsBeeingDisplayed - 1) * numberOfEventsOnThePage;
            Integer endIndex = eventSimpleMemoryList.size();

            for (int i = startIndex; i < endIndex; i++) {
                result.add(eventSimpleMemoryList.get(i));
            }
        }

        return result;
    }

    public void log() {
        System.out.println("total liczba wydarzeń: " + totalNumberOfEvents + "  Wydarz na strone: " + numberOfEventsOnThePage + "   Numer wysw strony: " + numberOfPageThatIsBeeingDisplayed + "   Liczba stron: " + paginationServiceClass.getTotalNumberOfPages() + "   eventsToDisplay.size()=" + eventsToDisplay.size());
    }

    @GetMapping(value = "/favselect")
    public String favSelect(@RequestParam("id") Integer id) {
        favId = id;
        System.out.println(favId);
        return "redirect:allEvents";
    }


}
