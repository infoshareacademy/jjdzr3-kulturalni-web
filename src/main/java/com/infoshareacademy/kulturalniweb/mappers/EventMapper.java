package com.infoshareacademy.kulturalniweb.mappers;

import com.infoshareacademy.kulturalniweb.dto.EventDto;
import com.infoshareacademy.kulturalniweb.entities.event.*;
import com.infoshareacademy.kulturalniweb.jsonData.EventNew;
import com.infoshareacademy.kulturalniweb.services.PictureService;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

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
        ticketEntity.setType(eventNew.getTickets().getType());
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
}
