package com.infoshareacademy.kulturalniweb.models;

import javax.validation.constraints.Size;

public class NewEventDto {
    private Integer newEventId;
    @Size(min = 3, message = "Wprowadź co najmniej 3 znaki")
    private String newEventName;
    @Size(min = 3, message = "Wprowadź co najmniej 3 znaki")
    private String newEventPlace;
    private String newEventType;
    private String newEventStartDate;
    private String newEventEndDate;
    private String newEventStartTime;
    private String newEventEndTime;
    private String newEventPrice;
    private String newEventUrl;
    private String newEventImage;

    public NewEventDto(Integer newEventId, String newEventName, String newEventPlace, String newEventType, String newEventStartDate, String newEventEndDate, String newEventStartTime, String newEventEndTime, String newEventPrice, String newEventUrl, String newEventImage) {
        this.newEventId = newEventId;
        this.newEventName = newEventName;
        this.newEventPlace = newEventPlace;
        this.newEventType = newEventType;
        this.newEventStartDate = newEventStartDate;
        this.newEventEndDate = newEventEndDate;
        this.newEventStartTime = newEventStartTime;
        this.newEventEndTime = newEventEndTime;
        this.newEventPrice = newEventPrice;
        this.newEventUrl = newEventUrl;
        this.newEventImage = newEventImage;
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

    public String getNewEventType() {
        return newEventType;
    }

    public void setNewEventType(String newEventType) {
        this.newEventType = newEventType;
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
}
