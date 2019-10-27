package edu.com.air.service.impl;

import edu.com.air.entity.interfaces.impl.Developer;
import edu.com.air.repository.DeveloperRepository;
import edu.com.air.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;

    @Override
    public Developer addDeveloper(Developer analytic){
        Developer savedDeveloper = developerRepository.saveAndFlush(analytic);
        return savedDeveloper;
    }

    @Override
    public void delete(Long id){
        developerRepository.deleteById(id);
    }

    @Override
    public Developer getByName(String name){
        Developer getDeveloper = developerRepository.getDeveloperByName(name);
        return getDeveloper;
    }

    @Override
    public Developer getById(Long id){
        Developer getDeveloper = developerRepository.findById(id).orElse(null);
        return getDeveloper;
    }

    @Override
    public List<Developer> getAll(){
        List<Developer> developers = developerRepository.findAll();
        return developers;
    }
}
