package maudev.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import maudev.portfolio.entity.SkillDetail;

@Repository
public interface SkillDetailRepository extends JpaRepository<SkillDetail,Long> {
    
}
