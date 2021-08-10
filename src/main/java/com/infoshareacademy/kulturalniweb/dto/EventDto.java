package com.infoshareacademy.kulturalniweb.dto.eventDto;

public class EventDto {
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
    private Integer categoryId;
    private String startDateDate;
    private String startDateTime;
    private String startDateLastTime;
    private Integer organizerId;
    private String organizerName;
    private String status;
    private String descShort;
    private String ticket;

    public EventDto(Integer id, Integer sourceId, Integer placeId, String placeName, String endDateDate, String endDateTime, String endDateLastTime, String name, String url, String attachment, String descLong, Integer categoryId, String startDateDate, String startDateTime, String startDateLastTime, Integer organizerId, String organizerName, String status, String descShort, String ticket) {
        this.id = id;
        this.sourceId = sourceId;
        this.placeId = placeId;
        this.placeName = placeName;
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
        this.organizerId = organizerId;
        this.organizerName = organizerName;
        this.status = status;
        this.descShort = descShort;
        this.ticket = ticket;
    }

    public EventDto() {
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

    @Override
    public String toString() {
        return "EventDto{" +
                "id=" + id +
                ", sourceId=" + sourceId +
                ", placeId=" + placeId +
                ", placeName='" + placeName + '\'' +
                ", endDateDate='" + endDateDate + '\'' +
                ", endDateTime='" + endDateTime + '\'' +
                ", endDateLastTime='" + endDateLastTime + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", attachment='" + attachment + '\'' +
                ", descLong='" + descLong + '\'' +
                ", categoryId=" + categoryId +
                ", startDateDate='" + startDateDate + '\'' +
                ", startDateTime='" + startDateTime + '\'' +
                ", startDateLastTime='" + startDateLastTime + '\'' +
                ", organizerId=" + organizerId +
                ", organizerName='" + organizerName + '\'' +
                ", status='" + status + '\'' +
                ", descShort='" + descShort + '\'' +
                ", ticket='" + ticket + '\'' +
                '}';
    }
}