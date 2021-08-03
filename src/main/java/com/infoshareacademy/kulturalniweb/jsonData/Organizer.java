package com.infoshareacademy.kulturalniweb.jsonData;

public class Organizer {
    private Integer id;
    private String designation;

    private Organizer (Integer id, String designation) {
        this.id = id;
        this.designation = designation;
    }

    public String getName() {
        return designation;
    }

    public void setName(String string) {
        this.designation = string;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
