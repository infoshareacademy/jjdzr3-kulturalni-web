package com.infoshareacademy.kulturalniweb.models;

public class PaginationDto {
    private Boolean shouldBeDisplayed;
    private Integer totalNumberOfPages;
    private Integer numberOfFirstEventOnThePage;
    private Integer numberOfLastEventOnThePage;
    private Integer numberOfPageThatIsBeeingDisplayed;
    private Integer firstNavBarNumber;
    private Integer secondNavBarNumber;
    private Integer thirdNavBarNumber;
    private Integer fourthNavBarNumber;
    private Integer fifthNavBarNumber;

    public PaginationDto(Boolean shouldBeDisplayed, Integer totalNumberOfPages, Integer numberOfFirstEventOnThePage, Integer numberOfLastEventOnThePage, Integer numberOfPageThatIsBeeingDisplayed, Integer firstNavBarNumber, Integer secondNavBarNumber, Integer thirdNavBarNumber, Integer fourthNavBarNumber, Integer fifthNavBarNumber) {
        this.shouldBeDisplayed = shouldBeDisplayed;
        this.totalNumberOfPages = totalNumberOfPages;
        this.numberOfFirstEventOnThePage = numberOfFirstEventOnThePage;
        this.numberOfLastEventOnThePage = numberOfLastEventOnThePage;
        this.numberOfPageThatIsBeeingDisplayed = numberOfPageThatIsBeeingDisplayed;
        this.firstNavBarNumber = firstNavBarNumber;
        this.secondNavBarNumber = secondNavBarNumber;
        this.thirdNavBarNumber = thirdNavBarNumber;
        this.fourthNavBarNumber = fourthNavBarNumber;
        this.fifthNavBarNumber = fifthNavBarNumber;
    }

    public PaginationDto() {
    }

    public Integer getTotalNumberOfPages() {
        return totalNumberOfPages;
    }

    public void setTotalNumberOfPages(Integer totalNumberOfPages) {
        this.totalNumberOfPages = totalNumberOfPages;
    }

    public Integer getNumberOfFirstEventOnThePage() {
        return numberOfFirstEventOnThePage;
    }

    public void setNumberOfFirstEventOnThePage(Integer numberOfFirstEventOnThePage) {
        this.numberOfFirstEventOnThePage = numberOfFirstEventOnThePage;
    }

    public Integer getNumberOfLastEventOnThePage() {
        return numberOfLastEventOnThePage;
    }

    public void setNumberOfLastEventOnThePage(Integer numberOfLastEventOnThePage) {
        this.numberOfLastEventOnThePage = numberOfLastEventOnThePage;
    }

    public Boolean getShouldBeDisplayed() {
        return shouldBeDisplayed;
    }

    public void setShoulBeDisplayed(Boolean shouldBeDisplayed) {
        this.shouldBeDisplayed = shouldBeDisplayed;
    }

    public Integer getNumberOfPageThatIsBeeingDisplayed() {
        return numberOfPageThatIsBeeingDisplayed;
    }

    public void setNumberOfPageThatIsBeeingDisplayed(Integer numberOfPageThatIsBeeingDisplayed) {
        this.numberOfPageThatIsBeeingDisplayed = numberOfPageThatIsBeeingDisplayed;
    }

    public Integer getFirstNavBarNumber() {
        return firstNavBarNumber;
    }

    public void setFirstNavBarNumber(Integer firstNavBarNumber) {
        this.firstNavBarNumber = firstNavBarNumber;
    }

    public Integer getSecondNavBarNumber() {
        return secondNavBarNumber;
    }

    public void setSecondNavBarNumber(Integer secondNavBarNumber) {
        this.secondNavBarNumber = secondNavBarNumber;
    }

    public Integer getThirdNavBarNumber() {
        return thirdNavBarNumber;
    }

    public void setThirdNavBarNumber(Integer thirdNavBarNumber) {
        this.thirdNavBarNumber = thirdNavBarNumber;
    }

    public Integer getFourthNavBarNumber() {
        return fourthNavBarNumber;
    }

    public void setFourthNavBarNumber(Integer fourthNavBarNumber) {
        this.fourthNavBarNumber = fourthNavBarNumber;
    }

    public Integer getFifthNavBarNumber() {
        return fifthNavBarNumber;
    }

    public void setFifthNavBarNumber(Integer fifthNavBarNumber) {
        this.fifthNavBarNumber = fifthNavBarNumber;
    }
}
