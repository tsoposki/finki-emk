package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.Company;
import mk.ukim.finki.wp.model.Partner;

import java.util.List;

/**
 * Created by Trajche on 8/15/2015.
 */
public interface PartnerService extends BaseEntityCrudService<Partner> {
    List<Partner> findByCompany(Company company);
}
