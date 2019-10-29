package edu.com.air.controller;

import edu.com.air.entity.interfaces.impl.Analytic;
import edu.com.air.service.AnalyticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analytic")
public class AnalyticController {

    @Autowired
    private AnalyticService analyticService;

    @RequestMapping("/add")
    public Analytic createAnalytic(
            @RequestParam String name,
            @RequestParam int age
            ){
        Analytic analytic = new Analytic(name, age);
        analyticService.addAnalytic(analytic);
        return analytic;
    }

}
