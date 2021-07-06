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
        clearList();
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

    public void clearList() {
        eventsDB.clear();
    }

/*    public EventSimple getSingleEventSimple(Integer id) {
        EventSimple eventSimple = new EventSimple();

        for (int i=0; i < eventsDB.size(); i++){
            if(eventsDB.get(i).getId().equals(id)) {
                eventSimple = createSingleEventSimple(eventsDB.get(i));
            }
        }
        return eventSimple;
    }*/




    public List<EventNew> getEventsDB() {
        return eventsDB;
    }

    public void setEventsDB(List<EventNew> eventsDB) {
        this.eventsDB = eventsDB;
    }
}
