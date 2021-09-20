package maudev.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import maudev.portfolio.entity.Project;

public interface ProjectRepository extends JpaRepository<Project,Long>{
    
}
