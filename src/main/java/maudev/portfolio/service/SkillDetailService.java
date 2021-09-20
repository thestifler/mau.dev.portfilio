package maudev.portfolio.service;

import java.util.List;

import maudev.portfolio.entity.SkillDetail;

public interface SkillDetailService {
    
    public List<SkillDetail> findAll();
    public SkillDetail findById(Long id);

    public SkillDetail saveSkillDetail(SkillDetail skillDetail);
    public SkillDetail updateSkillDetail(SkillDetail skillDetail);
    public SkillDetail deleteSkillDetail(Long id);
    
}
