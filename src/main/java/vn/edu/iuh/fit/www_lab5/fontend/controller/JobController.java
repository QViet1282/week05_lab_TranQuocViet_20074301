package vn.edu.iuh.fit.www_lab5.fontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.www_lab5.backend.models.Candidate;
import vn.edu.iuh.fit.www_lab5.backend.models.Company;
import vn.edu.iuh.fit.www_lab5.backend.models.Job;
import vn.edu.iuh.fit.www_lab5.backend.models.Skill;
import vn.edu.iuh.fit.www_lab5.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.www_lab5.backend.repositories.CandidateSkillRepository;
import vn.edu.iuh.fit.www_lab5.backend.repositories.CompanyRepository;
import vn.edu.iuh.fit.www_lab5.backend.repositories.JobRepository;
import vn.edu.iuh.fit.www_lab5.backend.services.CandidateSkillService;
import vn.edu.iuh.fit.www_lab5.backend.services.JobSkillService;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private CandidateSkillService candidateSkillService;
    @Autowired
    private JobSkillService jobSkillService;


    @PostMapping("/company/{id}/jobs/createJob/save")
    public String createJob(@RequestParam("jobName") String jobName,
                            @RequestParam("jobDescription") String jobDescription,
                            @PathVariable Long id,
                            Model model) {
        Company company = companyRepository.findById(id).orElse(null);
        model.addAttribute("company", company);
        Job job = new Job(company,jobDescription,jobName);
        jobRepository.save(job);
        return "redirect:/company/" + id + "/jobs";
    }

    @GetMapping("/company/{id}/jobs/createJob")
    public String showCreateJobForm(@PathVariable Long id, Model model) {
        Company company = companyRepository.findById(id).orElse(null);
        model.addAttribute("company", company);
        return "job/create-job";
    }

    @GetMapping("/company/{id}/jobs")
    public String showJobList(@PathVariable String id,Model model) {

        Company company = companyRepository.findById(Long.parseLong(id)).orElse(null);
//        if(company == null){
//            String errorMessage = "Không tìm thấy công ty với ID: " + id;
//            model.addAttribute("error", errorMessage);
//            return "redirect:/company" + errorMessage;
//        }
        List<Job> companyJobs = jobRepository.findByCompany(company);
        model.addAttribute("companyJobs", companyJobs);
        model.addAttribute("company", company);
        return "job/company-job";
    }

    @GetMapping("/jobSuggest/{id}")
    public String showJobSuggestForCandidate(@PathVariable("id") Long id, Model model) {
        // Lấy thông tin của ứng viên từ cơ sở dữ liệu
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid candidate Id:" + id));

        // Lấy danh sách kỹ năng của ứng viên
        List<Skill> skills = candidateSkillService.findSkillByCandidateId(id);

        // Tìm kiếm các công việc dựa trên kỹ năng của ứng viên
        List<Long> jobIds = jobSkillService.findJobsBySkills(skills);
        List<Job> suggestedJobs = jobRepository.findAllById(jobIds);
        model.addAttribute("suggestedJobs", suggestedJobs);
        model.addAttribute("candidate", candidate);

        // Chuyển hướng đến trang hiển thị các công việc đề xuất cho ứng viên
        return "candidates/jobSuggest";
    }

}
