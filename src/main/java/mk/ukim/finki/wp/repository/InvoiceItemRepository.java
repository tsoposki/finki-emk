package mk.ukim.finki.wp.repository;

import mk.ukim.finki.wp.model.Company;
import mk.ukim.finki.wp.model.Invoice;
import mk.ukim.finki.wp.model.InvoiceItem;

import java.util.List;

/**
 * Created by Trajche on 08.09.2015.
 */
public interface InvoiceItemRepository extends JpaSpecificationRepository<InvoiceItem> {
//    List<InvoiceItem> findByInvoice(Invoice invoice);
}
