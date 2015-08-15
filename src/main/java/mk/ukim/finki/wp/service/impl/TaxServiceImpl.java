package mk.ukim.finki.wp.service.impl;

import java.util.List;

import mk.ukim.finki.wp.model.Tax;

import mk.ukim.finki.wp.repository.TaxRepository;
import mk.ukim.finki.wp.service.TaxService;
import org.hibernate.SessionFactory;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.hibernate.search.jpa.Search;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class TaxServiceImpl extends
        BaseEntityCrudServiceImpl<Tax, TaxRepository> implements
        TaxService {

    @Autowired
    private TaxRepository repository;

    @Override
    protected TaxRepository getRepository() {
        return repository;
    }


}
