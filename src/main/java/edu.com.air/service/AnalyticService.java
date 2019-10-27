package edu.com.air.service;

import edu.com.air.entity.interfaces.impl.Analytic;

import java.util.List;

public interface AnalyticService {

    public Analytic addAnalytic(Analytic analytic);

    public void delete(Long id);

    public Analytic getByName(String name);

    public Analytic getById(Long id);

    public List<Analytic> getAll();

}
