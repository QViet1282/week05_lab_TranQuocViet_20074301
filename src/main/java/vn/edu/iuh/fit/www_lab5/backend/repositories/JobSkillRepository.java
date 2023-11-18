package vn.edu.iuh.fit.www_lab5.backend.repositories;

import jakarta.persistence.NamedQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.www_lab5.backend.models.Job;
import vn.edu.iuh.fit.www_lab5.backend.models.JobSkill;
import vn.edu.iuh.fit.www_lab5.backend.models.Skill;

import java.util.List;

public interface JobSkillRepository extends JpaRepository<JobSkill, Long> {
//    @Query("SELECT j.jobId FROM JobSkill j " +
//            "WHERE j.skillId IN (:skills) " +
//            "GROUP BY j.jobId " +
//            "HAVING COUNT(DISTINCT j.skillId) >= 1 " +
//            "ORDER BY COUNT(DISTINCT j.skillId) DESC " +
//            "LIMIT 15")
//    List<Long> findJobsBySkills(@Param("skills") List<Skill> skills);


    @Query("SELECT DISTINCT j.jobId FROM JobSkill js " +
            "JOIN js.jobId j " +
            "WHERE js.skillId IN (:skills) " +
            "GROUP BY j.jobId " +
            "HAVING COUNT(DISTINCT js.skillId) >= 1 " +
            "ORDER BY COUNT(DISTINCT js.skillId) DESC")
    List<Long> findJobsBySkills(@Param("skills") List<Skill> skills);


}
