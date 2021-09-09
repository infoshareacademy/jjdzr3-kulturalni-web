package com.infoshareacademy.kulturalniweb.mappers;

import com.infoshareacademy.kulturalniweb.dto.AddEventDto;
import com.infoshareacademy.kulturalniweb.dto.EventDto;
import com.infoshareacademy.kulturalniweb.entities.event.*;
import com.infoshareacademy.kulturalniweb.jsonData.EventNew;
import com.infoshareacademy.kulturalniweb.models.EditEventDto;
import com.infoshareacademy.kulturalniweb.services.PictureService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EventMapper {

    private final String GRAPHICS_PATH = "images/img/events/";

    PictureService pictureService;

    public EventMapper(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    public EventEntity mapEventNewToEventEntity(EventNew eventNew) {
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

        try {
            Integer price = Integer.parseInt(eventNew.getTickets().getType());
            ticketEntity.setType(price.toString());
        } catch (Exception e) {
            ticketEntity.setType("Impreza darmowa");
        }

        eventEntity.setTicketEntity(ticketEntity);

        eventEntity.setPicture(pictureService.getPictureFilename());
        eventEntity.setCity("Gdańsk");
        eventEntity.setFavourite(false);

        return eventEntity;
    }

    public static String[] divideTimeIntoPieces(String input) {
        String[] dateAndTime = input.split("T");
        String[] lastTime = dateAndTime[1].split("-");
        String[] result = {dateAndTime[0], lastTime[0], lastTime[1]};

        return  result;
    }

    public EventDto mapEventEntityToEventDto(EventEntity eventEntity) {
        EventDto eventDto = new EventDto();
        eventDto.setId(eventEntity.getId());
        eventDto.setSourceId(eventEntity.getSourceId());
        eventDto.setPlaceId(eventEntity.getPlaceEntity().getSourceId());
        eventDto.setPlaceName(eventEntity.getPlaceEntity().getName());
        eventDto.setEndDateDate(eventEntity.getEndDateDate());
        eventDto.setEndDateTime(eventEntity.getEndDateTime());
        eventDto.setEndDateLastTime(eventEntity.getEndDateLastTime());
        eventDto.setName(eventEntity.getName());
        eventDto.setUrl(eventEntity.getUrlEntity().getUrl());
        eventDto.setAttachment(eventEntity.getAttachmentEntity().getFileName());
        eventDto.setDescLong(eventEntity.getDescLong());
        eventDto.setCategoryId(eventEntity.getCategoryId());
        eventDto.setStartDateDate(eventEntity.getStartDateDate());
        eventDto.setStartDateTime(eventEntity.getStartDateTime());
        eventDto.setStartDateLastTime(eventEntity.getStartDateLastTime());
        eventDto.setOrganizerId(eventEntity.getOrganizerEntity().getId());
        eventDto.setOrganizerName(eventEntity.getOrganizerEntity().getDesignation());
        eventDto.setStatus(eventEntity.getActive());
        eventDto.setDescShort(eventEntity.getDescShort());
        eventDto.setTicket(eventEntity.getTicketEntity().getType());
        eventDto.setPicture(eventEntity.getPicture());
        eventDto.setCity(eventEntity.getCity());
        eventDto.setFavourite(eventEntity.getFavourite());
        return eventDto;
    }

    public EventEntity mapEventDtoToEventEntity(EventDto eventDto) {
        EventEntity eventEntity = new EventEntity();

        eventEntity.setId(eventDto.getId());
        eventEntity.setSourceId(eventDto.getSourceId());

        PlaceEntity placeEntity = new PlaceEntity();
        placeEntity.setSourceId(eventDto.getPlaceId());
        placeEntity.setSubname(eventDto.getPlaceName());
        eventEntity.setPlaceEntity(placeEntity);

        eventEntity.setEndDateDate(eventDto.getEndDateDate());
        eventEntity.setEndDateTime(eventDto.getEndDateTime());
        eventEntity.setEndDateLastTime(eventDto.getEndDateLastTime());
        eventEntity.setName(eventDto.getName());

        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setUrl(eventDto.getUrl());
        eventEntity.setUrlEntity(urlEntity);

        AttachmentEntity attachmentEntity = new AttachmentEntity();
        attachmentEntity.setFileName(eventDto.getAttachment());
        eventEntity.setAttachmentEntity(attachmentEntity);

        eventEntity.setDescLong(eventDto.getDescLong());
        eventEntity.setCategoryId(eventDto.getCategoryId());
        eventEntity.setStartDateDate(eventDto.getStartDateDate());
        eventEntity.setStartDateTime(eventDto.getStartDateTime());
        eventEntity.setStartDateLastTime(eventDto.getStartDateLastTime());

        OrganizerEntity organizerEntity = new OrganizerEntity();
        organizerEntity.setSourceid(eventDto.getOrganizerId());
        organizerEntity.setDesignation(eventDto.getOrganizerName());
        eventEntity.setOrganizerEntity(organizerEntity);

        eventEntity.setActive(eventDto.getStatus());
        eventEntity.setDescShort(eventDto.getDescShort());

        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setType(eventDto.getTicket());
        eventEntity.setTicketEntity(ticketEntity);

        eventEntity.setPicture(eventDto.getPicture());
        eventEntity.setCity(eventDto.getCity());
        eventEntity.setFavourite(eventDto.getFavourite());

        return eventEntity;
    }

    public EditEventDto mapEditEventDtoReceivedToEditEventDtoForTemplate(EditEventDto editEventDto) {
        EditEventDto resultEditEventDto = new EditEventDto();
        EventDto resultEventDto = new EventDto();

        System.out.println(editEventDto.getNewEventName());

        //resultEventDto.setId(editEventDto.getNewEventId());
        //resultEventDto.setName(editEventDto.getNewEventName());
        //resultEventDto.setPlaceName();





        return resultEditEventDto;
    }

    public EventEntity mapAddEventDtoToEventEntity(AddEventDto addEventDto) {
        EventEntity eventEntity = new EventEntity();

        eventEntity.setName(addEventDto.getName());

        PlaceEntity placeEntity = new PlaceEntity();
        placeEntity.setName(addEventDto.getPlaceName());
        eventEntity.setPlaceEntity(placeEntity);

        eventEntity.setCity(addEventDto.getCity());
        eventEntity.setStartDateDate(addEventDto.getStartDateDate());
        eventEntity.setStartDateTime(addEventDto.getStartDateTime() + ":00");
        eventEntity.setStartDateLastTime("00:00");
        eventEntity.setEndDateDate(addEventDto.getEndDateDate());
        eventEntity.setEndDateTime(addEventDto.getEndDateTime() + ":00");
        eventEntity.setEndDateLastTime("00:00");

        String ticket;
        if(addEventDto.getTicketFree()) {
            ticket = "Impreza darmowa";
        } else {
            ticket = addEventDto.getTicket();
        }

        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setType(ticket);
        eventEntity.setTicketEntity(ticketEntity);

        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setUrl(addEventDto.getUrl());
        eventEntity.setUrlEntity(urlEntity);

        eventEntity.setDescLong(addEventDto.getDescLong());
        eventEntity.setPicture(addEventDto.getPicture());
        eventEntity.setFavourite(false);

        AttachmentEntity attachmentEntity = new AttachmentEntity();
        attachmentEntity.setFileName("no file");
        eventEntity.setAttachmentEntity(attachmentEntity);

        OrganizerEntity organizerEntity = new OrganizerEntity();
        organizerEntity.setDesignation("org");
        //organizerEntity.setId(14);
        eventEntity.setOrganizerEntity(organizerEntity);

        eventEntity.setActive("1");
        eventEntity.setCategoryId(addEventDto.getCategoryId());

        return eventEntity;
    }

    public EditEventDto mapEventDtoToEditEventDto(EventDto eventDto) {
        EditEventDto editEventDto = new EditEventDto();

        editEventDto.setId(eventDto.getId());
        editEventDto.setPlaceName(eventDto.getPlaceName());
        editEventDto.setEndDateDate(eventDto.getEndDateDate());
        editEventDto.setEndDateTime(eventDto.getEndDateTime());
        editEventDto.setEndDateLastTime(eventDto.getEndDateLastTime());
        editEventDto.setName(eventDto.getName());
        editEventDto.setUrl(eventDto.getUrl());
        editEventDto.setAttachment(eventDto.getAttachment());
        editEventDto.setDescLong(eventDto.getDescLong());
        editEventDto.setCategoryId(eventDto.getCategoryId());
        editEventDto.setStartDateDate(eventDto.getStartDateDate());
        editEventDto.setStartDateTime(eventDto.getStartDateTime());
        editEventDto.setStartDateLastTime(eventDto.getStartDateLastTime());
        editEventDto.setOrganizerId(eventDto.getOrganizerId());
        editEventDto.setOrganizerName(eventDto.getOrganizerName());
        editEventDto.setStatus(eventDto.getStatus());
        editEventDto.setDescShort(eventDto.getDescShort());
        editEventDto.setTicket(eventDto.getTicket());
        editEventDto.setPicture(eventDto.getPicture());
        editEventDto.setCity(eventDto.getCity());
        editEventDto.setFavourite(eventDto.getFavourite());

        return editEventDto;
    }


    public EventEntity mapEditEventDtoToEventEntity(EditEventDto editEventDto) {
        EventEntity eventEntity = new EventEntity();

        eventEntity.setName(editEventDto.getNewEventName());
        eventEntity.setId(editEventDto.getNewEventId());

        PlaceEntity placeEntity = new PlaceEntity();
        placeEntity.setName(editEventDto.getNewEventPlace());
        eventEntity.setPlaceEntity(placeEntity);

        eventEntity.setCity(editEventDto.getNewEventCity());
        eventEntity.setStartDateDate(editEventDto.getNewEventStartDate());
        eventEntity.setStartDateTime(editEventDto.getNewEventStartTime());//+ ":00"
        eventEntity.setStartDateLastTime("00:00");
        eventEntity.setEndDateDate(editEventDto.getNewEventEndDate());
        eventEntity.setEndDateTime(editEventDto.getNewEventEndTime());//+ ":00"
        eventEntity.setEndDateLastTime("00:00");

        String ticket = "?";

/*        if(editEventDto.getNewEventPriceFree().equals(null)) {
            ticket = "Impreza darmowa";
        } else {
            ticket = editEventDto.getNewEventPrice();
        }*/

        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setType(ticket);
        eventEntity.setTicketEntity(ticketEntity);

        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setUrl(editEventDto.getNewEventUrl());
        eventEntity.setUrlEntity(urlEntity);

        //eventEntity.setDescLong("brak - do zrobienia input");
        eventEntity.setDescLong(editEventDto.getDescLong());
        eventEntity.setPicture(GRAPHICS_PATH + editEventDto.getNewEventImage());
        eventEntity.setFavourite(false);

        AttachmentEntity attachmentEntity = new AttachmentEntity();
        attachmentEntity.setFileName("no file");
        eventEntity.setAttachmentEntity(attachmentEntity);

        OrganizerEntity organizerEntity = new OrganizerEntity();
        organizerEntity.setDesignation("org");
        //organizerEntity.setId(14);
        eventEntity.setOrganizerEntity(organizerEntity);

        eventEntity.setActive("1");
        eventEntity.setCategoryId(editEventDto.getCategoryId());

        return eventEntity;
    }
}
