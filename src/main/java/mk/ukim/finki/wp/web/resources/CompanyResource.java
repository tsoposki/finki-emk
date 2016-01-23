package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.Company;
import mk.ukim.finki.wp.model.Response;
import mk.ukim.finki.wp.service.CompanyService;
import mk.ukim.finki.wp.service.SubscriptionService;
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
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/data/rest/companies")
public class CompanyResource extends
        CrudResource<Company, CompanyService> {

    @Autowired
    private CompanyService service;

    @Autowired
    private SubscriptionService subscriptionService;

    @Override
    public CompanyService getService() {
        return service;
    }

    @Override
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public Response create(@RequestBody Company entity, HttpServletRequest request,
                           HttpServletResponse response) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        entity.setSubscription(subscriptionService.findOne((long)1));
        getService().save(entity);

        response.setStatus(HttpServletResponse.SC_CREATED);
        return new Response("Successfully created", true, entity);
    }

}
