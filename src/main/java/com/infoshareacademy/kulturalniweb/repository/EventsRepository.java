package com.infoshareacademy.kulturalniweb.repository;

import com.infoshareacademy.kulturalniweb.entities.event.EventEntity;
import com.infoshareacademy.kulturalniweb.entities.event.PlaceEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
@Transactional
public class EventsRepository implements Dao<EventEntity> {

    protected EntityManager entityManager;

    public EventsRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public EventEntity find(Integer id) {
        return null;
    }

    @Override
    public Collection<EventEntity> findAll() {
        final Query query = entityManager.createQuery("SELECT e FROM EventEntity e", EventEntity.class);
        return query.getResultList();
    }

    @Override
    public void save(EventEntity eventEntity) {

        entityManager.persist(eventEntity);

    }

    @Override
    public EventEntity update(EventEntity eventEntity) {
        return null;
    }

    @Override
    public void delete(EventEntity eventEntity) {

    }
}