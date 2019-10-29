package edu.com.air.controller;

import edu.com.air.entity.classes.Group;
import edu.com.air.entity.classes.Mentor;
import edu.com.air.entity.interfaces.impl.Analytic;
import edu.com.air.entity.interfaces.impl.Developer;
import edu.com.air.service.AnalyticService;
import edu.com.air.service.DeveloperService;
import edu.com.air.service.GroupService;
import edu.com.air.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/group")
public class GroupContoller {

    @Autowired
    private GroupService groupService;

    @Autowired
    private MentorService mentorService;

    @Autowired
    private AnalyticService analyticService;

    @Autowired
    private DeveloperService developerService;

    @RequestMapping("/add")
    public Group createGroup(
            @RequestParam String type
    ){
        return groupService.addGroup(new Group(type));
    }

    @RequestMapping("/add/mentor")
    public Group addMentorToGroup(
            @RequestParam Long mentorId,
            @RequestParam Long groupId
    ) {
        Mentor mentor = mentorService.getById(mentorId);
        Group group = groupService.getById(groupId);
        group.addMentor(mentor);
        return group;
    }

    @RequestMapping("/add/analytic")
    public Group addAnalyticToGroup(
            @RequestParam Long analyticId,
            @RequestParam Long groupId
    ) {
        Analytic analytic = analyticService.getById(analyticId);
        Group group = groupService.getById(groupId);
        group.addAnalytic(analytic);
        return group;
    }

    @RequestMapping("/add/developer")
    public Group addDeveloperToGroup(
            @RequestParam Long developerId,
            @RequestParam Long groupId
    ) {
        Developer developer = developerService.getById(developerId);
        Group group = groupService.getById(groupId);
        group.addDeveloper(developer);
        return group;
    }

    @RequestMapping("/get/id")
    private Mentor getMentorById(
            @RequestParam Long mentorId
    ) {
        return mentorService.getById(mentorId);
    }
}
