package com.infoshareacademy.kulturalniweb.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EditEventDto {

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

    private Integer id;
    private Integer sourceId;
    private Integer placeId;
    private String placeName;
    private String endDateDate;
    private String endDateTime;
    private String endDateLastTime;
    private String name;
    private String url;
    private String attachment;
    private String descLong;
    private String categoryId;
    private String startDateDate;
    private String startDateTime;
    private String startDateLastTime;
    private Integer organizerId;
    private String organizerName;
    private String status;
    private String descShort;
    private String ticket;
    private String picture;
    private String city;
    private Boolean isFavourite;

    public EditEventDto() {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
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

    public String getEndDateLastTime() {
        return endDateLastTime;
    }

    public void setEndDateLastTime(String endDateLastTime) {
        this.endDateLastTime = endDateLastTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getDescLong() {
        return descLong;
    }

    public void setDescLong(String descLong) {
        this.descLong = descLong;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
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

    public String getStartDateLastTime() {
        return startDateLastTime;
    }

    public void setStartDateLastTime(String startDateLastTime) {
        this.startDateLastTime = startDateLastTime;
    }

    public Integer getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Integer organizerId) {
        this.organizerId = organizerId;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescShort() {
        return descShort;
    }

    public void setDescShort(String descShort) {
        this.descShort = descShort;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getFavourite() {
        return isFavourite;
    }

    public void setFavourite(Boolean favourite) {
        isFavourite = favourite;
    }
}
