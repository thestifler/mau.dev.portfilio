package maudev.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import maudev.portfolio.entity.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill,Long> {
    
}
