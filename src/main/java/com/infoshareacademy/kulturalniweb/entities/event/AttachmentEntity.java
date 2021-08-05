package com.infoshareacademy.kulturalniweb.entities.event;

import javax.persistence.*;

@Entity
public class AttachmentEntity {

    @Id
    @Column(unique = true, nullable = false)
    private Long id;
    private String fileName;

/*    @ManyToOne
    private EventEntity eventEntity;*/


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

/*    public EventEntity getEventEntity() {
        return eventEntity;
    }

    public void setEventEntity(EventEntity eventEntity) {
        this.eventEntity = eventEntity;
    }*/
}
