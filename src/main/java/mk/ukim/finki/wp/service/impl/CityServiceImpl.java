package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.City;
import mk.ukim.finki.wp.repository.CityRepository;
import mk.ukim.finki.wp.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl extends
        BaseEntityCrudServiceImpl<City, CityRepository> implements
        CityService {

    @Autowired
    private CityRepository repository;

    @Override
    protected CityRepository getRepository() {
        return repository;
    }

}
