package com.infoshareacademy.kulturalniweb.repository;

import com.google.gson.Gson;
import com.infoshareacademy.kulturalniweb.domainData.EventNew;
import com.infoshareacademy.kulturalniweb.domainData.EventSimple;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class ListEventRepository {
    private List<EventNew> eventsDB = new ArrayList<>();
    private Path path = Paths.get("src", "main", "resources", "data.json");

    public void readEventsFromGsonToList() {
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader(String.valueOf(path));
            EventNew[] eventList = gson.fromJson(reader, EventNew[].class);

            for (EventNew eventNew : eventList) {
                eventsDB.add(eventNew);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Błąd odczytu pliku .json.");
        }
    }


/*    public List<EventSimple> createEventsSimpleList() {
        List<EventSimple> simpleEvents = new ArrayList<>();

        for (Integer i = 0; i < eventsDB.size(); i++) {
            EventSimple eventSimple = new EventSimple();
            eventSimple.setEventSimpleId(eventNew.getId());
            eventSimple.setEventSimpleName(eventNew.getName());
            eventSimple.setEventSimpleDescription(eventNew.getDescLong());

            String[] date = eventNew.getStartDate().split("T");
            eventSimple.setEventSimpleDate(date[0]);

            String time = date[1].substring(0, 8);
            eventSimple.setEventSimpleStartTime(time);
            eventSimple.setEventSimpleEndTime(time);
            eventSimple.setEventSimplePlace(eventNew.getPlace().getName());
            eventSimple.setEventSimpleTicketPrice(0.0);
            eventSimple.setEventSimpleWebPageAddress(eventNew.getUrls().getWww());

            simpleEvents.add(eventSimple);

            EventSimple eventSimple = createSingleEventSimple(eventsDB)
            simpleEvents.add(eventSimple)
        }
        return simpleEvents;
    }*/

    public EventSimple getSingleEventSimple(Integer id) {
        EventSimple eventSimple = new EventSimple();
        System.out.println("ID=" + id + "  " + eventsDB.size());
        for (int i=0; i < eventsDB.size(); i++){

            System.out.println("ID=" + id + "  " + eventsDB.get(i).getId());
            if(eventsDB.get(i).getId().equals(id)) {
                eventSimple = createSingleEventSimple(eventsDB.get(i));

            }
        }
        return eventSimple;
    }

    public EventSimple createSingleEventSimple(EventNew eventNew) {
        EventSimple eventSimple = new EventSimple();
        eventSimple.setEventSimpleId(eventNew.getId());
        eventSimple.setEventSimpleName(eventNew.getName());
        eventSimple.setEventSimpleDescription(eventNew.getDescLong());

        String[] date = eventNew.getStartDate().split("T");
        eventSimple.setEventSimpleDate(date[0]);

        String time = date[1].substring(0, 8);
        eventSimple.setEventSimpleStartTime(time);
        eventSimple.setEventSimpleEndTime(time);
        eventSimple.setEventSimplePlace(eventNew.getPlace().getName());
        eventSimple.setEventSimpleTicketPrice(0.0);
        eventSimple.setEventSimpleWebPageAddress(eventNew.getUrls().getWww());
        return eventSimple;
    }


    public List<EventNew> getEventsDB() {
        System.out.println("eventsDB size = " + eventsDB.size());
        return eventsDB;
    }

    public void setEventsDB(List<EventNew> eventsDB) {
        this.eventsDB = eventsDB;
    }
}
