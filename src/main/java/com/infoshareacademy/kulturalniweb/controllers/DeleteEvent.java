package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.services.DeleteEventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteEvent {

    DeleteEventService deleteEventService;

    public DeleteEvent(DeleteEventService deleteEventService) {
        this.deleteEventService = deleteEventService;
    }

    @GetMapping("/deleteEvent")
    public String deleteEvent(@RequestParam("id") Integer id) {

        deleteEventService.deleteEvent(id);

        return "redirect:allevents";
    }
}
