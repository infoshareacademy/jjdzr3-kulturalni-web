package com.infoshareacademy.kulturalniweb.services;

import com.infoshareacademy.kulturalniweb.models.dto.NewPaginationDto;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class NewPaginationServiceClass {

    public NewPaginationDto getNewPaginationDto(Map<String, String> sortingParameters) {
        NewPaginationDto newPaginationDto = new NewPaginationDto();

        newPaginationDto.setShouldBeDisplayed(shouldBeDisplayed(sortingParameters.get("totalNumberOfEvents"), sortingParameters.get("numberOfEventsOnThePage")));

        calculateNewOffset(sortingParameters);
        calculateNavBarLinks(newPaginationDto, sortingParameters);
        setVisibilityOfNavBarLinks(newPaginationDto, sortingParameters);
        setVisibilityOfArrows(newPaginationDto, sortingParameters);

        return newPaginationDto;
    }


    private Boolean shouldBeDisplayed(String totalNumberOfEvents, String numberOfEventsOnThePage) {
        Integer totalNumberOfEventsInteger = Integer.parseInt(totalNumberOfEvents);
        Integer numberOfEventsOnThePageInteger = Integer.parseInt(numberOfEventsOnThePage);
        return (totalNumberOfEventsInteger > numberOfEventsOnThePageInteger);
    }

    public void calculateNewOffset(Map<String, String> sortingParameters) {

        Integer requestedPageNumber = Integer.parseInt(sortingParameters.get("requestedPageNumber"));
        Integer pageOffset = Integer.parseInt(sortingParameters.get("pageOffset"));

        if (requestedPageNumber > (pageOffset * 5)) {
            pageOffset++;
            sortingParameters.put("pageOffset", pageOffset.toString());
        } else if (requestedPageNumber < ((pageOffset * 5) - 4)) {
            pageOffset--;
            sortingParameters.put("pageOffset", pageOffset.toString());
        }
    }

    public void calculateNavBarLinks (NewPaginationDto newPaginationDto, Map<String, String> sortingParameters) {
        Integer pageOffset = Integer.parseInt(sortingParameters.get("pageOffset"));

        newPaginationDto.setLeftArrowNavBarNumber((pageOffset * 5) - 5);
        newPaginationDto.setFirstNavBarNumber((pageOffset * 5) - 4);
        newPaginationDto.setSecondNavBarNumber((pageOffset * 5) - 3);
        newPaginationDto.setThirdNavBarNumber((pageOffset * 5) - 2);
        newPaginationDto.setFourthNavBarNumber((pageOffset * 5) - 1);
        newPaginationDto.setFifthNavBarNumber((pageOffset * 5) - 0);
        newPaginationDto.setRightArrowNavBarNumber((pageOffset * 5) + 1);
    }

    public void setVisibilityOfNavBarLinks(NewPaginationDto newPaginationDto, Map<String, String> sortingParameters) {
        Integer pageOffset = Integer.parseInt(sortingParameters.get("pageOffset"));
        Integer numberOfResultPages = Integer.parseInt(sortingParameters.get("numberOfResultPages"));

        if (((pageOffset * 5) - 4) > numberOfResultPages) {
            newPaginationDto.setShouldFirstNavBarNumberBeDisplayed(false);
        } else {
            newPaginationDto.setShouldFirstNavBarNumberBeDisplayed(true);
        }

        if (((pageOffset * 5) - 3) > numberOfResultPages) {
            newPaginationDto.setShouldSecondNavBarNumberBeDisplayed(false);
        } else {
            newPaginationDto.setShouldSecondNavBarNumberBeDisplayed(true);
        }

        if (((pageOffset * 5) - 2) > numberOfResultPages) {
            newPaginationDto.setShouldThirdNavBarNumberBeDisplayed(false);
        } else {
            newPaginationDto.setShouldThirdNavBarNumberBeDisplayed(true);
        }

        if (((pageOffset * 5) - 1) > numberOfResultPages) {
            newPaginationDto.setShouldFourthNavBarNumberBeDisplayed(false);
        } else {
            newPaginationDto.setShouldFourthNavBarNumberBeDisplayed(true);
        }

        if (((pageOffset * 5) - 0) > numberOfResultPages) {
            newPaginationDto.setShouldFifthNavBarNumberBeDisplayed(false);
        } else {
            newPaginationDto.setShouldFifthNavBarNumberBeDisplayed(true);
        }
    }

    public void setVisibilityOfArrows(NewPaginationDto newPaginationDto, Map<String, String> sortingParameters) {
        Integer pageOffset = Integer.parseInt(sortingParameters.get("pageOffset"));
        Integer numberOfResultPages = Integer.parseInt(sortingParameters.get("numberOfResultPages"));

        if (pageOffset == 1) {
            newPaginationDto.setShouldLeftArrowNavBarNumberBeDisplayed(false);
        } else {
            newPaginationDto.setShouldLeftArrowNavBarNumberBeDisplayed(true);
        }

        if (numberOfResultPages == pageOffset) {
            newPaginationDto.setShouldRightArrowNavBarNumberBeDisplayed(false);
        } else if ((pageOffset * 5) >= numberOfResultPages) {
            newPaginationDto.setShouldRightArrowNavBarNumberBeDisplayed(false);
        } else {
            newPaginationDto.setShouldRightArrowNavBarNumberBeDisplayed(true);
        }
    }
}
