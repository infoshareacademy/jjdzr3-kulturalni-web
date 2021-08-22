package com.infoshareacademy.kulturalniweb.services;

import com.infoshareacademy.kulturalniweb.models.dto.PaginationDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaginationServiceClass {
    private Integer totalNumberOfEvents;
    private Integer numberOfEventsOnThePage;
    private Integer requestedPageNumber;
    private Integer requestedPageChange;
    private Integer virtualDisplayedPageNumber = 1;
    private Integer totalNumberOfPages;


    public PaginationDto getPaginationDto() {
        PaginationDto paginationDto = new PaginationDto();

        paginationDto.setShoulBeDisplayed(shouldBeDisplayed(totalNumberOfEvents, numberOfEventsOnThePage));
        totalNumberOfPages = calculateTotalNumberOfPages(totalNumberOfEvents, numberOfEventsOnThePage);
        paginationDto.setTotalNumberOfPages(totalNumberOfPages);

        List<Integer> navBarPositions = calculateNavBarMiddleLinks();

        paginationDto.setFirstNavBarNumber(navBarPositions.get(0));
        paginationDto.setSecondNavBarNumber(navBarPositions.get(1));
        paginationDto.setThirdNavBarNumber(navBarPositions.get(2));
        paginationDto.setFourthNavBarNumber(navBarPositions.get(3));
        paginationDto.setFifthNavBarNumber(navBarPositions.get(4));


        return paginationDto;
    }


    private Boolean shouldBeDisplayed(Integer totalNumberOfEvents, Integer numberOfEventsOnThePage) {
        return (totalNumberOfEvents > numberOfEventsOnThePage);
    }

    private Integer calculateTotalNumberOfPages(Integer totalNumberOfEvents, Integer numberOfEventsOnThePage) {
        Integer totalNumberOfPages = (totalNumberOfEvents / numberOfEventsOnThePage);
        if ((totalNumberOfEvents % numberOfEventsOnThePage) > 0) {
            totalNumberOfPages = totalNumberOfPages + 1;
        }
        return totalNumberOfPages;
    }

    private List<Integer> calculateNavBarMiddleLinks() {
        updateVirtualDisplayedPageNumber();

        List<Integer> navBarPositions = new ArrayList<>();

        if ((totalNumberOfPages > 5) && (requestedPageNumber > 5)) {
            navBarPositions.add(virtualDisplayedPageNumber - 4);
            navBarPositions.add(virtualDisplayedPageNumber - 3);
            navBarPositions.add(virtualDisplayedPageNumber - 2);
            navBarPositions.add(virtualDisplayedPageNumber - 1);
            navBarPositions.add(virtualDisplayedPageNumber);
        } else {
            navBarPositions.add(1);
            navBarPositions.add(2);
            navBarPositions.add(3);
            navBarPositions.add(4);
            navBarPositions.add(5);
        }
        return navBarPositions;
    }

    private void updateVirtualDisplayedPageNumber() {
        if (requestedPageChange == -1) {
            virtualDisplayedPageNumber--;
        } else if (requestedPageChange == -2) {
            virtualDisplayedPageNumber++;
        }
    }


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
