package peaksoft.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Company;
import peaksoft.repo.CompanyRepo;
import peaksoft.service.CompanyService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepo companyRepo;


    @Override
    public String saveCompany(Company company) {
        return companyRepo.saveCompany(company);
    }

    @Override
    public Company findCompanyById(Long id) {
        return companyRepo.findCompanyById(id);
    }

    @Override
    public String update(Long id, Company newcompany) {
        return companyRepo.update(id,newcompany);
    }

    @Override
    public List<Company> findAllCompany() {
        return companyRepo.findAllCompany();
    }

    @Override
    public void delete(Long id) {
     companyRepo.delete(id);
    }
}
