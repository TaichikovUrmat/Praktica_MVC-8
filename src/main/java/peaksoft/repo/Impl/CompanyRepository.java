package peaksoft.repo.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Company;
import peaksoft.repo.CompanyRepo;

import java.util.List;


@Repository
@RequiredArgsConstructor
@Transactional
public class CompanyRepository implements CompanyRepo {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public String saveCompany(Company company) {

        entityManager.persist(company);
        return "Company saved !!";
    }

    @Override
    public Company findCompanyById(Long id) {
        return entityManager.find(Company.class,id);
    }

    @Override
    public String update(Long id, Company newcompany) {
        Company companyById = findCompanyById(id);
        companyById.setName(newcompany.getName());
        companyById.setDescription(newcompany.getDescription());
        companyById.setAddress(newcompany.getAddress());
        entityManager.merge(companyById);

        return "Company deleted !!";
    }

    @Override
    public List<Company> findAllCompany() {
        return entityManager.createQuery("select  c from Company c",Company.class).getResultList();
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(Company.class,id));

    }
}
