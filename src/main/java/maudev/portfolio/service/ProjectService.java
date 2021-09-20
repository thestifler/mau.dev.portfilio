package maudev.portfolio.service;

import java.util.List;

import maudev.portfolio.entity.Project;

public interface ProjectService {
    

    public List<Project> findAll();
    public Project findById(Long id);

    public Project saveProject(Project project);
    public Project updateProject(Project project);
    public Project deleteProject(Long id);
}
