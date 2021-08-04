package com.infoshareacademy.kulturalniweb.entities.event;

import javax.persistence.*;

@Entity
public class UrlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;
    private String  url;

/*    @OneToOne(mappedBy = "urlEntity")
    private EventEntity eventEntity;*/


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

/*    public EventEntity getEventEntity() {
        return eventEntity;
    }

    public void setEventEntity(EventEntity eventEntity) {
        this.eventEntity = eventEntity;
    }*/

    @Override
    public String toString() {
        return "UrlEntity{" +
                "id=" + id +
                ", url='" + url + '\'' +
/*                ", eventEntity=" + eventEntity +*/
                '}';
    }
}
