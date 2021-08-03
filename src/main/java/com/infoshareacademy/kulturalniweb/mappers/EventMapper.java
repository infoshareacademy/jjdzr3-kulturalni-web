package com.infoshareacademy.kulturalniweb.mappers;

import com.infoshareacademy.kulturalniweb.entities.event.*;
import com.infoshareacademy.kulturalniweb.jsonData.EventNew;

import java.util.ArrayList;
import java.util.List;

public class EventMapper {

    public static Event mapEventNewToEvent(EventNew eventNew) {
        Event event = new Event();
        event.setId(eventNew.getId());

        Place place = new Place();
        place.setId(eventNew.getPlace().getId());
        place.setSubname(eventNew.getPlace().getSubname());
        place.setName(eventNew.getPlace().getSubname());
        event.setPlace(place);

        String[] separatedEndDateAndTime = divideTimeIntoPieces(eventNew.getEndDate());
        event.setEndDateDate(separatedEndDateAndTime[0]);
        event.setEndDateTime(separatedEndDateAndTime[1]);
        event.setEndDateLastTime(separatedEndDateAndTime[2]);

        event.setName(eventNew.getName());

        Urls urls = new Urls();
        urls.setUrl(eventNew.getUrls().getWww());
        event.setUrls(urls);

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


        event.setDescLong(eventNew.getDescLong());
        event.setCategoryId(eventNew.getCategoryId());

        String[] separatedStartDateAndTime = divideTimeIntoPieces(eventNew.getStartDate());
        event.setStartDateDate(separatedStartDateAndTime[0]);
        event.setStartDateTime(separatedStartDateAndTime[1]);
        event.setStartDateLastTime(separatedStartDateAndTime[2]);

        Organizer organizer = new Organizer();
        organizer.setId(eventNew.getOrganizer().getId());
        organizer.setDesignation(eventNew.getOrganizer().getName());
        event.setOrganizer(organizer);

        event.setActive(eventNew.getActive());
        event.setDescShort(eventNew.getDescShort());

        Tickets tickets = new Tickets();
        tickets.setType(eventNew.getTickets().getType());
        event.setTickets(tickets);

        return event;
    }

    public static String[] divideTimeIntoPieces(String input) {
        String[] dateAndTime = input.split("T");
        String[] lastTime = dateAndTime[1].split("-");
        String[] result = {dateAndTime[0], lastTime[0], lastTime[1]};

        return  result;
    }




}
