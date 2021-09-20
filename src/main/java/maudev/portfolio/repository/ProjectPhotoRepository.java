package maudev.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import maudev.portfolio.entity.ProjectPhoto;


@Repository
public interface ProjectPhotoRepository extends JpaRepository<ProjectPhoto,Long> {
    
}
