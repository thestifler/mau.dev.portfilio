package maudev.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import maudev.portfolio.entity.WorkExperience;

@Repository
public interface WorkExperinceRepository extends JpaRepository<WorkExperience,Long>{
    
}
