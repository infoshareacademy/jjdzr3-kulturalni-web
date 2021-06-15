package com.infoshareacademy.kulturalniweb.domainData;

import java.util.Objects;

public class EventSimple {
    private Integer eventSimpleId;
    private String eventSimpleName;
    private String eventSimpleDescription;
    private String eventSimpleDate;
    private String eventSimpleStartTime;
    private String eventSimpleEndTime;
    private String eventSimplePlace;
    private Double eventSimpleTicketPrice;
    private String eventSimpleWebPageAddress;
    private String eventSimpleCity;

    public EventSimple(Integer eventSimpleId, String eventSimpleName, String eventSimpleDescription, String eventSimpleDate, String eventSimpleStartTime, String eventSimpleEndTime, String eventSimplePlace, Double eventSimpleTicketPrice, String eventSimpleWebPageAddress) {
        this.eventSimpleId = eventSimpleId;
        this.eventSimpleName = eventSimpleName;
        this.eventSimpleDescription = eventSimpleDescription;
        this.eventSimpleDate = eventSimpleDate;
        this.eventSimpleStartTime = eventSimpleStartTime;
        this.eventSimpleEndTime = eventSimpleEndTime;
        this.eventSimplePlace = eventSimplePlace;
        this.eventSimpleTicketPrice = eventSimpleTicketPrice;
        this.eventSimpleWebPageAddress = eventSimpleWebPageAddress;
        this.eventSimpleCity = "Gdańsk";
    }

    public EventSimple() {
        this.eventSimpleId = 0;
        this.eventSimpleName = "";
        this.eventSimpleDescription = "";
        this.eventSimpleDate = "";
        this.eventSimpleStartTime = "";
        this.eventSimpleEndTime = "";
        this.eventSimplePlace = "";
        this.eventSimpleTicketPrice = 0.0;
        this.eventSimpleWebPageAddress = "";
        this.eventSimpleCity = "Gdańsk";
    }

    public Integer getEventSimpleId() {
        return eventSimpleId;
    }

    public void setEventSimpleId(Integer eventSimpleId) {
        this.eventSimpleId = eventSimpleId;
    }

    public void setEventSimpleCity(String eventSimpleCity) {
        this.eventSimpleCity = eventSimpleCity;
    }

    public String getEventSimpleName() {
        return eventSimpleName;
    }

    public void setEventSimpleName(String eventSimpleName) {
        this.eventSimpleName = eventSimpleName;
    }

    public String getEventSimpleDescription() {
        return eventSimpleDescription;
    }

    public void setEventSimpleDescription(String eventSimpleDescription) {
        this.eventSimpleDescription = eventSimpleDescription;
    }

    public String getEventSimpleDate() {
        return eventSimpleDate;
    }

    public void setEventSimpleDate(String eventSimpleDate) {
        this.eventSimpleDate = eventSimpleDate;
    }

    public String getEventSimpleStartTime() {
        return eventSimpleStartTime;
    }

    public void setEventSimpleStartTime(String eventSimpleStartTime) {
        this.eventSimpleStartTime = eventSimpleStartTime;
    }

    public String getEventSimpleEndTime() {
        return eventSimpleEndTime;
    }

    public void setEventSimpleEndTime(String eventSimpleEndTime) {
        this.eventSimpleEndTime = eventSimpleEndTime;
    }

    public String getEventSimplePlace() {
        return eventSimplePlace;
    }

    public void setEventSimplePlace(String eventSimplePlace) {
        this.eventSimplePlace = eventSimplePlace;
    }

    public Double getEventSimpleTicketPrice() {
        return eventSimpleTicketPrice;
    }

    public void setEventSimpleTicketPrice(Double eventSimpleTicketPrice) {
        this.eventSimpleTicketPrice = eventSimpleTicketPrice;
    }

    public String getEventSimpleWebPageAddress() {
        return eventSimpleWebPageAddress;
    }

    public void setEventSimpleWebPageAddress(String eventSimpleWebPageAddress) {
        this.eventSimpleWebPageAddress = eventSimpleWebPageAddress;
    }

    public String getEventSimpleCity() {
        return eventSimpleCity;
    }

    public void setEventSimpleCity() {
        this.eventSimpleCity = "Gdańsk";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventSimple that = (EventSimple) o;
        return Objects.equals(eventSimpleId, that.eventSimpleId) && Objects.equals(eventSimpleName, that.eventSimpleName) && Objects.equals(eventSimpleDescription, that.eventSimpleDescription) && Objects.equals(eventSimpleDate, that.eventSimpleDate) && Objects.equals(eventSimpleStartTime, that.eventSimpleStartTime) && Objects.equals(eventSimpleEndTime, that.eventSimpleEndTime) && Objects.equals(eventSimplePlace, that.eventSimplePlace) && Objects.equals(eventSimpleTicketPrice, that.eventSimpleTicketPrice) && Objects.equals(eventSimpleWebPageAddress, that.eventSimpleWebPageAddress) && Objects.equals(eventSimpleCity, that.eventSimpleCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventSimpleId, eventSimpleName, eventSimpleDescription, eventSimpleDate, eventSimpleStartTime, eventSimpleEndTime, eventSimplePlace, eventSimpleTicketPrice, eventSimpleWebPageAddress, eventSimpleCity);
    }
}
