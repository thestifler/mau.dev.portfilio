package maudev.portfolio.service;

import java.util.List;

import maudev.portfolio.entity.ProjectPhoto;

public interface ProjectPhotoService {
    public List<ProjectPhoto> findAll();
    public ProjectPhoto findById(Long id);

    public ProjectPhoto saveProjectPhoto(ProjectPhoto projectPhoto);
    public ProjectPhoto updaProjectPhoto(ProjectPhoto projectPhoto);
    public ProjectPhoto deleteProjectPhoto(Long id);
}
