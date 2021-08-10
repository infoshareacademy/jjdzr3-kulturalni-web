package com.infoshareacademy.kulturalniweb.event;

public class Place {

    private Integer id;
    private String subname;
    private String name;

    public Place (Integer id, String subname, String name) {
        this.id = id;
        this.subname = subname;
        this.name = name;
    }

    public String getSubname () {
        return  subname;
    }

    public void setSubname (String subname) {
        this.subname = subname;
    }

    public String getName () {
        return  name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", subname='" + subname + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
