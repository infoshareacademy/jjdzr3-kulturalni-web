package com.infoshareacademy.kulturalniweb.repository;

import com.infoshareacademy.kulturalniweb.dto.EventDto;
import com.infoshareacademy.kulturalniweb.entities.event.*;
import com.infoshareacademy.kulturalniweb.mappers.EventMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
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
        final Query query = entityManager.createQuery("SELECT e FROM EventEntity e ORDER BY e.startDateTime DESC, e.startDateDate DESC", EventEntity.class);
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

    public List<EventEntity> createListOfSortedEventEntities(Map<String, String> sortingParameters) {
        System.out.println("param: " + Integer.parseInt(sortingParameters.get("numberOfEventsOnThePage")));
        System.out.println("date: " + sortingParameters.get("eventSortType"));

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
                        "WHERE e.categoryId " + sortingParameters.get("eventFilterType") + " " +
/*                        "ORDER BY e.startDateDate " + sortingParameters.get("eventSortDirection") +
                        ", e.startDateTime " + sortingParameters.get("eventSortDirection"), EventEntity.class)*/
                        "ORDER BY " + orderDefinition, EventEntity.class)
                .setFirstResult(1)
                .setMaxResults(Integer.parseInt(sortingParameters.get("numberOfEventsOnThePage")));


        List<EventEntity> eventEntities = query.getResultList();

        return eventEntities;
    }
}

// SELECT e FROM EventEntity e WHERE e.categoryId = , e.place.name = , ORDER BY :sortParam :directionParam