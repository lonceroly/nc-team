package edu.com.air.service.impl;

import edu.com.air.entity.classes.Group;
import edu.com.air.repository.GroupRepository;
import edu.com.air.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Group addGroup(Group group){
        Group addedGroup = groupRepository.saveAndFlush(group);
        return addedGroup;
    }

    @Override
    public void delete(Long id){
        groupRepository.deleteById(id);
    }

    @Override
    public Group getById(Long id){
        Group getGroup = groupRepository.findById(id).orElse(null);
        return getGroup;
    }

    @Override
    public List<Group> getAll(){
        List<Group> groups = groupRepository.findAll();
        return groups;
    }
}
