package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.Company;
import mk.ukim.finki.wp.service.CompanyService;
import mk.ukim.finki.wp.web.CrudResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api/data/rest/companies")
public class CompanyResource extends
        CrudResource<Company, CompanyService> {

    @Autowired
    private CompanyService service;

    @Override
    public CompanyService getService() {
        return service;
    }

    @Override
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public Company create(@RequestBody Company entity, HttpServletRequest request,
                          HttpServletResponse response) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        getService().save(entity);
        System.out.println("Created Company from CompanyResource");
        return entity;
    }

}
