package peaksoft.service;

import peaksoft.entity.Company;

import java.util.List;

public interface CompanyService {
    String saveCompany(Company company);

    Company findCompanyById(Long id);
    String update(Long id, Company newcompany);

    List<Company> findAllCompany();
    void  delete(Long id);
}
