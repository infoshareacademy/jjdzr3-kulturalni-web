package com.infoshareacademy.kulturalniweb.repository;

import com.infoshareacademy.kulturalniweb.entities.event.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Repository
@Transactional
public class EventsRepository implements Dao<EventEntity> {

    protected EntityManager entityManager;

    public EventsRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
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
}