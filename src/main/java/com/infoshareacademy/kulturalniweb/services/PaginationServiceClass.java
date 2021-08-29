package com.infoshareacademy.kulturalniweb.services;


import org.springframework.stereotype.Service;

@Service
public class PaginationServiceClass {
    private Integer totalNumberOfEvents;
    private Integer numberOfEventsOnThePage;
    private Integer requestedPageNumber;
    private Integer requestedPageChange;
    private Integer virtualDisplayedPageNumber = 1;
    private Integer totalNumberOfPages;


    public Integer getTotalNumberOfEvents() {
        return totalNumberOfEvents;
    }

    public void setTotalNumberOfEvents(Integer totalNumberOfEvents) {
        this.totalNumberOfEvents = totalNumberOfEvents;
    }

    public Integer getNumberOfEventsOnThePage() {
        return numberOfEventsOnThePage;
    }

    public void setNumberOfEventsOnThePage(Integer numberOfEventsOnThePage) {
        this.numberOfEventsOnThePage = numberOfEventsOnThePage;
    }

    public Integer getRequestedPageNumber() {
        return requestedPageNumber;
    }

    public void setRequestedPageNumber(Integer requestedPageNumber) {
        this.requestedPageNumber = requestedPageNumber;
    }

    public Integer getRequestedPageChange() {
        return requestedPageChange;
    }

    public void setRequestedPageChange(Integer requestedPageChange) {
        this.requestedPageChange = requestedPageChange;
    }

    public Integer getVirtualDisplayedPageNumber() {
        return virtualDisplayedPageNumber;
    }

    public void setVirtualDisplayedPageNumber(Integer virtualDisplayedPageNumber) {
        this.virtualDisplayedPageNumber = virtualDisplayedPageNumber;
    }

    public Integer getTotalNumberOfPages() {
        return totalNumberOfPages;
    }

    public void setTotalNumberOfPages(Integer totalNumberOfPages) {
        this.totalNumberOfPages = totalNumberOfPages;
    }
}
