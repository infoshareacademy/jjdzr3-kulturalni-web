package com.infoshareacademy.kulturalniweb.models.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//TODO : walidacje dla pól
public class NewEventDto {
    private Integer newEventId;
    @NotNull
    @Size(min = 3, message = "Wprowadź co najmniej 3 znaki")
    private String newEventName;
    @NotNull
    @Size(min = 3, message = "Wprowadź co najmniej 3 znaki")
    private String newEventPlace;
    @NotNull
    @Size(min = 3, message = "Wprowadź co najmniej 3 znaki")
    private String newEventCity;
    private String newEventStartDate;
    private String newEventEndDate;
    private String newEventStartTime;
    private String newEventEndTime;
    @Size(min = 1, message = "Wprowadź co najmniej jedną cyfre")
    private String newEventPrice;
    private Boolean newEventPriceFree;
    private String newEventUrl;
    private String newEventImage;
    @Size(min = 3, max =500,  message = "Wprowadź co najmniej 3 znaki")
    private String newEventDescription;

    public NewEventDto(Integer newEventId, String newEventName, String newEventPlace, String newEventCity, String newEventStartDate, String newEventEndDate, String newEventStartTime, String newEventEndTime, String newEventPrice, Boolean newEventPriceFree, String newEventUrl, String newEventImage, String newEventDescription) {
        this.newEventId = newEventId;
        this.newEventName = newEventName;
        this.newEventPlace = newEventPlace;
        this.newEventCity = newEventCity;
        this.newEventStartDate = newEventStartDate;
        this.newEventEndDate = newEventEndDate;
        this.newEventStartTime = newEventStartTime;
        this.newEventEndTime = newEventEndTime;
        this.newEventPrice = newEventPrice;
        this.newEventPriceFree = newEventPriceFree;
        this.newEventUrl = newEventUrl;
        this.newEventImage = newEventImage;
        this.newEventDescription = newEventDescription;
    }

    public NewEventDto() {
    }

    public Integer getNewEventId() {
        return newEventId;
    }

    public void setNewEventId(Integer newEventId) {
        this.newEventId = newEventId;
    }

    public String getNewEventName() {
        return newEventName;
    }

    public void setNewEventName(String newEventName) {
        this.newEventName = newEventName;
    }

    public String getNewEventPlace() {
        return newEventPlace;
    }

    public void setNewEventPlace(String newEventPlace) {
        this.newEventPlace = newEventPlace;
    }

    public String getNewEventCity() {
        return newEventCity;
    }

    public void setNewEventCity(String newEventCity) {
        this.newEventCity = newEventCity;
    }

    public String getNewEventStartDate() {
        return newEventStartDate;
    }

    public void setNewEventStartDate(String newEventStartDate) {
        this.newEventStartDate = newEventStartDate;
    }

    public String getNewEventEndDate() {
        return newEventEndDate;
    }

    public void setNewEventEndDate(String newEventEndDate) {
        this.newEventEndDate = newEventEndDate;
    }

    public String getNewEventStartTime() {
        return newEventStartTime;
    }

    public void setNewEventStartTime(String newEventStartTime) {
        this.newEventStartTime = newEventStartTime;
    }

    public String getNewEventEndTime() {
        return newEventEndTime;
    }

    public void setNewEventEndTime(String newEventEndTime) {
        this.newEventEndTime = newEventEndTime;
    }

    public String getNewEventPrice() {
        return newEventPrice;
    }

    public void setNewEventPrice(String newEventPrice) {
        this.newEventPrice = newEventPrice;
    }

    public Boolean getNewEventPriceFree() {
        return newEventPriceFree;
    }

    public void setNewEventPriceFree(Boolean newEventPriceFree) {
        this.newEventPriceFree = newEventPriceFree;
    }

    public String getNewEventUrl() {
        return newEventUrl;
    }

    public void setNewEventUrl(String newEventUrl) {
        this.newEventUrl = newEventUrl;
    }

    public String getNewEventImage() {
        return newEventImage;
    }

    public void setNewEventImage(String newEventImage) {
        this.newEventImage = newEventImage;
    }

    public String getNewEventDescription() {
        return newEventDescription;
    }

    public void setNewEventDescription(String newEventDescription) {
        this.newEventDescription = newEventDescription;
    }


}
