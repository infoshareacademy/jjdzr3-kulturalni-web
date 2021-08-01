package com.infoshareacademy.kulturalniweb.entities.event;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Attachments {

    @Id
    private Long id;
    private String fileName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "Attachments{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
