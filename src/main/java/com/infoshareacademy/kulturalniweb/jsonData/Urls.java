package com.infoshareacademy.kulturalniweb.jsonData;

public class Urls {
    private String www;

    public Urls (String www) {
        this.www = www;
    }

    public String getWww() {
        return www;
    }

    @Override
    public String toString() {
        return "Urls{" +
                "www='" + www + '\'' +
                '}';
    }
}
