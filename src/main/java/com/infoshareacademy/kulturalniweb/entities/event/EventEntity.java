package com.infoshareacademy.kulturalniweb.entities.event;

import javax.persistence.*;

@Entity
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer sourceId;

/*    @ManyToOne*/
    @OneToOne
    @JoinColumn(name = "placeEntityId")
    private PlaceEntity placeEntity;

    private String endDateDate;
    private String endDateTime;
    private String endDateLastTime;
    private String name;

    @OneToOne
    @JoinColumn(name = "urlEntityId")
    private UrlEntity urlEntity;

    @OneToOne
    @JoinColumn(name = "attachmentEntityId")
    private AttachmentEntity attachmentEntity;

    @Column(length = 50000)
    private String descLong;
    private Integer categoryId;
    private String startDateDate;
    private String startDateTime;
    private String startDateLastTime;

    /*@ManyToOne(cascade = CascadeType.ALL)*/
    @OneToOne
    @JoinColumn(name = "organizerEntityId")
    private OrganizerEntity organizerEntity;

    private String active;
    private String descShort;

    @OneToOne/*(cascade = CascadeType.ALL)*/
    @JoinColumn(name = "ticketEntityId")
    private TicketEntity ticketEntity;

    private String picture;
    private String city;
    private Boolean isFavourite;


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

    public PlaceEntity getPlaceEntity() {
        return placeEntity;
    }

    public void setPlaceEntity(PlaceEntity placeEntity) {
        this.placeEntity = placeEntity;
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

    public UrlEntity getUrlEntity() {
        return urlEntity;
    }

    public void setUrlEntity(UrlEntity urlEntity) {
        this.urlEntity = urlEntity;
    }

    public AttachmentEntity getAttachmentEntity() {
        return attachmentEntity;
    }

    public void setAttachmentEntity(AttachmentEntity attachmentEntity) {
        this.attachmentEntity = attachmentEntity;
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

    public OrganizerEntity getOrganizerEntity() {
        return organizerEntity;
    }

    public void setOrganizerEntity(OrganizerEntity organizerEntity) {
        this.organizerEntity = organizerEntity;
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

    public TicketEntity getTicketEntity() {
        return ticketEntity;
    }

    public void setTicketEntity(TicketEntity ticketEntity) {
        this.ticketEntity = ticketEntity;
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
