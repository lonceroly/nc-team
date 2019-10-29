package edu.com.air.repository;

import edu.com.air.entity.classes.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepository extends JpaRepository<Mentor, Long> {
    Mentor getMentorByName(String name);
}
