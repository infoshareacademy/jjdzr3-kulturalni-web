package com.infoshareacademy.kulturalniweb.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;

public class NewEventDto {
    private Integer newEventID;
    @Size(min = 2, message = "    Minimum 3 znaki!")
    private String newEventName;
    private String newEventType;
    @Size(min = 2, message = "    Minimum 10 znaków!")
    private String newEventDescription;
    private String newEventDate;
    private String newEventStartTime;
    private String newEventEndTime;
    private String newEventPlace;
    private String newEventPrice;
    private String newEventWebPage;
    private String newEventPicture;


    public NewEventDto(Integer newEventID, String newEventName, String newEventType, String newEventDescription, String newEventDate, String newEventStartTime, String newEventEndTime, String newEventPlace, String newEventPrice, String newEventWebPage, String newEventPicture) {
        this.newEventID = newEventID;
        this.newEventName = newEventName;
        this.newEventType = newEventType;
        this.newEventDescription = newEventDescription;
        this.newEventDate = newEventDate;
        this.newEventStartTime = newEventStartTime;
        this.newEventEndTime = newEventEndTime;
        this.newEventPlace = newEventPlace;
        this.newEventPrice = newEventPrice;
        this.newEventWebPage = newEventWebPage;
        this.newEventPicture = newEventPicture;
    }

    public NewEventDto() {
    }

    public Integer getNewEventID() {
        return newEventID;
    }

    public void setNewEventID(Integer newEventID) {
        this.newEventID = newEventID;
    }

    public String getNewEventName() {
        return newEventName;
    }

    public void setNewEventName(String newEventName) {
        this.newEventName = newEventName;
    }

    public String getNewEventType() {
        return newEventType;
    }

    public void setNewEventType(String newEventType) {
        this.newEventType = newEventType;
    }

    public String getNewEventDescription() {
        return newEventDescription;
    }

    public void setNewEventDescription(String newEventDescription) {
        this.newEventDescription = newEventDescription;
    }

    public String getNewEventDate() {
        return newEventDate;
    }

    public void setNewEventDate(String newEventDate) {
        this.newEventDate = newEventDate;
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

    public String getNewEventPlace() {
        return newEventPlace;
    }

    public void setNewEventPlace(String newEventPlace) {
        this.newEventPlace = newEventPlace;
    }

    public String getNewEventPrice() {
        return newEventPrice;
    }

    public void setNewEventPrice(String newEventPrice) {
        this.newEventPrice = newEventPrice;
    }

    public String getNewEventWebPage() {
        return newEventWebPage;
    }

    public void setNewEventWebPage(String newEventWebPage) {
        this.newEventWebPage = newEventWebPage;
    }

    public String getNewEventPicture() {
        return newEventPicture;
    }

    public void setNewEventPicture(String newEventPicture) {
        this.newEventPicture = newEventPicture;
    }
}
