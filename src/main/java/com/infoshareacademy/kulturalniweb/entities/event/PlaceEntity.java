package com.infoshareacademy.kulturalniweb.entities.event;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PlaceEntity {

    @Id
    //@Column(unique = false, nullable = false)
    private Integer id;

    //private Integer sourceId;
    private String subname;
    private String name;

/*    @OneToMany(mappedBy = "placeEntity")
    private List<EventEntity> eventEntities;*/


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

/*
    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }
*/

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

/*    public List<EventEntity> getEventEntities() {
        return eventEntities;
    }

    public void setEventEntities(List<EventEntity> eventEntities) {
        this.eventEntities = eventEntities;
    }*/

    @Override
    public String toString() {
        return "PlaceEntity{" +
                "id=" + id +
              /*  ", sourceId=" + sourceId +*/
                ", subname='" + subname + '\'' +
                ", name='" + name + '\'' +
            /*    ", eventEntities=" + eventEntities +*/
                '}';
    }
}
