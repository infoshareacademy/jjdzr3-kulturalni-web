package com.infoshareacademy.kulturalniweb.repository;

import com.infoshareacademy.kulturalniweb.models.dto.EventDto;
import com.infoshareacademy.kulturalniweb.entities.event.*;
import com.infoshareacademy.kulturalniweb.mappers.EventMapper;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class EventsRepository implements Dao<EventEntity> {

    protected EntityManager entityManager;
    private EventMapper eventMapper;

    public EventsRepository(EntityManager entityManager, EventMapper eventMapper) {
        this.entityManager = entityManager;
        this.eventMapper = eventMapper;
    }

    @Override
    public EventEntity find(Integer id) {
        final Query query = entityManager.createQuery("SELECT e FROM EventEntity e WHERE e.id = :id");
        List<EventEntity> list = query.getResultList();

        return list.get(0);
    }

    @Override
    public Collection<EventEntity> findAll() {
        final Query query = entityManager.createQuery("SELECT e FROM EventEntity e", EventEntity.class);
        return query.getResultList();
    }

    @Override
    public void save(EventEntity eventEntity) {
        entityManager.persist(eventEntity);
        TicketEntity ticketEntity = eventEntity.getTicketEntity();
        entityManager.persist(ticketEntity);
        OrganizerEntity organizerEntity = eventEntity.getOrganizerEntity();
        entityManager.persist(organizerEntity);
        UrlEntity urlEntity = eventEntity.getUrlEntity();
        entityManager.persist(urlEntity);
        AttachmentEntity attachmentEntity = eventEntity.getAttachmentEntity();
        entityManager.persist(attachmentEntity);
        PlaceEntity placeEntity = eventEntity.getPlaceEntity();
        entityManager.persist(placeEntity);
    }

    // Czy można zrobić od razu update całego obiektu czy tez trzeba podac po kolei wszystkie kolumny?
    @Override
    public EventEntity update(EventEntity eventEntity, Integer id) {
        return null;
    }

    @Override
    public void delete(EventEntity eventEntity) {
    }

    public List<EventDto> createListOfClosestEvents() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
/*        String time = localTime.toString();
        String[] timeTable = time.split(".");

        System.out.println("date: " + localDate.toString() + "   time: " + timeTable[0] + "   time: " + time);*/

        final Query query = entityManager.createQuery("SELECT e FROM EventEntity e WHERE e.startDateDate >= :dateNow ORDER BY e.startDateDate DESC, e.startDateTime DESC", EventEntity.class)
                .setParameter("dateNow", localDate.toString());
               // .setParameter("timeNow", timeTable[0]);  AND e.startDateDate >= :dateNow
        List<EventEntity> queryResult = query.getResultList();
        List<EventDto> eventDtos = new ArrayList<>();
        for(int i = 0; i < queryResult.size(); i++) {
            eventDtos.add(eventMapper.mapEventEntityToEventDto(queryResult.get(i)));
        }
        return eventDtos;
    }

    public List<EventDto> createListOfNewestEvents() {
        final Query query = entityManager.createQuery("SELECT e FROM EventEntity e ORDER BY e.id DESC", EventEntity.class);
        List<EventEntity> queryResult = query.getResultList();
        List<EventDto> eventDtos = new ArrayList<>();
        for(int i = 0; i < queryResult.size(); i++) {
            eventDtos.add(eventMapper.mapEventEntityToEventDto(queryResult.get(i)));
        }
        return eventDtos;
    }

    public EventEntity getSingleEvent(Integer id) {
        final Query query = entityManager.createQuery("SELECT e FROM EventEntity e WHERE e.id = :id", EventEntity.class);
        query.setParameter("id", id);
        List<EventEntity> eventEntities = query.getResultList();

        return eventEntities.get(0);
    }

    //@Modifying(flushAutomatically = true)
    public List<EventEntity> createListOfSortedEventEntities(Map<String, String> sortingParameters) {
        String orderDefinition = "";

        if(sortingParameters.get("eventSortType").equals("startDateDate")) {
            orderDefinition = "e.startDateDate " + sortingParameters.get("eventSortDirection") + ", e.startDateTime " + sortingParameters.get("eventSortDirection");
        } else if(sortingParameters.get("eventSortType").equals("city")) {
            orderDefinition = "e.city " + sortingParameters.get("eventSortDirection");
        } else {
            orderDefinition = "e.name " + sortingParameters.get("eventSortDirection");
        }

        Integer requestedPageNumber = Integer.parseInt(sortingParameters.get("requestedPageNumber"));
        Integer numberOfEventsOnThePage = Integer.parseInt(sortingParameters.get("numberOfEventsOnThePage"));
/*        Integer firstResult = (requestedPageNumber * numberOfEventsOnThePage) - (numberOfEventsOnThePage - 1);*/
        Integer firstResult = ((requestedPageNumber -1) * numberOfEventsOnThePage);

/*        final Query query = entityManager
                .createQuery("SELECT e FROM EventEntity e " +
                        "WHERE e.categoryId " + sortingParameters.get("eventFilterType") + " " +
                        "ORDER BY " + orderDefinition, EventEntity.class)
                .setFirstResult(firstResult)
                .setMaxResults(numberOfEventsOnThePage);*/

        final Query query = entityManager
                .createQuery("SELECT e FROM EventEntity e " +
                        "WHERE e.active=1 and e.categoryId " + sortingParameters.get("eventFilterType") + " " +
                        "ORDER BY " + orderDefinition, EventEntity.class)
                .setFirstResult(firstResult)
                .setMaxResults(numberOfEventsOnThePage);

        /*"WHERE e.active=1 " +
                "ORDER BY " + orderDefinition, EventEntity.class)*/
        /*and e.categoryId " + sortingParameters.get("eventFilterType") + " */

        List<EventEntity> eventEntities = query.getResultList();
        System.out.println("create list size = " + eventEntities.size());
        return eventEntities;
    }

    public List<EventEntity> getSizeOfListOfSortedEventEntities(Map<String, String> sortingParameters) {
        String orderDefinition = "";

        if(sortingParameters.get("eventSortType").equals("startDateDate")) {
            orderDefinition = "e.startDateDate " + sortingParameters.get("eventSortDirection") + ", e.startDateTime " + sortingParameters.get("eventSortDirection");
        } else if(sortingParameters.get("eventSortType").equals("city")) {
            orderDefinition = "e.city " + sortingParameters.get("eventSortDirection");
        } else {
            orderDefinition = "e.name " + sortingParameters.get("eventSortDirection");
        }

        final Query query = entityManager
                .createQuery("SELECT e FROM EventEntity e " +
                        "WHERE e.active=1 and e.categoryId " + sortingParameters.get("eventFilterType") + " " +
                        "ORDER BY " + orderDefinition, EventEntity.class);

      /*  and e.categoryId " + sortingParameters.get("eventFilterType") + " */

/*        final Query query = entityManager
                .createQuery("SELECT e FROM EventEntity e " +
                        "WHERE e.categoryId " + sortingParameters.get("eventFilterType") + " " +
                        "ORDER BY " + orderDefinition, EventEntity.class);*/

        List<EventEntity> eventEntities = query.getResultList();
        return eventEntities;
    }


    public List<EventEntity> getFavourites() {
        final Query query = entityManager
                .createQuery("SELECT e FROM EventEntity e WHERE e.isFavourite = true ORDER BY e.startDateDate DESC");

        List<EventEntity> eventEntities = query.getResultList();
        System.out.println("eventRepository.getFavourites().size() = " + eventEntities.size());
        return eventEntities;
    }

    public Integer getSizeOfDB() {
        final Query query = entityManager
                .createQuery("SELECT e FROM EventEntity e WHERE e.id > 0");

        List<EventEntity> result = query.getResultList();

        Integer size = result.size();
        System.out.println("result A: " + size);
        return size;
    }


    public void updateEvent(EventEntity eventEntity) {
        final Query query = entityManager
                .createQuery("UPDATE EventEntity e SET " +
                        "e.name = :name," +
                        "e.endDateDate = :endDateDate," +
                        "e.endDateTime = :endDateTime," +
                        "e.descLong = :descLong," +
                        "e.categoryId = :categoryId," +
                        "e.startDateDate =: startDateDate," +
                        "e.startDateTime =: startDateTime," +
                        "e.descShort = :descShort," +
                        "e.picture = :picture," +
                        "e.city = :city WHERE e.id = :eventId")
                .setParameter("name", eventEntity.getName())
                .setParameter("endDateDate", eventEntity.getEndDateDate())
                .setParameter("endDateTime", eventEntity.getEndDateTime())
                .setParameter("descLong", eventEntity.getDescLong())
                .setParameter("categoryId", eventEntity.getCategoryId())
                .setParameter("startDateDate", eventEntity.getStartDateDate())
                .setParameter("startDateTime", eventEntity.getStartDateTime())
                .setParameter("descShort", eventEntity.getDescShort())
                .setParameter("picture", eventEntity.getPicture())
                .setParameter("city", eventEntity.getCity())
                .setParameter("eventId", eventEntity.getId());

        query.executeUpdate();


/*        final Query queryPlace = entityManager
                .createQuery("UPDATE PlaceEntity p SET p.name = :placeName WHERE EventEntity.id = :eventId")
                .setParameter("placeName", eventEntity.getPlaceEntity().getName())
                .setParameter("eventId", eventEntity.getId());

        queryPlace.executeUpdate();*/
    }


    /*                .createQuery("UPDATE EventEntity e SET " +
                        "e.placeEntity = :placeEntity, " +
                        "e.urlEntity = :urlEntity," +
                        "e.organizerEntity =: organizerEntity," +
                        "e.ticketEntity = :ticketEntity," +
                .setParameter("placeEntity", eventEntity.getPlaceEntity())
                .setParameter("endDateDate", eventEntity.getEndDateDate())
                .setParameter("endDateTime", eventEntity.getEndDateTime())
                .setParameter("endDateLastTime", eventEntity.getEndDateLastTime())
                .setParameter("name", eventEntity.getName())
                .setParameter("urlEntity", eventEntity.getUrlEntity())
                .setParameter("attachmentEntity", eventEntity.getAttachmentEntity())
                .setParameter("descLong", eventEntity.getDescLong())
                .setParameter("categoryId", eventEntity.getCategoryId())
                .setParameter("startDateDate", eventEntity.getStartDateDate())
                .setParameter("startDateTime", eventEntity.getStartDateTime())
                .setParameter("startDateLastTime", eventEntity.getStartDateLastTime())
                .setParameter("organizerEntity", eventEntity.getOrganizerEntity())
                .setParameter("active", eventEntity.getActive())
                .setParameter("descShort", eventEntity.getDescShort())
                .setParameter("ticketEntity", eventEntity.getTicketEntity())
                .setParameter("picture", eventEntity.getPicture())
                .setParameter("city", eventEntity.getCity())
                .setParameter("isFavourite", eventEntity.getFavourite())
                .setParameter("id", eventEntity.getId());*/


    public void updateFavourite(Integer id, Boolean favStatus) {
        final Query query = entityManager
                .createQuery("UPDATE EventEntity e SET e.isFavourite = :newStatus WHERE e.id = :id")
                .setParameter("id", id)
                .setParameter("newStatus", !favStatus);

        int result = query.executeUpdate();
        System.out.println(result);
    }

    public void deleteEvent(Integer id) {

        final Query query = entityManager
                .createQuery("UPDATE EventEntity e SET e.active = 9 WHERE e.id = :id")
                .setParameter("id", id);

        int result = query.executeUpdate();
        System.out.println(result);

    }

    public Integer getMaximumId() {
        final Query query = entityManager
                .createQuery("SELECT MAX(id) FROM EventEntity");

        List<Integer> result = query.getResultList();
        Integer maximumId = result.get(0);

        return maximumId;
    }
}

