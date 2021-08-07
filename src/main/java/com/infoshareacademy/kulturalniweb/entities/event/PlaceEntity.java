package com.infoshareacademy.kulturalniweb.entities.event;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer sourceId;
    private String subname;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
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
        return "PlaceEntity{" +
                "id=" + id +
                ", sourceId=" + sourceId +
                ", subname='" + subname + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
