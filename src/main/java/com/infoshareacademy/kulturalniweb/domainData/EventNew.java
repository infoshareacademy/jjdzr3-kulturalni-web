package com.infoshareacademy.kulturalniweb.domainData;


import java.util.List;

public class EventNew {
    private Integer id;
    private Place place;
    private String endDate;
    private String name;
    private Urls urls;
    private List<FileName> attachments;
    private String descLong;
    private Integer categoryId;
    private String startDate;
    private Organizer organizer;
    private String active;
    private String descShort;
    private Tickets tickets;

    public EventNew(Integer id, Place place, String endDate, String name, Urls urls, List<FileName> attachments, String descLong, Integer categoryId, String startDate, Organizer organizer, String active, String descShort, Tickets tickets) {
        this.id = id;
        this.place = place;
        this.endDate = endDate;
        this.name = name;
        this.urls = urls;
        this.attachments = attachments;
        this.descLong = descLong;
        this.categoryId = categoryId;
        this.startDate = startDate;
        this.organizer = organizer;
        this.active = active;
        this.descShort = descShort;
        this.tickets = tickets;
    }

    public EventNew() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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

    public List<FileName> getAttachments() {
        return attachments;
    }
    public FileName getAttachment() {
        if (attachments.isEmpty()) {
            FileName fileName = new FileName("-");
            attachments.add(fileName);
        }
        return attachments.get(0);
    }

    public void setAttachments(List<FileName> attachments) {
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
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

    public Tickets getTickets() {
        return tickets;
    }

    public void setTickets(Tickets tickets) {
        this.tickets = tickets;
    }



}
