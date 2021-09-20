package maudev.portfolio.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import maudev.portfolio.entity.Project;
import maudev.portfolio.repository.ProjectRepository;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    
    private final ProjectRepository projectRepository;
    
    @Override
    public Project deleteProject(Long id) {
        // TODO Auto-generated method stub

        Project projectDB = findById(id);
        if (projectDB == null) {
            return null;
        }

        projectDB.setStatus("DELETED");
        return projectRepository.save(projectDB);
    }

    @Override
    public List<Project> findAll() {
        // TODO Auto-generated method stub
        return projectRepository.findAll();
    }

    @Override
    public Project findById(Long id) {
        // TODO Auto-generated method stub
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public Project saveProject(Project project) {
        // TODO Auto-generated method stub
        project.setStatus("CREATED");
        project.setCreateat(new Date());
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(Project project) {
        // TODO Auto-generated method stub

        Project projectDB = findById(project.getId());

        if (projectDB == null) {
            return null;
        }

        projectDB.setName(project.getName());
        projectDB.setDescription(project.getDescription());
        projectDB.setResume(project.getResume());
        projectDB.setUrlgithub(project.getUrlgithub());
        projectDB.setUrlproject(project.getUrlproject());
        return projectRepository.save(projectDB);
    }
    
}
