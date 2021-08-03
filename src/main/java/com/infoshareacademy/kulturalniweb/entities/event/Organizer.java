package com.infoshareacademy.kulturalniweb.entities.event;

import javax.persistence.*;
import java.util.List;

@Entity
public class Organizer {

    @Id
    @Column(unique = true, nullable = false)
    private Integer id;
    private String designation;

    @OneToMany
    @JoinColumn(name = "eventId")
    private List<Event> events;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "Organizer{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", events=" + events +
                '}';
    }
}
