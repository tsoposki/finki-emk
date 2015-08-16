package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Invoice;
import mk.ukim.finki.wp.repository.InvoiceRepository;
import mk.ukim.finki.wp.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl extends
        BaseEntityCrudServiceImpl<Invoice, InvoiceRepository> implements
        InvoiceService {

    @Autowired
    private InvoiceRepository repository;

    @Override
    protected InvoiceRepository getRepository() {
        return repository;
    }

}
