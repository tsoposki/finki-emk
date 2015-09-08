package mk.ukim.finki.wp.repository;
import mk.ukim.finki.wp.model.Invoice;

import java.util.List;

/**
 * Created by Trajche on 8/15/2015.
 */
public interface InvoiceRepository extends JpaSpecificationRepository<Invoice> {
    List<Invoice> findByUsername(String s);
}
