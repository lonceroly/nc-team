package edu.com.air.service;

import edu.com.air.entity.classes.Mentor;

import java.util.List;

public interface MentorService {

    Mentor addMentor(Mentor mentor);

    void delete(Long id);

    Mentor getByName(String name);

    Mentor getById(Long id);

    List<Mentor> getAll();
}
