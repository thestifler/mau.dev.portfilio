package maudev.portfolio.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import maudev.portfolio.entity.SkillDetail;
import maudev.portfolio.repository.SkillDetailRepository;

@Service
@RequiredArgsConstructor
public class SkillDetailServiceImpl implements SkillDetailService{
    
    private final SkillDetailRepository skillDetailRepository;

    @Override
    public SkillDetail deleteSkillDetail(Long id) {
       

        SkillDetail skill = findById(id);

        if (skill == null ) {
            return null;
        }
        skill.setStatus("DELETED");
        return skillDetailRepository.save(skill);
    }

    @Override
    public List<SkillDetail> findAll() {
    
        List<SkillDetail> skills = skillDetailRepository.findAll();
        if (skills == null) {
            return null;
        }

        return skills;
    }

    @Override
    public SkillDetail findById(Long id) {
    
        return skillDetailRepository.findById(id).orElse(null);
    }

    @Override
    public SkillDetail saveSkillDetail(SkillDetail skillDetail) {
        if (skillDetail.getId() != null ) {
            SkillDetail skillDetailDB = findById(skillDetail.getId());

            if (skillDetailDB != null) {
                return skillDetailDB;
            }
        }

        
        skillDetail.setStatus("CREATED");
        skillDetail.setCreateat(new Date());
        return skillDetailRepository.save(skillDetail);
    }

    @Override
    public SkillDetail updateSkillDetail(SkillDetail skillDetail) {
      

        SkillDetail skillDetailDB = findById(skillDetail.getId());

        if (skillDetailDB == null) {
            return null;
        }
        skillDetailDB.setDetails(skillDetail.getDetails());
        
        return skillDetailRepository.save(skillDetailDB);
    }

    
}
