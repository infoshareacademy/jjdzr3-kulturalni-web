package com.infoshareacademy.kulturalniweb.services;

import com.infoshareacademy.kulturalniweb.repository.EventsRepository;
import org.springframework.stereotype.Controller;

@Controller
public class DeleteEventService {

    EventsRepository eventsRepository;

    public DeleteEventService(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }


    public void deleteEvent(Integer id) {

        eventsRepository.deleteEvent(id);
    }

}
