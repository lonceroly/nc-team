package edu.com.air.service;

import edu.com.air.entity.classes.Group;

import java.util.List;

public interface GroupService {

    Group addGroup(Group group);

    void delete(Long id);

    Group getById(Long id);

    List<Group> getAll();
}
