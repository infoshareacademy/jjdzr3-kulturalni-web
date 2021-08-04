package com.infoshareacademy.kulturalniweb.entities.event;

import javax.persistence.*;
import java.util.List;

@Entity
public class OrganizerEntity {

    @Id
    @Column(unique = true, nullable = false)
    private Integer id;
    private String designation;

    @OneToMany(mappedBy = "organizerEntities")
    private List<EventEntity> eventEntities;

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

    public List<EventEntity> getEventEntities() {
        return eventEntities;
    }

    public void setEventEntities(List<EventEntity> eventEntities) {
        this.eventEntities = eventEntities;
    }

    @Override
    public String toString() {
        return "OrganizerEntity{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", eventEntities=" + eventEntities +
                '}';
    }
}
