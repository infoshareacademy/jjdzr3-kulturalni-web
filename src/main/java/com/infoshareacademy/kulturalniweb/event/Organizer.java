package com.infoshareacademy.kulturalniweb.event;

public class Organizer {
    private Integer id;
    private String designation;

    public Organizer(Integer id, String designation) {
        this.id = id;
        this.designation = designation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Organizer{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                '}';
    }
}
