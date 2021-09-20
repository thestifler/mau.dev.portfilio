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
        // TODO Auto-generated method stub

        SkillDetail skill = findById(id);

        if (skill == null ) {
            return null;
        }
        skill.setStatus("DELETED");
        return skillDetailRepository.save(skill);
    }

    @Override
    public List<SkillDetail> findAll() {
        // TODO Auto-generated method stub
        List<SkillDetail> skills = skillDetailRepository.findAll();
        if (skills == null) {
            return null;
        }

        return skills;
    }

    @Override
    public SkillDetail findById(Long id) {
        // TODO Auto-generated method stub
        return skillDetailRepository.findById(id).orElse(null);
    }

    @Override
    public SkillDetail saveSkillDetail(SkillDetail skillDetail) {
        // TODO Auto-generated method stub

        skillDetail.setStatus("CREATED");
        skillDetail.setCreateat(new Date());
        return skillDetailRepository.save(skillDetail);
    }

    @Override
    public SkillDetail updateSkillDetail(SkillDetail skillDetail) {
        // TODO Auto-generated method stub

        SkillDetail skillDetailDB = findById(skillDetail.getId());

        if (skillDetailDB == null) {
            return null;
        }
        skillDetailDB.setDetails(skillDetail.getDetails());
        
        return skillDetailRepository.save(skillDetailDB);
    }

    
}
