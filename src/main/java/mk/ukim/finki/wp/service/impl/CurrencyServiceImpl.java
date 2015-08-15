package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Currency;
import mk.ukim.finki.wp.repository.CurrencyRepository;
import mk.ukim.finki.wp.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl extends
        BaseEntityCrudServiceImpl<Currency, CurrencyRepository> implements
        CurrencyService {

    @Autowired
    private CurrencyRepository repository;

    @Override
    protected CurrencyRepository getRepository() {
        return repository;
    }

}
