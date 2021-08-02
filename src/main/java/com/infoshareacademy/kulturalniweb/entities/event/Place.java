package com.infoshareacademy.kulturalniweb.entities.event;

import javax.persistence.*;
import java.util.List;

@Entity
public class Place {

    @Id
    @Column(unique = true, nullable = false)
    private Long id;
    private String subname;
    private String name;

    @OneToMany
    @JoinColumn(name = "eventId")
    private List<Event> events;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", subname='" + subname + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
