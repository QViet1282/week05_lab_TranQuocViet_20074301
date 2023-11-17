package vn.edu.iuh.fit.www_lab5.backend.ids;

import java.io.Serializable;
import java.util.Objects;

public class CandidateSkillIds implements Serializable {
    private long canId;
    private long skillId;

    public CandidateSkillIds() {
    }

    public CandidateSkillIds(long canId, long skillID) {
        this.canId = canId;
        this.skillId = skillID;
    }

    public long getCanId() {
        return canId;
    }

    public void setCanId(long canId) {
        this.canId = canId;
    }

    public long getSkillID() {
        return skillId;
    }

    public void setSkillID(long skillID) {
        this.skillId = skillID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandidateSkillIds that = (CandidateSkillIds) o;
        return canId == that.canId && skillId == that.skillId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(canId, skillId);
    }

    @Override
    public String toString() {
        return "CandidateSkillIds{" +
                "canId=" + canId +
                ", skillID=" + skillId +
                '}';
    }
}
