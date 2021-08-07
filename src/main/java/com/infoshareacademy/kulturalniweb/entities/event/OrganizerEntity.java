package com.infoshareacademy.kulturalniweb.entities.event;



import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
public class OrganizerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer sourceid;
    private String designation;

    @OneToOne
    private EventEntity eventEntity;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSourceid() {
        return sourceid;
    }

    public void setSourceid(Integer sourceid) {
        this.sourceid = sourceid;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public EventEntity getEventEntity() {
        return eventEntity;
    }

    public void setEventEntity(EventEntity eventEntity) {
        this.eventEntity = eventEntity;
    }

    @Override
    public String toString() {
        return "OrganizerEntity{" +
                "id=" + id +
                ", sourceid=" + sourceid +
                ", designation='" + designation + '\'' +
                ", eventEntity=" + eventEntity +
                '}';
    }
}
