package vn.edu.iuh.fit.www_lab5.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.www_lab5.backend.models.CandidateSkill;
import vn.edu.iuh.fit.www_lab5.backend.models.Skill;
import vn.edu.iuh.fit.www_lab5.backend.repositories.CandidateSkillRepository;
import vn.edu.iuh.fit.www_lab5.backend.repositories.SkillRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class CandidateSkillService {
    @Autowired
    private CandidateSkillRepository candidateSkillRepository;
    @Autowired
    private SkillRepository skillRepository;
    public List<Skill> findSkillByCandidateId(Long candidateId){
        List<CandidateSkill> candidateSkills = candidateSkillRepository.findAll();
        List<Skill> skills = new ArrayList<Skill>();
        for (CandidateSkill candidateSkill : candidateSkills) {
            if (candidateSkill.getCandidate().getCandidateId() == candidateId) {
                skills.add(candidateSkill.getSkill());
            }
        }
        return skills;
    };
    public List<Long> findCansBySkills(List<Skill> skillIds) {
        return candidateSkillRepository.findCandidatesBySkills(skillIds);
    }
//    public List<Long> findSkillIdByCandidateId(Long candidateId){
//        List<CandidateSkill> candidateSkills = candidateSkillRepository.findAll();
//        List<Long> skillIds = new ArrayList<Skill>();
//        for (CandidateSkill candidateSkill : candidateSkills) {
//            if (candidateSkill.getCandidate().getCandidateId() == candidateId) {
//                skillIds.add(candidateSkill.getSkill().getSkillId());
//            }
//        }
//        return skillIds;
//    };
}
