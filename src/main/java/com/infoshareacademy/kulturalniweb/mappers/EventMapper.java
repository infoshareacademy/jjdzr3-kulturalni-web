package com.infoshareacademy.kulturalniweb.mappers;

import com.infoshareacademy.kulturalniweb.entities.event.Event;
import com.infoshareacademy.kulturalniweb.jsonData.EventNew;

public class EventMapper {

    public static Event mapEventNewToEvent(EventNew eventNew) {
        Event event = new Event();
        event.setId(eventNew.getId());
        event.getPlace().setId(eventNew.getPlace().getId());
        event.getPlace().setSubname(eventNew.getPlace().getSubname());
        event.getPlace().setName(eventNew.getPlace().getSubname());
        event.setEndDateDate(eventNew.getEndDate());

        String[] separatedEndDateAndTime = divideTimeIntoPieces(eventNew.getEndDate());
        event.setEndDateDate(separatedEndDateAndTime[0]);
        event.setEndDateTime(separatedEndDateAndTime[1]);
        event.setEndDateLastTime(separatedEndDateAndTime[2]);

        event.setName(eventNew.getName());

        event.getUrls().setUrl(eventNew.getUrls().getWww());

        event.getAttachments().get(0).setFileName(eventNew.getAttachments().get(0).getFileName());

        event.setDescLong(eventNew.getDescLong());
        event.setCategoryId(eventNew.getCategoryId());

        String[] separatedStartDateAndTime = divideTimeIntoPieces(eventNew.getStartDate());
        event.setStartDateDate(separatedStartDateAndTime[0]);
        event.setStartDateTime(separatedStartDateAndTime[1]);
        event.setStartDateLastTime(separatedStartDateAndTime[2]);

        event.getOrganizer().setId(eventNew.getOrganizer().getId());
        event.getOrganizer().setDesignation(eventNew.getOrganizer().getName());

        event.setActive(eventNew.getActive());
        event.setDescShort(eventNew.getDescShort());

        event.getTickets().setType(eventNew.getTickets().getType());

        return event;
    }

    public static String[] divideTimeIntoPieces(String input) {
        String[] dateAndTime = input.split("T");
        String[] lastTime = dateAndTime[1].split("-");
        String[] result = {dateAndTime[0], lastTime[0], lastTime[1]};

        return  result;
    }




}
