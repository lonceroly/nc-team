package edu.com.air.service.impl;

import edu.com.air.entity.interfaces.impl.Analytic;
import edu.com.air.repository.AnalyticRepository;
import edu.com.air.service.AnalyticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticServiceImpl implements AnalyticService {

    @Autowired
    private AnalyticRepository analyticRepository;

    @Override
    public Analytic addAnalytic(Analytic analytic){
        Analytic savedAnalytic = analyticRepository.saveAndFlush(analytic);
        return savedAnalytic;
    }

    @Override
    public void delete(Long id){
        analyticRepository.deleteById(id);
    }

    @Override
    public Analytic getByName(String name){
        Analytic getAnalytic = analyticRepository.getAnalyticByName(name);
        return getAnalytic;
    }

    @Override
    public Analytic getById(Long id){
        Analytic getAnalytic = analyticRepository.findById(id).orElse(null);
        return getAnalytic;
    }

    @Override
    public List<Analytic> getAll(){
        List<Analytic> analytics = analyticRepository.findAll();
        return analytics;
    }

}
