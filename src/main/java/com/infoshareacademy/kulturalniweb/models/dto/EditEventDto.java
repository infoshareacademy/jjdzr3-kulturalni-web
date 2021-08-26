package com.infoshareacademy.kulturalniweb.models.dto;

import com.infoshareacademy.kulturalniweb.dto.EventDto;

public class EditEventDto extends NewEventDto{
    private EventDto eventDto;

    public EventDto getEventDto() {
        return eventDto;
    }

    public void setEventDto(EventDto eventDto) {
        this.eventDto = eventDto;
    }
}
