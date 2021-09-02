package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.models.dto.EventDto;
import com.infoshareacademy.kulturalniweb.models.dto.NewPaginationDto;
import com.infoshareacademy.kulturalniweb.jsonData.EventSimple;
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
    NewPaginationServiceClass newPaginationServiceClass;
    NewPaginationDto newPaginationDto;


    Boolean fileNotReadYet = true;
    Integer favId = 0;

    private Integer totalNumberOfEvents = 0;
    private Integer numberOfEventsOnThePage = 20;
    private Integer numberOfPageThatIsBeeingDisplayed = 0;
    private Integer requestedPageNumber = 0;
    private Integer requestedPageChange = 0;
    private List<EventSimple> eventsToDisplay = new ArrayList<>();

    private Map<String, String> sortingParameters = new HashMap<>();


    public AllEventsController(AppServiceClass appServiceClass, ListEventRepository listEventRepository, EventSimpleMemory eventSimpleMemory, RepositoryServiceClass repositoryServiceClass, EventSimpleMemoryServiceClass eventSimpleMemoryServiceClass, SortingServices sortingServices, PaginationServiceClass paginationServiceClass, EventService eventService, NewPaginationServiceClass newPaginationServiceClass, NewPaginationDto newPaginationDto) {
        this.appServiceClass = appServiceClass;
        this.listEventRepository = listEventRepository;
        this.eventSimpleMemory = eventSimpleMemory;
        this.repositoryServiceClass = repositoryServiceClass;
        this.eventSimpleMemoryServiceClass = eventSimpleMemoryServiceClass;
        this.sortingServices = sortingServices;
        this.paginationServiceClass = paginationServiceClass;
        this.eventService = eventService;
        this.newPaginationServiceClass = newPaginationServiceClass;
        this.newPaginationDto = newPaginationDto;
    }

    @GetMapping("/allEventsIndex")
    public String displayAllEventsFromIndex () {
                    sortingServices.setEventFilterType("all");
                    sortingServices.setEventFilterPlace("all");
                    sortingServices.setEventSortType("date");
                    sortingServices.setEventSortDirection("descending");
                    sortingServices.setNumberOfEventsOnThePage(15);

        sortingParameters.put("eventFilterType", "> 0");
        sortingParameters.put("eventFilterPlace", "all");
        sortingParameters.put("eventSortType", "startDateDate");
        sortingParameters.put("eventSortDirection", "DESC");
        sortingParameters.put("numberOfEventsOnThePage", "10");
        sortingParameters.put("pageOffset", "1");
        sortingParameters.put("numberOfResultPages", "1");
        sortingParameters.put("totalNumberOfEvents", "0");
        sortingParameters.put("requestedPageNumber", "1");

        newPaginationDto.setShouldBeDisplayed(false);
        newPaginationDto.setLeftArrowNavBarNumber(0);
        newPaginationDto.setFirstNavBarNumber(1);
        newPaginationDto.setSecondNavBarNumber(2);
        newPaginationDto.setThirdNavBarNumber(3);
        newPaginationDto.setFourthNavBarNumber(4);
        newPaginationDto.setFifthNavBarNumber(5);
        newPaginationDto.setRightArrowNavBarNumber(6);
        newPaginationDto.setShouldLeftArrowNavBarNumberBeDisplayed(true);
        newPaginationDto.setShouldFirstNavBarNumberBeDisplayed(true);
        newPaginationDto.setShouldSecondNavBarNumberBeDisplayed(true);
        newPaginationDto.setShouldThirdNavBarNumberBeDisplayed(true);
        newPaginationDto.setShouldFourthNavBarNumberBeDisplayed(true);
        newPaginationDto.setShouldFifthNavBarNumberBeDisplayed(true);
        newPaginationDto.setShouldRightArrowNavBarNumberBeDisplayed(true);



                    numberOfEventsOnThePage = 10;
        totalNumberOfEvents = eventsToDisplay.size();
        sortingParameters.put("totalNumberOfEvents", totalNumberOfEvents.toString());
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

        model.addAttribute("numberOfEventsPerPage", Integer.parseInt(sortingParameters.get("numberOfEventsOnThePage")));
        model.addAttribute("eventFilterType", sortingParameters.get("eventFilterType"));
        model.addAttribute("eventFilterPlace", sortingParameters.get("eventFilterPlace"));
        model.addAttribute("eventSortType", sortingParameters.get("eventSortType"));
        model.addAttribute("eventSortDirection", sortingParameters.get("eventSortDirection"));


        Integer eventDtosSize = eventService.getSizeOfListOfSortedEventEntities(sortingParameters);
        sortingParameters.put("numberOfResultPages", calculateNumberOfResultPages(eventDtosSize, sortingParameters.get("numberOfEventsOnThePage")));
        List<EventDto> eventDtos = eventService.createListOfSortedEventEntities(sortingParameters);

        model.addAttribute("listOfEventDto", eventDtos);
        model.addAttribute("favouriteEvent", favId);

        sortingParameters.put("totalNumberOfEvents", eventDtosSize.toString());
        NewPaginationDto newPaginationDto = newPaginationServiceClass.getNewPaginationDto(sortingParameters);
        model.addAttribute("newPaginationDto", newPaginationDto);
        return "allEvents";
    }



    @GetMapping("/eventsPerPage")
    public String changeNumberOfEventsPerPage (@RequestParam("eventsPerPage") Integer eventsPerPage) {

        if (eventsPerPage == 10) {
            sortingParameters.put("numberOfEventsOnThePage", "10");
        } else if (eventsPerPage == 30) {
            sortingParameters.put("numberOfEventsOnThePage", "30");
        } else if (eventsPerPage == 50) {
            sortingParameters.put("numberOfEventsOnThePage", "50");
        }

        resetSortingparameters();

        return "redirect:allEvents";
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
       // System.out.println(sortingParameters.get("eventFilterType"));

        resetSortingparameters();
        return "redirect:allevents";
    }


    @GetMapping("/eventFilterPlace")
    public String changeEventPlace (@RequestParam("eventFilterPlace") String eventFilterPlace) {
                        //sortingServices.setEventFilterPlace(eventFilterPlace);
        sortingParameters.put("eventFilterPlace", eventFilterPlace);
                        System.out.println(sortingParameters.get("eventFilterPlace"));
        resetSortingparameters();
        return "redirect:allEvents";
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
        return "redirect:allEvents";
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
        return "redirect:allEvents";
    }

    @GetMapping("/alleventsChangePage")
    public String changeNumberOfPageBeeingDisplayed(@RequestParam("page") Integer requestedPageNumber) {
        sortingParameters.put("requestedPageNumber", requestedPageNumber.toString());

        System.out.println("Req Page number: " + requestedPageNumber);
        return "redirect:allEvents";
    }

    private List<EventSimple> selectEventsForEachPage() {
        List<EventSimple> eventSimpleMemoryList = eventSimpleMemoryServiceClass.getListOfEventSimpleFromMemory();
        List<EventSimple> result = new ArrayList<>();

        if (numberOfPageThatIsBeeingDisplayed <paginationServiceClass.getTotalNumberOfPages()) {
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

    @GetMapping(value = "/favselect")
    public String favSelect(@RequestParam("id") Integer id,
                            @RequestParam("favStatus") Boolean favStatus) {
        favId = id;
        System.out.println(favId);
        eventService.updateFavourite(id, favStatus);

        return "redirect:allEvents";
    }

    private String calculateNumberOfResultPages(Integer eventDtosSize, String numberOfEventsOnThePage) {
        Integer pagesNumber = eventDtosSize / Integer.parseInt(numberOfEventsOnThePage);
        Integer anythingLeft = eventDtosSize % Integer.parseInt(numberOfEventsOnThePage);
        System.out.println("size: " + eventDtosSize + " pages nmbr: " + pagesNumber + " anythingLeft: " + anythingLeft);
        if(anythingLeft >0) {
            pagesNumber++;
        }
        return pagesNumber.toString();
    }

    private void resetSortingparameters() {
        sortingParameters.put("pageOffset", "1");
        sortingParameters.put("numberOfResultPages", "1");
        sortingParameters.put("totalNumberOfEvents", "0");
        sortingParameters.put("requestedPageNumber", "1");

        newPaginationDto.setShouldBeDisplayed(false);
        newPaginationDto.setLeftArrowNavBarNumber(0);
        newPaginationDto.setFirstNavBarNumber(1);
        newPaginationDto.setSecondNavBarNumber(2);
        newPaginationDto.setThirdNavBarNumber(3);
        newPaginationDto.setFourthNavBarNumber(4);
        newPaginationDto.setFifthNavBarNumber(5);
        newPaginationDto.setRightArrowNavBarNumber(6);
        newPaginationDto.setShouldLeftArrowNavBarNumberBeDisplayed(false);
        newPaginationDto.setShouldFirstNavBarNumberBeDisplayed(false);
        newPaginationDto.setShouldSecondNavBarNumberBeDisplayed(false);
        newPaginationDto.setShouldThirdNavBarNumberBeDisplayed(false);
        newPaginationDto.setShouldFourthNavBarNumberBeDisplayed(false);
        newPaginationDto.setShouldFifthNavBarNumberBeDisplayed(false);
        newPaginationDto.setShouldRightArrowNavBarNumberBeDisplayed(false);
    }
}
