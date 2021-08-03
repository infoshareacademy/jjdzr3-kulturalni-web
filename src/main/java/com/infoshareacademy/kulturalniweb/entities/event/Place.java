package com.infoshareacademy.kulturalniweb.entities.event;

import javax.persistence.*;
import java.util.List;

@Entity
public class Place {

    @Id
    @Column(unique = true, nullable = false)
    private Integer id;
    private String subname;
    private String name;

    @OneToMany
    @JoinColumn(name = "eventId")
    private List<Event> events;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", subname='" + subname + '\'' +
                ", name='" + name + '\'' +
                ", events=" + events +
                '}';
    }
}
