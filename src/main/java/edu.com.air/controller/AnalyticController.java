package edu.com.air.controller;

import edu.com.air.entity.classes.Group;
import edu.com.air.entity.classes.Mentor;
import edu.com.air.entity.interfaces.impl.Analytic;
import edu.com.air.service.AnalyticService;
import edu.com.air.service.GroupService;
import edu.com.air.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analytic")
public class AnalyticController {

    @Autowired
    private AnalyticService analyticService;

    @Autowired
    private MentorService mentorService;

    @Autowired
    private GroupService groupService;

    @RequestMapping("/add")
    public Analytic createAnalytic(
            @RequestParam String name,
            @RequestParam int age
            ){
        return analyticService.addAnalytic(new Analytic(name, age));
    }

    @RequestMapping("/add/group")
    public Analytic addGroupToAnalytic(
            @RequestParam Long analyticId,
            @RequestParam Long groupId
    ) {
        Analytic analytic = analyticService.getById(analyticId);
        Group group = groupService.getById(groupId);
        analytic.setGroup(group);
        return null;
    }

    @RequestMapping("/add/mentor")
    public Analytic addMentorToAnalytic(
            @RequestParam Long analyticId,
            @RequestParam Long mentorId
    ) {
        Analytic analytic = analyticService.getById(analyticId);
        Mentor mentor = mentorService.getById(mentorId);
        analytic.addMentor(mentor);
        return analytic;
    }

    @RequestMapping("/get/id")
    private Analytic getAnalyticById(
            @RequestParam Long analyticId
    ) {
        return analyticService.getById(analyticId);
    }
}
