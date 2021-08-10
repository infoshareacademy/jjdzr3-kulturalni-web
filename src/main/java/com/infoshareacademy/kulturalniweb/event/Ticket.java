package com.infoshareacademy.kulturalniweb.event;

public class Ticket {
    private String type;

    public Ticket (String type) {
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
