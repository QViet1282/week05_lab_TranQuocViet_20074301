package vn.edu.iuh.fit.www_lab5.backend.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.www_lab5.backend.enums.SkillLevel;
import vn.edu.iuh.fit.www_lab5.backend.ids.JobSkillIds;

@Entity
@Table(name = "job_skill")
@IdClass(JobSkillIds.class)
public class JobSkill {
    @Id
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job jobId;
    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skillId;
    @Column(name = "skill_level", columnDefinition = "tinyint(4)")
    @Enumerated(EnumType.ORDINAL)
    private SkillLevel skillLevel;
    @Column(name = "more_infos", columnDefinition = "varchar(1000)")
    private String moreInfos;

    public JobSkill() {
    }

    public JobSkill(Job job, Skill skill, SkillLevel skillLevel, String moreInfos) {
        this.jobId = job;
        this.skillId = skill;
        this.skillLevel = skillLevel;
        this.moreInfos = moreInfos;
    }

    public Job getJob() {
        return jobId;
    }

    public void setJob(Job job) {
        this.jobId = job;
    }

    public Skill getSkill() {
        return skillId;
    }

    public void setSkill(Skill skill) {
        this.skillId = skill;
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(SkillLevel skillLevel) {
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
        return "JobSkill{" +
                "job=" + jobId +
                ", skill=" + skillId +
                ", skillLevel=" + skillLevel +
                ", moreInfos='" + moreInfos + '\'' +
                '}';
    }
}
