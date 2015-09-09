package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Currency;
import mk.ukim.finki.wp.model.Invoice;
import mk.ukim.finki.wp.model.InvoiceItem;
import mk.ukim.finki.wp.repository.CurrencyRepository;
import mk.ukim.finki.wp.repository.InvoiceItemRepository;
import mk.ukim.finki.wp.service.CurrencyService;
import mk.ukim.finki.wp.service.InvoiceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Trajche on 08.09.2015.
 */

@Service
public class InvoiceItemServiceImpl extends
        BaseEntityCrudServiceImpl<InvoiceItem, InvoiceItemRepository> implements
        InvoiceItemService {

    @Autowired
    private InvoiceItemRepository repository;

    @Override
    protected InvoiceItemRepository getRepository() {
        return null;
    }

//    @Override
//    public List<InvoiceItem> findByInvoice(Invoice invoice) {
//        return getRepository().findByInvoice(invoice);
//    }
}
