package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.PaymentType;
import mk.ukim.finki.wp.repository.PaymentTypeRepository;
import mk.ukim.finki.wp.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Trajche on 09.09.2015.
 */

@Service
public class PaymentTypeServiceImpl
        extends BaseEntityCrudServiceImpl<PaymentType, PaymentTypeRepository>
        implements PaymentTypeService{

    @Autowired
    private PaymentTypeRepository repository;

    @Override
    protected PaymentTypeRepository getRepository() {
        return repository;
    }
}
