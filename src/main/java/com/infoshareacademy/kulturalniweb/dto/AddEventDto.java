package com.infoshareacademy.kulturalniweb.dto;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class AddEventDto {
    @NotNull
    @Size(min = 3, message = "Wprowadź co najmniej 3 znaki")
    private String name;
    @NotNull
    @Size(min = 3, message = "Wprowadź co najmniej 3 znaki")
    private String placeName;
    @NotNull
    @Size(min = 3, message = "Wprowadź co najmniej 3 znaki")
    private String city;
    private String startDateDate;
    private String startDateTime;
    private String endDateDate;
    private String endDateTime;
    @Size(min = 1, message = "Wprowadź co najmniej jedną cyfre")
    private String ticket;
    private Boolean ticketFree;
    private String url;
    @Size(min = 3, max =500,  message = "Wprowadź co najmniej 3 znaki")
    private String descLong;
    private String picture;

    public AddEventDto(String name, String placeName, String city, String startDateDate, String startDateTime, String endDateDate, String endDateTime, String ticket, Boolean ticketFree, String url, String descLong, String picture) {
        this.name = name;
        this.placeName = placeName;
        this.city = city;
        this.startDateDate = startDateDate;
        this.startDateTime = startDateTime;
        this.endDateDate = endDateDate;
        this.endDateTime = endDateTime;
        this.ticket = ticket;
        this.ticketFree = ticketFree;
        this.url = url;
        this.descLong = descLong;
        this.picture = picture;
    }

    public AddEventDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStartDateDate() {
        return startDateDate;
    }

    public void setStartDateDate(String startDateDate) {
        this.startDateDate = startDateDate;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getEndDateDate() {
        return endDateDate;
    }

    public void setEndDateDate(String endDateDate) {
        this.endDateDate = endDateDate;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Boolean getTicketFree() {
        return ticketFree;
    }

    public void setTicketFree(Boolean ticketFree) {
        this.ticketFree = ticketFree;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescLong() {
        return descLong;
    }

    public void setDescLong(String descLong) {
        this.descLong = descLong;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}




