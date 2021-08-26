package com.infoshareacademy.kulturalniweb.event;

public class Attachment {
    private String attachment;

    public Attachment(String attachment) {
        this.attachment = attachment;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "attachment='" + attachment + '\'' +
                '}';
    }
}
