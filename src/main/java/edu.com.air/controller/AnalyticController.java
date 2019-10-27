package edu.com.air.controller;

import edu.com.air.entity.classes.Mentor;
import edu.com.air.entity.interfaces.impl.Analytic;
import edu.com.air.service.AnalyticService;
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

    @RequestMapping("/add")
    public Analytic createAnalytic(
            @RequestParam String name,
            @RequestParam int age){
        Analytic analytic = new Analytic(name, age);
        return analytic;
    }

    @RequestMapping("/add/mentor")
    public Mentor addMentorToAnalytic(
            @RequestParam Long analyticId,
            @RequestParam String mentorName,
            @RequestParam int mentorAge){

        Mentor mentor = new Mentor(mentorName, mentorAge);
        Analytic analytic = analyticService.getById(analyticId);
        analytic.addMentor(mentor);
        return mentorService.addMentor(mentor);
    }

}
