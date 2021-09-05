package com.infoshareacademy.kulturalniweb.repository;

import com.google.gson.Gson;
import com.infoshareacademy.kulturalniweb.jsonData.EventNew;
import com.infoshareacademy.kulturalniweb.services.EventService;
import com.infoshareacademy.kulturalniweb.services.PictureService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class ListEventRepository {
    private PictureService pictureService;
    private EventsRepository eventsRepository;
    private EntityManager entityManager;
    private EventService eventService;

    private List<EventNew> eventsDB = new ArrayList<>();
    private Path path = Paths.get("src", "main", "resources", "data.json");

    public ListEventRepository(PictureService pictureService, EventsRepository eventsRepository, EntityManager entityManager, EventService eventService) {
        this.pictureService = pictureService;
        this.eventsRepository = eventsRepository;
        this.entityManager = entityManager;
        this.eventService = eventService;
    }

    public void readEventsFromGsonToList() {
        clearList();
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader(String.valueOf(path), StandardCharsets.UTF_8);
            EventNew[] eventList = gson.fromJson(reader, EventNew[].class);

            for (EventNew eventNew : eventList) {
                eventsDB.add(eventNew);

                //eventNew.getPlace().setSubname(pictureService.getPictureFilename());
                eventService.eventEntityFromJsonSave(eventNew);

            }



            addPictures();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Błąd odczytu pliku .json.");
        }


    }






    public void clearList() {
        eventsDB.clear();
    }

    public void addPictures() {
        for (int i = 0; i < eventsDB.size(); i++) {
            eventsDB.get(i).getPlace().setSubname(pictureService.getPictureFilename());
        }
    }




    public List<EventNew> getEventsDB() {
        return eventsDB;
    }

    public void setEventsDB(List<EventNew> eventsDB) {
        this.eventsDB = eventsDB;
    }
}
