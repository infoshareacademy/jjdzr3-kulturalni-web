package com.infoshareacademy.kulturalniweb.mappers;

import com.infoshareacademy.kulturalniweb.entities.event.*;
import com.infoshareacademy.kulturalniweb.jsonData.EventNew;

public class EventMapper {

    public static EventEntity mapEventNewToEventEntity(EventNew eventNew) {
        EventEntity eventEntity = new EventEntity();
        eventEntity.setSourceId(eventNew.getId());

        PlaceEntity placeEntity = new PlaceEntity();
        placeEntity.setSourceId(eventNew.getPlace().getId());
        placeEntity.setSubname(eventNew.getPlace().getSubname());
        placeEntity.setName(eventNew.getPlace().getSubname());
        eventEntity.setPlaceEntity(placeEntity);

        String[] separatedEndDateAndTime = divideTimeIntoPieces(eventNew.getEndDate());
        eventEntity.setEndDateDate(separatedEndDateAndTime[0]);
        eventEntity.setEndDateTime(separatedEndDateAndTime[1]);
        eventEntity.setEndDateLastTime(separatedEndDateAndTime[2]);

        eventEntity.setName(eventNew.getName());

        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setUrl(eventNew.getUrls().getWww());
        eventEntity.setUrlEntity(urlEntity);

        AttachmentEntity attachmentEntity = new AttachmentEntity();
        attachmentEntity.setFileName(eventNew.getAttachment().getFileName());
        eventEntity.setAttachmentEntity(attachmentEntity);

        eventEntity.setDescLong(eventNew.getDescLong());
        eventEntity.setCategoryId(eventNew.getCategoryId());

        String[] separatedStartDateAndTime = divideTimeIntoPieces(eventNew.getStartDate());
        eventEntity.setStartDateDate(separatedStartDateAndTime[0]);
        eventEntity.setStartDateTime(separatedStartDateAndTime[1]);
        eventEntity.setStartDateLastTime(separatedStartDateAndTime[2]);

        OrganizerEntity organizerEntity = new OrganizerEntity();
        organizerEntity.setSourceid(eventNew.getOrganizer().getId());
        organizerEntity.setDesignation(eventNew.getOrganizer().getName());
        eventEntity.setOrganizerEntity(organizerEntity);

        eventEntity.setActive(eventNew.getActive());
        eventEntity.setDescShort(eventNew.getDescShort());

        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setType(eventNew.getTickets().getType());
        eventEntity.setTicketEntity(ticketEntity);

        return eventEntity;
    }

    public static String[] divideTimeIntoPieces(String input) {
        String[] dateAndTime = input.split("T");
        String[] lastTime = dateAndTime[1].split("-");
        String[] result = {dateAndTime[0], lastTime[0], lastTime[1]};

        return  result;
    }




}
