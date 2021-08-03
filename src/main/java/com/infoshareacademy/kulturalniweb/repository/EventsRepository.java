package com.infoshareacademy.kulturalniweb.repository;

import com.infoshareacademy.kulturalniweb.entities.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends JpaRepository<Event, Long> {
}
