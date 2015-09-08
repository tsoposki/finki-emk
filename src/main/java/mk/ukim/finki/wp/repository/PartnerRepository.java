package mk.ukim.finki.wp.repository;

import mk.ukim.finki.wp.model.Company;
import mk.ukim.finki.wp.model.Partner;

import java.util.List;

/**
 * Created by Trajche on 8/15/2015.
 */
public interface PartnerRepository extends JpaSpecificationRepository<Partner> {
    List<Partner> findByCompany(Company company);
}
