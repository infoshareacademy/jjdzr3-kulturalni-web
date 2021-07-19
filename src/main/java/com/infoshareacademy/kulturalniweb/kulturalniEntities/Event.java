package com.infoshareacademy.kulturalniweb.kulturalniEntities;

import javax.persistence.*;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Long id;
    private Long sourceId;
    private Long place;
    private String endDateDate;
    private String endDateTime;
    private String endDateLastTime;
    private String name;
    private Long urls;
    private Long attachments;
    private String descLong;
    private Long categoryId;
    private String startDateDate;
    private String startDateTime;
    private String startDateLastTime;
    private Long organizer;
    private Boolean active;
    private String descShort;
    private Integer tickets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getPlace() {
        return place;
    }

    public void setPlace(Long place) {
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

    public Long getUrls() {
        return urls;
    }

    public void setUrls(Long urls) {
        this.urls = urls;
    }

    public Long getAttachments() {
        return attachments;
    }

    public void setAttachments(Long attachments) {
        this.attachments = attachments;
    }

    public String getDescLong() {
        return descLong;
    }

    public void setDescLong(String descLong) {
        this.descLong = descLong;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
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

    public Long getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Long organizer) {
        this.organizer = organizer;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescShort() {
        return descShort;
    }

    public void setDescShort(String descShort) {
        this.descShort = descShort;
    }

    public Integer getTickets() {
        return tickets;
    }

    public void setTickets(Integer tickets) {
        this.tickets = tickets;
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
                ", urls=" + urls +
                ", attachments=" + attachments +
                ", descLong='" + descLong + '\'' +
                ", categoryId=" + categoryId +
                ", startDateDate='" + startDateDate + '\'' +
                ", startDateTime='" + startDateTime + '\'' +
                ", startDateLastTime='" + startDateLastTime + '\'' +
                ", organizer=" + organizer +
                ", active=" + active +
                ", descShort='" + descShort + '\'' +
                ", tickets=" + tickets +
                '}';
    }
}
