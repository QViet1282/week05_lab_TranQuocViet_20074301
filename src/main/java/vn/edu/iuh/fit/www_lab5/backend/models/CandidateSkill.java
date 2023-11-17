package vn.edu.iuh.fit.www_lab5.backend.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.www_lab5.backend.ids.CandidateSkillIds;

@Entity
@Table(name = "candidate_skill")
@IdClass(CandidateSkillIds.class)
public class CandidateSkill {
    @Id
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate canId;
    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skillId;

    @Column(name = "skill_level", columnDefinition = "tinyint(4)")
    private int skillLevel;
    @Column(name = "more_infos", columnDefinition = "varchar(1000)")
    private String moreInfos;

    public CandidateSkill() {
    }

    public CandidateSkill(Candidate candidate, Skill skill, int skillLevel, String moreInfos) {
        this.canId = candidate;
        this.skillId = skill;
        this.skillLevel = skillLevel;
        this.moreInfos = moreInfos;
    }

    public Candidate getCandidate() {
        return canId;
    }

    public void setCandidate(Candidate candidate) {
        this.canId = candidate;
    }

    public Skill getSkill() {
        return skillId;
    }

    public void setSkill(Skill skill) {
        this.skillId = skill;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public String getMoreInfos() {
        return moreInfos;
    }

    public void setMoreInfos(String moreInfos) {
        this.moreInfos = moreInfos;
    }

    @Override
    public String toString() {
        return "CandidateSkill{" +
                "candidate=" + canId +
                ", skill=" + skillId +
                ", skillLevel=" + skillLevel +
                ", moreInfos='" + moreInfos + '\'' +
                '}';
    }
}
