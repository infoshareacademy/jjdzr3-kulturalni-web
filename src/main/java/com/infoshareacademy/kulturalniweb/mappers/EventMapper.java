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

/*        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setUrl(eventNew.getUrls().getWww());
        eventEntity.setUrlEntity(urlEntity);*/

/*            List<Attachments> attachments = new ArrayList<>();
            Attachments att = new Attachments();
            att.setFileName("plik");
            attachments.add(att);
            event.setAttachments(attachments);*/

/*        List<Attachments> attachments = new ArrayList<>();
        for (int i = 0; i < eventNew.getAttachments().size(); i++) {
            attachments.add(eventNew.getAttachments().get(i));
        }

        for(String singleAttachment : eventNew.getAttachments()) {
            attachments.add(eventNew.getAttachments().get(i));
        }*/


        eventEntity.setDescLong(eventNew.getDescLong());
        eventEntity.setCategoryId(eventNew.getCategoryId());

        String[] separatedStartDateAndTime = divideTimeIntoPieces(eventNew.getStartDate());
        eventEntity.setStartDateDate(separatedStartDateAndTime[0]);
        eventEntity.setStartDateTime(separatedStartDateAndTime[1]);
        eventEntity.setStartDateLastTime(separatedStartDateAndTime[2]);

/*        Organizer organizer = new Organizer();
        organizer.setId(eventNew.getOrganizer().getId());
        organizer.setDesignation(eventNew.getOrganizer().getName());
        event.setOrganizer(organizer);*/

        eventEntity.setActive(eventNew.getActive());
        eventEntity.setDescShort(eventNew.getDescShort());

/*        Tickets tickets = new Tickets();
        tickets.setType(eventNew.getTickets().getType());
        event.setTickets(tickets);*/

        return eventEntity;
    }

    public static String[] divideTimeIntoPieces(String input) {
        String[] dateAndTime = input.split("T");
        String[] lastTime = dateAndTime[1].split("-");
        String[] result = {dateAndTime[0], lastTime[0], lastTime[1]};

        return  result;
    }




}
