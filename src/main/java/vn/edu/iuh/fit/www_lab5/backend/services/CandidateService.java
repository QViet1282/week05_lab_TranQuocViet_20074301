package vn.edu.iuh.fit.www_lab5.backend.services;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.www_lab5.backend.models.Candidate;
import vn.edu.iuh.fit.www_lab5.backend.repositories.CandidateRepository;

import java.util.Collections;
import java.util.List;
@Service
public class CandidateService {
    private CandidateRepository candidateRepository;
    public Page<Candidate> findAll(int pageNo, int pageSize, String sortBy, String sortDirection){
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return candidateRepository.findAll(pageable);
    }
    public Page<Candidate> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Candidate> list;
        List<Candidate> candidates = candidateRepository.findAll();
        if (candidates.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, candidates.size());
            list = candidates.subList(startItem, toIndex);
        }Page<Candidate> candidatePage
                = new PageImpl<>(list, PageRequest.of(currentPage, pageSize),
                candidates.size());
        return candidatePage;
    }
}
