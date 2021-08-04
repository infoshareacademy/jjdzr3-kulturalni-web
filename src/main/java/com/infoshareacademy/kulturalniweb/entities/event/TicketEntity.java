package com.infoshareacademy.kulturalniweb.entities.event;

import javax.persistence.*;

@Entity
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;

    @OneToOne(mappedBy = "ticketEntity")
    private EventEntity eventEntity;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public EventEntity getEventEntity() {
        return eventEntity;
    }

    public void setEventEntity(EventEntity eventEntity) {
        this.eventEntity = eventEntity;
    }

    @Override
    public String toString() {
        return "TicketEntity{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", eventEntity=" + eventEntity +
                '}';
    }
}
