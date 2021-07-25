package com.infoshareacademy.kulturalniweb.kulturalniEntities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Favourites {

    @Id
    private Long id;
    private Boolean favourite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getFavourite() {
        return favourite;
    }

    public void setFavourite(Boolean favourite) {
        this.favourite = favourite;
    }
}
