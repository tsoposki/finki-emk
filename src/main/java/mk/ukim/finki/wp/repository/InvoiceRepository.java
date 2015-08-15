package mk.ukim.finki.wp.repository;

import mk.ukim.finki.wp.model.Invoice;
import mk.ukim.finki.wp.model.Item;
import mk.ukim.finki.wp.model.Partner;

import java.util.List;

/**
 * Created by Trajche on 8/15/2015.
 */
public interface InvoiceRepository extends JpaSpecificationRepository<Invoice> {
    List<Item> findByPartnerId(Long id);

    List<Item> findByPartner(Partner partner);
}
