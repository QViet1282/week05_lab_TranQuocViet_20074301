package vn.edu.iuh.fit.www_lab5.backend.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.www_lab5.backend.models.Address;
import vn.edu.iuh.fit.www_lab5.backend.repositories.AddressRepository;

@Service
public class AddressService {
    private AddressRepository addressRepository;
    public Page<Address> findAll(int pageNo, int pageSize, String sortBy, String
            sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return addressRepository.findAll(pageable);
    }
}
