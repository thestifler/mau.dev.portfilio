package maudev.portfolio.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import maudev.portfolio.entity.Skill;
import maudev.portfolio.repository.SkillRepository;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService{
    
    private final SkillRepository skillRepository;

    @Override
    public Skill deleteSkill(Long id) {
        // TODO Auto-generated method stub
        Skill skill = findById(id);

        if (skill == null) {
            return null;
        }
        skill.setStatus("DELETED");
       
        return  skillRepository.save(skill);
    }

    @Override
    public List<Skill> findAll() {
        // TODO Auto-generated method stub
        List<Skill> skills = skillRepository.findAll();
        if (skills == null) {
            return null;
        }
        return skills;
    }

    @Override
    public Skill findById(Long id) {
        // TODO Auto-generated method stub
        
        return skillRepository.findById(id).orElse(null);
    }

    @Override
    public Skill saveSkill(Skill skill) {
        // TODO Auto-generated method stub
        skill.setStatus("CREATED");
        skill.setCreateat(new Date());
        
        return skillRepository.save(skill);
    }

    @Override
    public Skill updateSkill(Skill skill) {
        // TODO Auto-generated method stub
        Skill skillDB = findById(skill.getId());

        if (skillDB == null) {
            return null;
        }

        skillDB.setName(skill.getName());
        skillDB.setDescription(skill.getDescription());
        skillDB.setUrlphoto(skill.getUrlphoto());

        return skillRepository.save(skillDB);
    }

    
}
