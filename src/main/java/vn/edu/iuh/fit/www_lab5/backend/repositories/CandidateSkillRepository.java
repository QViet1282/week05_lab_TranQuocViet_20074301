package vn.edu.iuh.fit.www_lab5.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.edu.iuh.fit.www_lab5.backend.models.CandidateSkill;
import vn.edu.iuh.fit.www_lab5.backend.models.Skill;

import java.util.ArrayList;
import java.util.List;

public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, Long> {

    @Query("SELECT DISTINCT c.candidateId FROM CandidateSkill cs " +
            "JOIN cs.canId c " +
            "WHERE cs.skillId IN (:skills) " +
            "GROUP BY c.candidateId " +
            "HAVING COUNT(DISTINCT cs.skillId) >= 1 " +
            "ORDER BY COUNT(DISTINCT cs.skillId) DESC")
    List<Long> findCandidatesBySkills(@Param("skills") List<Skill> skills);

}
