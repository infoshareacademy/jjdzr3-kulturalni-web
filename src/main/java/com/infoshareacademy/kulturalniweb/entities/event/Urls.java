package com.infoshareacademy.kulturalniweb.entities.event;

import javax.persistence.*;

@Entity
public class Urls {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;
    private String  url;

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

    @Override
    public String toString() {
        return "Urls{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }
}
