package edu.com.air.repository;

import edu.com.air.entity.interfaces.impl.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    Developer getDeveloperByName(String name);
}
