package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Category;
import mk.ukim.finki.wp.model.Company;
import mk.ukim.finki.wp.repository.CategoryRepository;
import mk.ukim.finki.wp.repository.CompanyRepository;
import mk.ukim.finki.wp.service.CategoryService;
import mk.ukim.finki.wp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl extends
        BaseEntityCrudServiceImpl<Company, CompanyRepository> implements
        CompanyService {

    @Autowired
    private CompanyRepository repository;

    @Override
    protected CompanyRepository getRepository() {
        return repository;
    }

}
