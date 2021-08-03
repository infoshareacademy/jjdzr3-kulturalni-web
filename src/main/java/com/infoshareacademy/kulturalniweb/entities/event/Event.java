package com.infoshareacademy.kulturalniweb.entities.event;

import javax.persistence.*;
import java.util.List;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Integer id;
    private Long sourceId;

    @ManyToOne
    @JoinColumn(name = "placeId")
    private Place place;

    private String endDateDate;
    private String endDateTime;
    private String endDateLastTime;
    private String name;

    @OneToOne
    @JoinColumn(name = "urlsId")
    private Urls urls;

    @OneToMany
    @JoinColumn(name = "attachmentsId")
    private List<Attachments> attachments;
    private String descLong;
    private Integer categoryId;
    private String startDateDate;
    private String startDateTime;
    private String startDateLastTime;

    @ManyToOne
    @JoinColumn(name = "organizerId")
    private Organizer organizer;

    private Boolean active;
    private String descShort;

    @OneToOne
    @JoinColumn(name = "ticketsId")
    private Tickets tickets;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
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

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public List<Attachments> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachments> attachments) {
        this.attachments = attachments;
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

    public Tickets getTickets() {
        return tickets;
    }

    public void setTickets(Tickets tickets) {
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
