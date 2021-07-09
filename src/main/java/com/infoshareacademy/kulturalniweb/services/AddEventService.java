package com.infoshareacademy.kulturalniweb.services;

import com.infoshareacademy.kulturalniweb.domainData.EventSimple;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddEventService {
    EventSimpleMemoryServiceClass eventSimpleMemoryServiceClass;

    public AddEventService(EventSimpleMemoryServiceClass eventSimpleMemoryServiceClass) {
        this.eventSimpleMemoryServiceClass = eventSimpleMemoryServiceClass;
    }

    public Integer getHighestEventId() {
        Integer highestId = 0;
        List<EventSimple> list = eventSimpleMemoryServiceClass.getListOfEventSimpleFromMemory();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEventSimpleId() >= highestId) {
                highestId = list.get(i).getEventSimpleId();
            }
        }
        return highestId;
    }
}
