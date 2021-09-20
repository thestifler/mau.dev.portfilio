package maudev.portfolio.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import maudev.portfolio.entity.WorkExperience;
import maudev.portfolio.repository.WorkExperinceRepository;

@Service
@RequiredArgsConstructor
public class WorkExperienceServiceImpl implements WorkExperinceService {

    private final WorkExperinceRepository workExperinceRepository;

    @Override
    public WorkExperience deleteWorkExperience(Long id) {
        // TODO Auto-generated method stub
        WorkExperience workExperience = findById(id);
        workExperience.setStatus("DELETED");
        return workExperinceRepository.save(workExperience);
    }

    @Override
    public List<WorkExperience> findAll() {
        // TODO Auto-generated method stub
        return workExperinceRepository.findAll();
    }

    @Override
    public WorkExperience findById(Long id) {
        // TODO Auto-generated method stub
        return workExperinceRepository.findById(id).orElse(null);
    }

    @Override
    public WorkExperience saveWorkExperience(WorkExperience workExperience) {
        // TODO Auto-generated method stub
        workExperience.setStatus("CREATED");
        workExperience.setCreateat(new Date());
        return workExperinceRepository.save(workExperience);
    }

    @Override
    public WorkExperience updateWorkExperience(WorkExperience workExperience) {
        // TODO Auto-generated method stub

        WorkExperience workExperienceDB = findById(workExperience.getId());

        if (workExperienceDB == null) {
            return null;
        }
        workExperienceDB.setJobposition(workExperience.getJobposition());
        workExperienceDB.setCompany(workExperience.getCompany());
        workExperienceDB.setDescription(workExperience.getDescription());
        workExperienceDB.setStartdate(workExperience.getStartdate());
        workExperienceDB.setFinishdate(workExperience.getStartdate());
        workExperienceDB.setLocation(workExperience.getLocation());

        return workExperinceRepository.save(workExperienceDB);
    }
    
    
}
