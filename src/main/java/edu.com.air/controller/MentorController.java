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
@RequestMapping("/mentor")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @Autowired
    private AnalyticService analyticService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private DeveloperService developerService;

    @RequestMapping("/add")
    public Mentor createMentor(
            @RequestParam String name,
            @RequestParam int age
    ){
        return mentorService.addMentor(new Mentor(name, age));
    }

    @RequestMapping("/add/group")
    public Mentor addGroupToMentor(
            @RequestParam Long mentorId,
            @RequestParam Long groupId
    ) {
        Mentor mentor = mentorService.getById(mentorId);
        Group group = groupService.getById(groupId);
        mentor.setGroup(group);
        return mentor;
    }

    @RequestMapping("/add/developer")
    public Mentor addDeveloperToMentor(
            @RequestParam Long developerId,
            @RequestParam Long mentorId
    ) {
        Mentor mentor = mentorService.getById(mentorId);
        Developer developer = developerService.getById(developerId);
        mentor.addDeveloper(developer);
        return mentor;
    }

    @RequestMapping("/add/analytic")
    public Mentor addAnalyticToMentor(
            @RequestParam Long analyticId,
            @RequestParam Long mentorId
    ) {
        Mentor mentor = mentorService.getById(mentorId);
        Analytic analytic = analyticService.getById(analyticId);
        mentor.addAnalytic(analytic);
        return mentor;
    }

    @RequestMapping("/get/id")
    private Mentor getMentorById(
            @RequestParam Long mentorId
    ) {
        return mentorService.getById(mentorId);
    }
}
