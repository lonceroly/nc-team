package edu.com.air.repository;

import edu.com.air.entity.interfaces.impl.Analytic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyticRepository extends JpaRepository<Analytic, Long> {
    Analytic getAnalyticByName(String name);
}
