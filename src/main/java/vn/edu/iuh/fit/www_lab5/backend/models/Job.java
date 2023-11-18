package vn.edu.iuh.fit.www_lab5.backend.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private long jobId;
    @ManyToOne
    @JoinColumn(name = "com_id")
    private Company company;
    @Column(name = "job_desc", columnDefinition = "varchar(2000)")
    private String jobDescription;
    @Column(name = "job_name", columnDefinition = "varchar(255)")
    private String jobName;
//    @OneToMany(mappedBy = "jobId", cascade = CascadeType.ALL)
//    List<JobSkill> jobSkills;
    public Job() {
    }

    public Job(Company company, String jobDescription, String jobName) {
        this.company = company;
        this.jobDescription = jobDescription;
        this.jobName = jobName;
    }

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }


    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", company=" + company +
                ", jobDescription='" + jobDescription + '\'' +
                ", jobName='" + jobName + '\'' +
                '}';
    }
}
