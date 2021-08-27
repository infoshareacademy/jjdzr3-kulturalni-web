package com.infoshareacademy.kulturalniweb.dto;

import org.springframework.stereotype.Component;

@Component
public class NewPaginationDto {
    private static Boolean shouldBeDisplayed;
    private static Integer firstNavBarNumber;
    private static Integer secondNavBarNumber;
    private static Integer thirdNavBarNumber;
    private static Integer fourthNavBarNumber;
    private static Integer fifthNavBarNumber;
    private static Integer leftArrowNavBarNumber;
    private static Integer rightArrowNavBarNumber;
    private static boolean shouldFirstNavBarNumberBeDisplayed;
    private static boolean shouldSecondNavBarNumberBeDisplayed;
    private static boolean shouldThirdNavBarNumberBeDisplayed;
    private static boolean shouldFourthNavBarNumberBeDisplayed;
    private static boolean shouldFifthNavBarNumberBeDisplayed;
    private static boolean shouldLeftArrowNavBarNumberBeDisplayed;
    private static boolean shouldRightArrowNavBarNumberBeDisplayed;

    public NewPaginationDto(Boolean shouldBeDisplayed, Integer firstNavBarNumber, Integer secondNavBarNumber, Integer thirdNavBarNumber, Integer fourthNavBarNumber, Integer fifthNavBarNumber, Integer leftArrowNavBarNumber, Integer rightArrowNavBarNumber, boolean shouldFirstNavBarNumberBeDisplayed, boolean shouldSecondNavBarNumberBeDisplayed, boolean shouldThirdNavBarNumberBeDisplayed, boolean shouldFourthNavBarNumberBeDisplayed, boolean shouldFifthNavBarNumberBeDisplayed, boolean shouldLeftArrowNavBarNumberBeDisplayed, boolean shouldRightArrowNavBarNumberBeDisplayed) {
        this.shouldBeDisplayed = shouldBeDisplayed;
        this.firstNavBarNumber = firstNavBarNumber;
        this.secondNavBarNumber = secondNavBarNumber;
        this.thirdNavBarNumber = thirdNavBarNumber;
        this.fourthNavBarNumber = fourthNavBarNumber;
        this.fifthNavBarNumber = fifthNavBarNumber;
        this.leftArrowNavBarNumber = leftArrowNavBarNumber;
        this.rightArrowNavBarNumber = rightArrowNavBarNumber;
        this.shouldFirstNavBarNumberBeDisplayed = shouldFirstNavBarNumberBeDisplayed;
        this.shouldSecondNavBarNumberBeDisplayed = shouldSecondNavBarNumberBeDisplayed;
        this.shouldThirdNavBarNumberBeDisplayed = shouldThirdNavBarNumberBeDisplayed;
        this.shouldFourthNavBarNumberBeDisplayed = shouldFourthNavBarNumberBeDisplayed;
        this.shouldFifthNavBarNumberBeDisplayed = shouldFifthNavBarNumberBeDisplayed;
        this.shouldLeftArrowNavBarNumberBeDisplayed = shouldLeftArrowNavBarNumberBeDisplayed;
        this.shouldRightArrowNavBarNumberBeDisplayed = shouldRightArrowNavBarNumberBeDisplayed;
    }

    public NewPaginationDto() {
    }

    public Boolean getShouldBeDisplayed() {
        return shouldBeDisplayed;
    }

    public void setShouldBeDisplayed(Boolean shouldBeDisplayed) {
        this.shouldBeDisplayed = shouldBeDisplayed;
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

    public Integer getLeftArrowNavBarNumber() {
        return leftArrowNavBarNumber;
    }

    public void setLeftArrowNavBarNumber(Integer leftArrowNavBarNumber) {
        this.leftArrowNavBarNumber = leftArrowNavBarNumber;
    }

    public Integer getRightArrowNavBarNumber() {
        return rightArrowNavBarNumber;
    }

    public void setRightArrowNavBarNumber(Integer rightArrowNavBarNumber) {
        this.rightArrowNavBarNumber = rightArrowNavBarNumber;
    }

    public boolean shouldFirstNavBarNumberBeDisplayed() {
        return shouldFirstNavBarNumberBeDisplayed;
    }

    public void setShouldFirstNavBarNumberBeDisplayed(boolean shouldFirstNavBarNumberBeDisplayed) {
        this.shouldFirstNavBarNumberBeDisplayed = shouldFirstNavBarNumberBeDisplayed;
    }

    public boolean shouldSecondNavBarNumberBeDisplayed() {
        return shouldSecondNavBarNumberBeDisplayed;
    }

    public void setShouldSecondNavBarNumberBeDisplayed(boolean shouldSecondNavBarNumberBeDisplayed) {
        this.shouldSecondNavBarNumberBeDisplayed = shouldSecondNavBarNumberBeDisplayed;
    }

    public boolean shouldThirdNavBarNumberBeDisplayed() {
        return shouldThirdNavBarNumberBeDisplayed;
    }

    public void setShouldThirdNavBarNumberBeDisplayed(boolean shouldThirdNavBarNumberBeDisplayed) {
        this.shouldThirdNavBarNumberBeDisplayed = shouldThirdNavBarNumberBeDisplayed;
    }

    public boolean shouldFourthNavBarNumberBeDisplayed() {
        return shouldFourthNavBarNumberBeDisplayed;
    }

    public void setShouldFourthNavBarNumberBeDisplayed(boolean shouldFourthNavBarNumberBeDisplayed) {
        this.shouldFourthNavBarNumberBeDisplayed = shouldFourthNavBarNumberBeDisplayed;
    }

    public boolean shouldFifthNavBarNumberBeDisplayed() {
        return shouldFifthNavBarNumberBeDisplayed;
    }

    public void setShouldFifthNavBarNumberBeDisplayed(boolean shouldFifthNavBarNumberBeDisplayed) {
        this.shouldFifthNavBarNumberBeDisplayed = shouldFifthNavBarNumberBeDisplayed;
    }

    public boolean sShouldLeftArrowNavBarNumberBeDisplayed() {
        return shouldLeftArrowNavBarNumberBeDisplayed;
    }

    public void setShouldLeftArrowNavBarNumberBeDisplayed(boolean shouldLeftArrowNavBarNumberBeDisplayed) {
        this.shouldLeftArrowNavBarNumberBeDisplayed = shouldLeftArrowNavBarNumberBeDisplayed;
    }

    public boolean shouldRightArrowNavBarNumberBeDisplayed() {
        return shouldRightArrowNavBarNumberBeDisplayed;
    }

    public void setShouldRightArrowNavBarNumberBeDisplayed(boolean shouldRightArrowNavBarNumberBeDisplayed) {
        this.shouldRightArrowNavBarNumberBeDisplayed = shouldRightArrowNavBarNumberBeDisplayed;
    }
}
