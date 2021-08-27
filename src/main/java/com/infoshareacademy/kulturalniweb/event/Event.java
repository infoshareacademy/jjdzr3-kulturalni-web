package com.infoshareacademy.kulturalniweb.event;

public class Event {

    private Integer id;
    private Integer sourceId;
    private Place place;
    private String endDateDate;
    private String endDateTime;
    private String endDateLastTime;
    private String name;
    private Url url;
    private Attachment attachment;
    private String descLong;
    private Integer categoryId;
    private String startDateDate;
    private String startDateTime;
    private String startDateLastTime;
    private Organizer organizer;
    private String active;
    private String descShort;
    private Ticket ticket;

    public Event(Integer id, Integer sourceId, Place place, String endDateDate, String endDateTime, String endDateLastTime, String name, Url url, Attachment attachment, String descLong, Integer categoryId, String startDateDate, String startDateTime, String startDateLastTime, Organizer organizer, String active, String descShort, Ticket ticket) {
        this.id = id;
        this.sourceId = sourceId;
        this.place = place;
        this.endDateDate = endDateDate;
        this.endDateTime = endDateTime;
        this.endDateLastTime = endDateLastTime;
        this.name = name;
        this.url = url;
        this.attachment = attachment;
        this.descLong = descLong;
        this.categoryId = categoryId;
        this.startDateDate = startDateDate;
        this.startDateTime = startDateTime;
        this.startDateLastTime = startDateLastTime;
        this.organizer = organizer;
        this.active = active;
        this.descShort = descShort;
        this.ticket = ticket;
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

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
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

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public String getDescLong() {
        return descLong;
    }

    public void setDescLong(String descLong) {
        this.descLong = descLong;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
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

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getDescShort() {
        return descShort;
    }

    public void setDescShort(String descShort) {
        this.descShort = descShort;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", sourceId=" + sourceId +
                ", place=" + place +
                ", endDateDate='" + endDateDate + '\'' +
                ", endDateTime='" + endDateTime + '\'' +
                ", endDateLastTime='" + endDateLastTime + '\'' +
                ", name='" + name + '\'' +
                ", url=" + url +
                ", attachment=" + attachment +
                ", descLong='" + descLong + '\'' +
                ", categoryId=" + categoryId +
                ", startDateDate='" + startDateDate + '\'' +
                ", startDateTime='" + startDateTime + '\'' +
                ", startDateLastTime='" + startDateLastTime + '\'' +
                ", organizer=" + organizer +
                ", active='" + active + '\'' +
                ", descShort='" + descShort + '\'' +
                ", ticket=" + ticket +
                '}';
    }
}
