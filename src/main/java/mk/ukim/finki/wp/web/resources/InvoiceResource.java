package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.Invoice;
import mk.ukim.finki.wp.service.InvoiceService;
import mk.ukim.finki.wp.web.CrudResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/data/rest/invoices")
public class InvoiceResource extends
        CrudResource<Invoice, InvoiceService> {

    @Autowired
    private InvoiceService service;

    @Override
    public InvoiceService getService() {
        return service;
    }

}
