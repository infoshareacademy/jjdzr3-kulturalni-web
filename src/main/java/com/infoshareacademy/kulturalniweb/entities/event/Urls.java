package com.infoshareacademy.kulturalniweb.entities.event;

import javax.persistence.*;

@Entity
public class Urls {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer Id;
    private String  url;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Urls{" +
                "Id=" + Id +
                ", url='" + url + '\'' +
                '}';
    }
}
