package com.infoshareacademy.kulturalniweb.entities.event;

import javax.persistence.*;

@Entity
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TicketEntity{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
