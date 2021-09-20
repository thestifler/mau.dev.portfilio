package maudev.portfolio.service;

import java.util.List;

import maudev.portfolio.entity.Skill;

public interface SkillService {
    
    public List<Skill> findAll();
    public Skill findById(Long id);

    public Skill saveSkill(Skill skill);
    public Skill updateSkill(Skill skill);
    public Skill deleteSkill(Long id);
}
