package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.dto.EventDto;
import com.infoshareacademy.kulturalniweb.jsonData.EventSimple;
import com.infoshareacademy.kulturalniweb.dto.PaginationDto;
import com.infoshareacademy.kulturalniweb.repository.EventSimpleMemory;
import com.infoshareacademy.kulturalniweb.repository.ListEventRepository;
import com.infoshareacademy.kulturalniweb.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AllEventsController {
    AppServiceClass appServiceClass;
    ListEventRepository listEventRepository;
    EventSimpleMemory eventSimpleMemory;
    RepositoryServiceClass repositoryServiceClass;
    EventSimpleMemoryServiceClass eventSimpleMemoryServiceClass;
    SortingServices sortingServices;
    PaginationServiceClass paginationServiceClass;
    EventService eventService;


    Boolean fileNotReadYet = true;
    Integer favId = 0;

    private Integer totalNumberOfEvents = 0;
    private Integer numberOfEventsOnThePage = 20;
    private Integer numberOfPageThatIsBeeingDisplayed = 0;
    private Integer requestedPageNumber = 0;
    private Integer requestedPageChange = 0;
    private List<EventSimple> eventsToDisplay = new ArrayList<>();

    private Map<String, String> sortingParameters = new HashMap<>();


    public AllEventsController(AppServiceClass appServiceClass, ListEventRepository listEventRepository, EventSimpleMemory eventSimpleMemory, RepositoryServiceClass repositoryServiceClass, EventSimpleMemoryServiceClass eventSimpleMemoryServiceClass, SortingServices sortingServices, PaginationServiceClass paginationServiceClass, EventService eventService) {
        this.appServiceClass = appServiceClass;
        this.listEventRepository = listEventRepository;
        this.eventSimpleMemory = eventSimpleMemory;
        this.repositoryServiceClass = repositoryServiceClass;
        this.eventSimpleMemoryServiceClass = eventSimpleMemoryServiceClass;
        this.sortingServices = sortingServices;
        this.paginationServiceClass = paginationServiceClass;
        this.eventService = eventService;
    }

    @GetMapping("/alleventsindex")
    public String displayAllEventsFromIndex () {
                    sortingServices.setEventFilterType("all");
                    sortingServices.setEventFilterPlace("all");
                    sortingServices.setEventSortType("date");
                    sortingServices.setEventSortDirection("descending");
                    sortingServices.setNumberOfEventsOnThePage(15);
        paginationServiceClass.setVirtualDisplayedPageNumber(1);

        sortingParameters.put("eventFilterType", "> 0");
        sortingParameters.put("eventFilterPlace", "all");
        sortingParameters.put("eventSortType", "startDateDate");
        sortingParameters.put("eventSortDirection", "DESC");
        sortingParameters.put("numberOfEventsOnThePage", "15");
        sortingParameters.put("pageOffset", "0");


        numberOfEventsOnThePage = 10;
        totalNumberOfEvents = eventsToDisplay.size();
        numberOfPageThatIsBeeingDisplayed = 1;

        return "redirect:allevents";
    }

    @GetMapping("/allevents")
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

        //model.addAttribute("numberOfEventsPerPage", numberOfEventsOnThePage);
        model.addAttribute("numberOfEventsPerPage", sortingParameters.get("numberOfEventsOnThePage"));
        model.addAttribute("eventFilterType", sortingParameters.get("eventFilterType"));
        //model.addAttribute("eventFilterPlace", sortingServices.getEventFilterPlace());
        model.addAttribute("eventFilterPlace", sortingParameters.get("eventFilterPlace"));
        //model.addAttribute("eventSortType", sortingServices.getEventSortType());
        model.addAttribute("eventSortType", sortingParameters.get("eventSortType"));
        //model.addAttribute("eventSortDirection", sortingServices.getEventSortDirection());
        model.addAttribute("eventSortDirection", sortingParameters.get("eventSortDirection"));

        PaginationDto paginationDto = paginationServiceClass.getPaginationDto();

        model.addAttribute("paginationDto", paginationDto);
        model.addAttribute("numberOfPageThatIsBeeingDisplayed", numberOfPageThatIsBeeingDisplayed);

                List<EventSimple> paginatedEventsToDisplay = selectEventsForEachPage();
        List<EventDto> eventDtos = eventService.createListOfSortedEventEntities(sortingParameters);

        //model.addAttribute("listOfEventSimple", paginatedEventsToDisplay);
        model.addAttribute("listOfEventDto", eventDtos);
        model.addAttribute("favouriteEvent", favId);
 //       log();
        return "allevents";
    }

    @GetMapping("/eventsPerPage")
    public String changeNumberOfEventsPerPage (@RequestParam("eventsPerPage") Integer eventsPerPage) {

        if (eventsPerPage == 10) {
                            //numberOfEventsOnThePage = 10;
                            //sortingServices.setNumberOfEventsOnThePage(10);
            sortingParameters.put("numberOfEventsOnThePage", "10");
            System.out.println("10");
        } else if (eventsPerPage == 30) {
                            //numberOfEventsOnThePage = 30;
                            //sortingServices.setNumberOfEventsOnThePage(30);
            sortingParameters.put("numberOfEventsOnThePage", "30");
            System.out.println("30");
        } else if (eventsPerPage == 50) {
                            //numberOfEventsOnThePage = 50;
                            //sortingServices.setNumberOfEventsOnThePage(50);
            sortingParameters.put("numberOfEventsOnThePage", "50");
            System.out.println("50");
        }

        return "redirect:allevents";
    }

    @GetMapping("/eventFilterType")
    public String changeEventType (@RequestParam("eventFilterType") String eventFilterType) {
        switch (eventFilterType) {
            case "1":
                sortingParameters.put("eventFilterType", "= 1");
                break;
            case "19":
                sortingParameters.put("eventFilterType", "= 19");
                break;
            case "51":
                sortingParameters.put("eventFilterType", "= 51");
                break;
            case "35":
                sortingParameters.put("eventFilterType", "= 35");
                break;
            case "83":
                sortingParameters.put("eventFilterType", "= 83");
                break;
            case "61":
                sortingParameters.put("eventFilterType", "= 61");
                break;
            case "69":
                sortingParameters.put("eventFilterType", "= 69");
                break;
            case "77":
                sortingParameters.put("eventFilterType", "= 77");
                break;
            case "96":
                sortingParameters.put("eventFilterType", "= 96");
                break;
            case "999":
                sortingParameters.put("eventFilterType", "> 0");
                break;
            default:
                sortingParameters.put("eventFilterType", "> 0");
        }
        System.out.println(sortingParameters.get("eventFilterType"));
        return "redirect:allevents";
    }


    @GetMapping("/eventFilterPlace")
    public String changeEventPlace (@RequestParam("eventFilterPlace") String eventFilterPlace) {
                        //sortingServices.setEventFilterPlace(eventFilterPlace);
        sortingParameters.put("eventFilterPlace", eventFilterPlace);
                        System.out.println(sortingParameters.get("eventFilterPlace"));
        return "redirect:allevents";
    }

    @GetMapping("/eventSortType")
    public String changeEventSortType (@RequestParam("eventSortType") String eventSortType) {
                        sortingServices.setEventSortType(eventSortType);
        if (eventSortType.equals("date")) {
                        //sortingServices.setEventSortType("startDateDate");
            sortingParameters.put("eventSortType", "startDateDate");
        } else if (eventSortType.equals("city")) {
                        //sortingServices.setEventSortType("city");
            sortingParameters.put("eventSortType", "city");
        } else {
                        //sortingServices.setEventSortType("name");
            sortingParameters.put("eventSortType", "name");
        }

                        //sortingParameters.put("eventSortType", eventSortType);
        return "redirect:allevents";
    }

    @GetMapping("/eventSortDirection")
    public String changeEventSortDirection (@RequestParam("eventSortDirection") String eventSortDirection) {
                        //sortingServices.setEventSortDirection(eventSortDirection);
                         //sortingParameters.put("eventSortDirection", eventSortDirection);
        if(eventSortDirection.equals("ascending")) {
            sortingParameters.put("eventSortDirection", "ASC");
        } else {
            sortingParameters.put("eventSortDirection", "DESC");
        }
        return "redirect:allevents";
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
        return "redirect:allevents";
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
        return "redirect:allevents";
    }


}
