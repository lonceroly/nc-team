package edu.com.air.service.impl;

import edu.com.air.entity.classes.Mentor;
import edu.com.air.repository.MentorRepository;
import edu.com.air.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorServiceImpl implements MentorService {

    @Autowired
    private MentorRepository mentorRepository;

    @Override
    public Mentor addMentor(Mentor analytic){
        Mentor savedDeveloper = mentorRepository.saveAndFlush(analytic);
        return savedDeveloper;
    }

    @Override
    public void delete(Long id){
        mentorRepository.deleteById(id);
    }

    @Override
    public Mentor getByName(String name){
        Mentor getDeveloper = mentorRepository.getMentorByName(name);
        return getDeveloper;
    }

    @Override
    public Mentor getById(Long id){
        Mentor getDeveloper = mentorRepository.findById(id).orElse(null);
        return getDeveloper;
    }

    @Override
    public List<Mentor> getAll(){
        List<Mentor> developers = mentorRepository.findAll();
        return developers;
    }
}
