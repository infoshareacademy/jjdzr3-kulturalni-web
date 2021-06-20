package com.infoshareacademy.kulturalniweb.repository;

import com.google.gson.Gson;
import com.infoshareacademy.kulturalniweb.domainData.EventNew;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class EventRepositoryInFile {
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
            System.out.println("Baza wydarzeń załadowana: + " + eventsDB.size());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Błąd odczytu pliku .json.");
        }
    }

    public List<EventNew> getEventsDB() {
        return eventsDB;
    }
}
