package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Category;
import mk.ukim.finki.wp.model.Company;
import mk.ukim.finki.wp.model.Partner;
import mk.ukim.finki.wp.repository.CategoryRepository;
import mk.ukim.finki.wp.repository.CompanyRepository;
import mk.ukim.finki.wp.repository.PartnerRepository;
import mk.ukim.finki.wp.service.CategoryService;
import mk.ukim.finki.wp.service.CompanyService;
import mk.ukim.finki.wp.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartnerServiceImpl extends
        BaseEntityCrudServiceImpl<Partner, PartnerRepository> implements
        PartnerService {

    @Autowired
    private PartnerRepository repository;

    @Override
    protected PartnerRepository getRepository() {
        return repository;
    }

}
