package vn.edu.iuh.fit.www_lab5.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.edu.iuh.fit.www_lab5.backend.models.Company;
import vn.edu.iuh.fit.www_lab5.backend.models.Job;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {

    @Query("select j from Job j where j.company = :company")
    List<Job> findByCompany(@Param("company") Company company);
}
