package vn.edu.iuh.fit.www_lab5.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.www_lab5.backend.models.JobSkill;
import vn.edu.iuh.fit.www_lab5.backend.models.Skill;
import vn.edu.iuh.fit.www_lab5.backend.repositories.JobSkillRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobSkillService {
    @Autowired
    private JobSkillRepository jobSkillRepository;
    public List<Long> findJobsBySkills(List<Skill> skillIds) {
        return jobSkillRepository.findJobsBySkills(skillIds);
    }

    public List<Skill> findSkillByJobId(Long jobId) {
        List<JobSkill> jobSkills = jobSkillRepository.findAll();
        List<Skill> skills = new ArrayList<>();

        for (JobSkill jobSkill : jobSkills) {
            if (jobSkill.getJob().getJobId() == jobId) {
                skills.add(jobSkill.getSkill());
            }
        }
        return skills;
    }

}
