package com.infoshareacademy.kulturalniweb.services;

import org.springframework.stereotype.Service;

@Service
public class AppServiceClass {
    RepositoryServiceClass repositoryServiceClass;

    public AppServiceClass(RepositoryServiceClass repositoryServiceClass) {
        this.repositoryServiceClass = repositoryServiceClass;
    }


}
