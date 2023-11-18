package vn.edu.iuh.fit.www_lab5.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.www_lab5.backend.models.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
