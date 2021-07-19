package com.infoshareacademy.kulturalniweb.kulturalniEntities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tickets {

    @Id
    private Long id;
    private String typr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypr() {
        return typr;
    }

    public void setTypr(String typr) {
        this.typr = typr;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "id=" + id +
                ", typr='" + typr + '\'' +
                '}';
    }
}
