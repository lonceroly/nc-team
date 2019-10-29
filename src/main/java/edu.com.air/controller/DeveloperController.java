package edu.com.air.controller;

import edu.com.air.entity.classes.Group;
import edu.com.air.entity.classes.Mentor;
import edu.com.air.entity.interfaces.impl.Developer;
import edu.com.air.service.DeveloperService;
import edu.com.air.service.GroupService;
import edu.com.air.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/developer")
public class DeveloperController {

    @Autowired
    private DeveloperService developerService;

    @Autowired
    private MentorService mentorService;

    @Autowired
    private GroupService groupService;

    @RequestMapping("/add")
    public Developer createDeveloper(
            @RequestParam String name,
            @RequestParam int age
    ){
        return developerService.addDeveloper(new Developer(name, age));
    }

    @RequestMapping("/add/group")
    public Developer addGroupToDeveloper(
            @RequestParam Long developerId,
            @RequestParam Long groupId
    ) {
        Group group = groupService.getById(groupId);
        Developer developer = developerService.getById(developerId);
        developer.setGroup(group);
        return developer;
    }

    @RequestMapping("/add/mentor")
    public Developer addMentorToDeveloper(
            @RequestParam Long developerId,
            @RequestParam Long mentorId
    ) {
        Developer developer = developerService.getById(developerId);
        Mentor mentor = mentorService.getById(mentorId);
        developer.addMentor(mentor);
        return developer;
    }

    @RequestMapping("/get/id")
    private Developer getDeveloperById(
            @RequestParam Long developerId
    ) {
        return developerService.getById(developerId);
    }
}
