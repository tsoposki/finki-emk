package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.Company;
import mk.ukim.finki.wp.model.Partner;
import mk.ukim.finki.wp.model.Response;
import mk.ukim.finki.wp.model.User;
import mk.ukim.finki.wp.service.PartnerService;
import mk.ukim.finki.wp.service.UserService;
import mk.ukim.finki.wp.web.CrudResource;
import mk.ukim.finki.wp.web.util.RequestProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/data/rest/partners")
public class PartnerResource extends
        CrudResource<Partner, PartnerService> {

    @Autowired
    private PartnerService service;

    @Autowired
    private UserService userService;

    @Override
    public PartnerService getService() {
        return service;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Partner> getAll() {
        String username = RequestProcessor.getUsername();
        User user = userService.findByUsername(username);

        if (user != null) {
            return service.findByCompany(user.getCompany());
        }

        return null;
    }

    @Override
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public Response create(@RequestBody Partner entity, HttpServletRequest request,
                           HttpServletResponse response) {

        String username = RequestProcessor.getUsername();
        User user = userService.findByUsername(username);
        Response res = new Response();

        if (user != null) {
            Company company = user.getCompany();
            List<Partner> partners = service.findByCompany(company);

            if (partners.size() < company.getSubscription().getPartnersLimit()) {
                entity.setCompany(company);
                getService().save(entity);

                response.setStatus(HttpServletResponse.SC_CREATED);
                res.setMessage("Successfully created");
                res.setSuccess(true);
                res.setEntity(entity);
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);

                res.setMessage("Exceeded the maximum allowable limit for items");
                res.setSuccess(false);
                res.setEntity(null);
            }
        }

        return null;
    }

}
