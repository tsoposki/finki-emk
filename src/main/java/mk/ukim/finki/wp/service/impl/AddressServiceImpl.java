package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Address;
import mk.ukim.finki.wp.repository.AddressRepository;
import mk.ukim.finki.wp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl extends
        BaseEntityCrudServiceImpl<Address, AddressRepository> implements
        AddressService {

    @Autowired
    private AddressRepository repository;

    @Override
    protected AddressRepository getRepository() {
        return repository;
    }

}
