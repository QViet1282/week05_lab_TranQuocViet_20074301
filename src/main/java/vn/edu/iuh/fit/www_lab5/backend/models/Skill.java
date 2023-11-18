package vn.edu.iuh.fit.www_lab5.backend.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.www_lab5.backend.enums.SkillType;

@Entity
@Table(name = "skill")
public class Skill {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id",columnDefinition = "bigint(20)")
    private long skillId;
    @Column(name = "skill_type", columnDefinition = "tinyint(4)")
    @Enumerated(EnumType.ORDINAL)
    private SkillType skillType;
    @Column(name = "skill_name", columnDefinition = "varchar(150)")
    private String skillName;
    @Column(name = "skill_desc", columnDefinition = "varchar(300)")
    private String skillDescription;

    public Skill() {
    }

    public Skill(SkillType skillType, String skillName, String skillDescription) {
        this.skillType = skillType;
        this.skillName = skillName;
        this.skillDescription = skillDescription;
    }

    public long getSkillId() {
        return skillId;
    }

    public void setSkillId(long skillId) {
        this.skillId = skillId;
    }

    public SkillType getSkillType() {
        return skillType;
    }

    public void setSkillType(SkillType skillType) {
        this.skillType = skillType;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "skillId=" + skillId +
                ", skillType='" + skillType + '\'' +
                ", skillName='" + skillName + '\'' +
                ", skillDescription='" + skillDescription + '\'' +
                '}';
    }
}
