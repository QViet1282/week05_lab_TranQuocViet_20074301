package vn.edu.iuh.fit.www_lab5.backend.ids;

import java.io.Serializable;
import java.util.Objects;

public class JobSkillIds implements Serializable {
    private long jobId;
    private long skillId;

    public JobSkillIds() {
    }

    public JobSkillIds(long jobId, long skillId) {
        this.jobId = jobId;
        this.skillId = skillId;
    }

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public long getSkillId() {
        return skillId;
    }

    public void setSkillId(long skillId) {
        this.skillId = skillId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobSkillIds that = (JobSkillIds) o;
        return jobId == that.jobId && skillId == that.skillId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, skillId);
    }
}
