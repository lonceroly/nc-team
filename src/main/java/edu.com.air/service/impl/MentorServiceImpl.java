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
    public Mentor addMentor(Mentor mentor){
        return mentorRepository.saveAndFlush(mentor);
    }

    @Override
    public List<Mentor> addMentors(List<Mentor> mentors){
        for(Mentor mentor : mentors) {
            mentorRepository.saveAndFlush(mentor);
        }
        return mentors;
    }

    @Override
    public void delete(Long id){
        mentorRepository.deleteById(id);
    }

    @Override
    public Mentor getByName(String name){
        return  mentorRepository.getMentorByName(name);
    }

    @Override
    public Mentor getById(Long id){
        return mentorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Mentor> getAll(){
        return mentorRepository.findAll();
    }
}
