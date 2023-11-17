package vn.edu.iuh.fit.www_lab5.backend.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id")
    private long experienceId;
    @Column(name = "from_date")
    private Date fromDate;
    @Column(name = "to_date")
    private Date toDate;
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;
    @Column(columnDefinition = "varchar(100)")
    private String role;
    @Column(columnDefinition = "varchar(100)")
    private String company;
    @Column(name = "work_desc", columnDefinition = "varchar(400)")
    private String wordDescription;

    public Experience() {
    }

    public Experience(Date fromDate, Date toDate, Candidate candidate, String role, String company, String wordDescription) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.candidate = candidate;
        this.role = role;
        this.company = company;
        this.wordDescription = wordDescription;
    }

    public long getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(long experienceId) {
        this.experienceId = experienceId;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getWordDescription() {
        return wordDescription;
    }

    public void setWordDescription(String wordDescription) {
        this.wordDescription = wordDescription;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "experienceId=" + experienceId +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", candidate=" + candidate +
                ", role='" + role + '\'' +
                ", company='" + company + '\'' +
                ", wordDescription='" + wordDescription + '\'' +
                '}';
    }
}
