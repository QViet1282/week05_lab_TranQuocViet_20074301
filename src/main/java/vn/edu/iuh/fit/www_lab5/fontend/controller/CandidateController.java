package vn.edu.iuh.fit.www_lab5.fontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.www_lab5.backend.models.Candidate;
import vn.edu.iuh.fit.www_lab5.backend.models.Job;
import vn.edu.iuh.fit.www_lab5.backend.models.Skill;
import vn.edu.iuh.fit.www_lab5.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.www_lab5.backend.repositories.JobRepository;
import vn.edu.iuh.fit.www_lab5.backend.repositories.SkillRepository;
import vn.edu.iuh.fit.www_lab5.backend.services.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
@Controller
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private JobService jobService;
    @Autowired
    private JobSkillService jobSkillService;
    @Autowired
    private CandidateSkillService candidateSkillService;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private SkillService skillService;
    @GetMapping("/list")
    public String showCandidateList(Model model) {
        model.addAttribute("candidates", candidateRepository.findAll());
        return "candidates/candidates";
    }
    //Job suggest
    @GetMapping("/candidateSuggest/{id}")
    public String showJobSuggestforCandedate(@PathVariable("id") Long id, Model model) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid candidate Id:" + id));
        List<Skill> SkillIds = candidateSkillService.findSkillByCandidateId(id);
//        System.out.println(SkillIds);
        List<Long> jobIds = jobSkillService.findJobsBySkills(SkillIds);
//        System.out.println(jobIds);
        List<Job> jobs = new ArrayList<Job>();
        for(Long jobId : jobIds) {
            jobs.add(jobRepository.findById(jobId).get());
        }
//        System.out.println(jobs);
        model.addAttribute("jobs", jobs);
        return "candidates/jobSuggest";
    }

    @GetMapping("/skillSuggest/{id}")
    public String showSkillSuggestforCandedate(@PathVariable("id") Long id, Model model) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid candidate Id:" + id));
        List<Skill> Skills = candidateSkillService.findSkillByCandidateId(id);
        List<Skill> unlearnSkills = new ArrayList<Skill>();
        skillService.findAll().forEach(skill -> {
            if(!Skills.contains(skill))
                unlearnSkills.add(skill);
        });
        model.addAttribute("Skills", unlearnSkills);
        return "candidates/skillSuggest";
    }


//    @GetMapping("/candidates")
//    public String showCandidateListPaging(Model model,
//                                          @RequestParam("page") Optional<Integer> page,
//                                          @RequestParam("size") Optional<Integer> size) {
//        int currentPage = page.orElse(2);
//        int pageSize = size.orElse(10);
//        Page<Candidate> candidatePage= candidateService.findPaginated(
//                PageRequest.of(currentPage -1, pageSize)
//        );
//        Page<Candidate> candidatePage = candidateService.findAll(currentPage - 1, pageSize, "id", "asc");
//        model.addAttribute("candidatePage", candidatePage);
//        int totalPages = candidatePage.getTotalPages();
//        if (totalPages > 0) {
//            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
//                    .boxed()
//                    .collect(Collectors.toList());
//            model.addAttribute("pageNumbers", pageNumbers);
//        }
//        return "candidates/candidates-paging";
//    }

}
