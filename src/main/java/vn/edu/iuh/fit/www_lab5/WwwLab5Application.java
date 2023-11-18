package vn.edu.iuh.fit.www_lab5;

import com.neovisionaries.i18n.LocaleCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.www_lab5.backend.enums.Country;
import vn.edu.iuh.fit.www_lab5.backend.enums.SkillType;
import vn.edu.iuh.fit.www_lab5.backend.models.*;
import vn.edu.iuh.fit.www_lab5.backend.repositories.*;

import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
public class WwwLab5Application {

    public static void main(String[] args) {
        SpringApplication.run(WwwLab5Application.class, args);
    }

    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private AddressRepository addressRepository;
	@Autowired
	private CompanyRepository companyRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Bean
    CommandLineRunner initData() {
        return args -> {
//            Random rnd = new Random();
//            for (int i = 1; i < 100; i++) {
//                Address add = new Address(
//                        LocaleCode.vi,
//                        rnd.nextInt(1, 1000) + "",
//                        rnd.nextInt(70000, 80000) + "",
//                        "HCM City",
//                        "Nguyen Hue"
//                );
//                addressRepository.save(add);
//                Candidate can = new Candidate(
//                        LocalDate.of(1998, rnd.nextInt(1, 13), rnd.nextInt(1, 29)),
//                        add,
//                        rnd.nextLong(1111111111L, 9999999999L) + "",
//                        "email_" + i + "@gmail.com",
//                        "Nguyen Van A"
//                );
//                candidateRepository.save(can);
//              Company company = new Company(add, "About company " + i, "Company " + i, "email_" + i + "@gmail.com", rnd.nextLong(1111111111L, 9999999999L) + "", "web_url_" + i);
//				companyRepository.save(company);
//				Job job = new Job(company, "Job description " + i, "Job name " + i);
//                jobRepository.save(job);
//            }
//            Skill skill1 = new Skill(SkillType.SOFT_SKILL, "name1", "");
//            Skill skill2 = new Skill(SkillType.SOFT_SKILL, "name2", "");
//            Skill skill3 = new Skill(SkillType.SOFT_SKILL, "name3", "");
//            Skill skill4 = new Skill(SkillType.SOFT_SKILL, "name4", "");
//            Skill skill5 = new Skill(SkillType.SOFT_SKILL, "name5", "");
//            skillRepository.save(skill1);
//            skillRepository.save(skill2);
//            skillRepository.save(skill3);
//            skillRepository.save(skill4);
//            skillRepository.save(skill5);

        };
    };
};

