package maudev.portfolio.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import maudev.portfolio.entity.ProjectPhoto;
import maudev.portfolio.repository.ProjectPhotoRepository;


@Service
@RequiredArgsConstructor
public class ProjectPhotoServiceImpl implements ProjectPhotoService {

    private final ProjectPhotoRepository projectPhotoRepository;
    @Override
    public ProjectPhoto deleteProjectPhoto(Long id) {
        // TODO Auto-generated method stub
        ProjectPhoto project = findById(id);

        if (project == null) {
            return null;
        }
        project.setStatus("DELETED");


        return projectPhotoRepository.save(project);
    }

    @Override
    public List<ProjectPhoto> findAll() {
        // TODO Auto-generated method stub
        List<ProjectPhoto> projectPhotos = projectPhotoRepository.findAll();

        if (projectPhotos == null) {
            return null;
        }
        return projectPhotos;
    }

    @Override
    public ProjectPhoto findById(Long id) {
        // TODO Auto-generated method stub

        ProjectPhoto projectPhoto = projectPhotoRepository.findById(id).orElse(null);
        if (projectPhoto == null) {
            return null;
        }
        return projectPhoto;
    }

    @Override
    public ProjectPhoto saveProjectPhoto(ProjectPhoto projectPhoto) {
        // TODO Auto-generated method stub

        projectPhoto.setStatus("CREATED");
        projectPhoto.setCreateat(new Date());
        return projectPhotoRepository.save(projectPhoto);
    }

    @Override
    public ProjectPhoto updaProjectPhoto(ProjectPhoto projectPhoto) {
        // TODO Auto-generated method stub

        ProjectPhoto projectPhotoDB = findById(projectPhoto.getId());

        if (projectPhotoDB == null) {
            return null;
        }
        projectPhotoDB.setUrl(projectPhoto.getUrl());
        return projectPhotoRepository.save(projectPhotoDB);
    }
    
    
}
