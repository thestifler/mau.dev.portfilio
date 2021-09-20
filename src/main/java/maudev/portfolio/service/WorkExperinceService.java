package maudev.portfolio.service;

import java.util.List;

import maudev.portfolio.entity.WorkExperience;

public interface WorkExperinceService {
    

    public List<WorkExperience> findAll();
    public WorkExperience findById(Long id);

    public WorkExperience saveWorkExperience(WorkExperience workExperience);
    public WorkExperience updateWorkExperience(WorkExperience workExperience);
    public WorkExperience deleteWorkExperience(Long id);
}
