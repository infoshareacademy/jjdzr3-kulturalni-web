package com.infoshareacademy.kulturalniweb.event;

public class Url {
    private String www;

    public Url (String www) {
        this.www = www;
    }

    public String getWww() {
        return www;
    }

    @Override
    public String toString() {
        return "Url{" +
                "www='" + www + '\'' +
                '}';
    }
}
