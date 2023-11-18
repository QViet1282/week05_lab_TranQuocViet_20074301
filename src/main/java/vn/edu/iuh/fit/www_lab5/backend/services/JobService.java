package vn.edu.iuh.fit.www_lab5.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.www_lab5.backend.models.Job;
import vn.edu.iuh.fit.www_lab5.backend.repositories.CandidateSkillRepository;
import vn.edu.iuh.fit.www_lab5.backend.repositories.JobRepository;
import vn.edu.iuh.fit.www_lab5.backend.repositories.JobSkillRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

}
