package com.infoshareacademy.kulturalniweb.services;

import com.infoshareacademy.kulturalniweb.domainData.EventSimple;
import com.infoshareacademy.kulturalniweb.repository.ListEventRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppServiceClass {
    RepositoryServiceClass repositoryServiceClass;

    public AppServiceClass(RepositoryServiceClass repositoryServiceClass) {
        this.repositoryServiceClass = repositoryServiceClass;
    }

    public List<EventSimple> getSimpleEventsList(int numberOfEventsOnThePage) {
        return repositoryServiceClass.getListOfEventSimple(numberOfEventsOnThePage);
    }

    public List<EventSimple> getNewestEventSimple() {
        return repositoryServiceClass.getListOfEventSimple();
    }



}
