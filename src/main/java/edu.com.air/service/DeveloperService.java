package edu.com.air.service;

import edu.com.air.entity.interfaces.impl.Developer;

import java.util.List;

public interface DeveloperService {

    Developer addDeveloper(Developer developer);

    void delete(Long id);

    Developer getByName(String name);

    Developer getById(Long id);

    List<Developer> getAll();

}
