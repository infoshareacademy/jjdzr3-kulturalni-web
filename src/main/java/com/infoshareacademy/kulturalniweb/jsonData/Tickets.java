package com.infoshareacademy.kulturalniweb.jsonData;

public class Tickets {
    private String type;

    public Tickets (String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "type='" + type + '\'' +
                '}';
    }
}
