package com.infoshareacademy.kulturalniweb.repository;

import com.infoshareacademy.kulturalniweb.models.dto.EventDto;
import com.infoshareacademy.kulturalniweb.entities.event.EventEntity;
import com.infoshareacademy.kulturalniweb.mappers.EventMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.*;

public class EventsRepositoryTest {

    @Autowired
    EventsRepository eventsRepository;
    @Autowired
    EventMapper eventMapper;

    @Test
    public void testIfReturnEventWithGivenId() {
        // given, when
        EventEntity eventEntity = eventsRepository.getSingleEvent(6451);
        EventDto eventDto = eventMapper.mapEventEntityToEventDto(eventEntity);
        // then
        assertEquals(6451, eventDto);

    }
}
