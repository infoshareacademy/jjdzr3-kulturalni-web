package com.infoshareacademy.kulturalniweb.entities.event;



import javax.persistence.*;
import java.util.Set;


@Entity
public class OrganizerEntity {

    @Id
    private Integer id;
    private String designation;

/*    @OneToMany(mappedBy = "id")
    private Set<EventEntity> eventEntities;*/

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

/*    public Set<EventEntity> getEventEntities() {
        return eventEntities;
    }

    public void setEventEntities(Set<EventEntity> eventEntities) {
        this.eventEntities = eventEntities;
    }*/

    @Override
    public String toString() {
        return "OrganizerEntity{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
            /*    ", eventEntities=" + eventEntities +*/
                '}';
    }
}
