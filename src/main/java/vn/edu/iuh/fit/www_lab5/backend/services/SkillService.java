package vn.edu.iuh.fit.www_lab5.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.www_lab5.backend.models.Skill;
import vn.edu.iuh.fit.www_lab5.backend.repositories.SkillRepository;

import java.util.List;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> findAll() {
        return skillRepository.findAll();
    }
}
