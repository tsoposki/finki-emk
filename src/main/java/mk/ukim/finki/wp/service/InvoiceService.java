package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.Company;
import mk.ukim.finki.wp.model.Invoice;
import mk.ukim.finki.wp.model.Item;

import java.util.List;

/**
 * Created by Trajche on 8/15/2015.
 */
public interface InvoiceService extends BaseEntityCrudService<Invoice> {
    List<Invoice> findByCompany(Company company);
}
