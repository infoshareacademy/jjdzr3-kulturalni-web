package com.infoshareacademy.kulturalniweb.entities.event;

import javax.persistence.*;
import java.util.List;

@Entity
public class Organizer {

    @Id
    @Column(unique = true, nullable = false)
    private Long id;
    private String designation;

    @OneToMany
    @JoinColumn(name = "eventId")
    private List<Event> events;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Organizer{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                '}';
    }
}
