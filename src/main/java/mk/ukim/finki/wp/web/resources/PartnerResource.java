package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.Category;
import mk.ukim.finki.wp.model.Company;
import mk.ukim.finki.wp.model.Partner;
import mk.ukim.finki.wp.service.CategoryService;
import mk.ukim.finki.wp.service.CompanyService;
import mk.ukim.finki.wp.service.PartnerService;
import mk.ukim.finki.wp.web.CrudResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/data/rest/partners")
public class PartnerResource extends
        CrudResource<Partner, PartnerService> {

    @Autowired
    private PartnerService service;

    @Override
    public PartnerService getService() {
        return service;
    }

}
