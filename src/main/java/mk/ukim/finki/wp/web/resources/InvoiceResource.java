package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.*;
import mk.ukim.finki.wp.service.InvoiceItemService;
import mk.ukim.finki.wp.service.InvoiceService;
import mk.ukim.finki.wp.service.UserService;
import mk.ukim.finki.wp.web.CrudResource;

import mk.ukim.finki.wp.web.util.RequestProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/data/rest/invoices")
public class InvoiceResource extends
        CrudResource<Invoice, InvoiceService> {

    @Autowired
    private InvoiceService service;

    @Autowired
    private InvoiceItemService invoiceItemService;

    @Autowired
    private UserService userService;

    @Override
    public InvoiceService getService() {
        return service;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public Response create(@RequestBody Invoice entity, HttpServletRequest request, HttpServletResponse response) {
        String username = RequestProcessor.getUsername();
        User user = userService.findByUsername(username);
        Response res = new Response();

        if (user != null) {
            Company company = user.getCompany();
            List<Invoice> invoices = service.findByCompany(company);

            if (invoices.size() < company.getSubscription().getInvoicesLimit()) {
                entity.setCompany(company);
                saveInvoiceItems(entity.getInvoiceItems());
                getService().save(entity);

                response.setStatus(HttpServletResponse.SC_CREATED);
                res.setMessage("Successfully created");
                res.setSuccess(true);
                res.setData(entity);
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
                res.setMessage("Exceeded the maximum allowable limit for invoices");
                res.setSuccess(false);
                res.setData(null);
            }
        }

        return res;
    }

    private void saveInvoiceItems(List<InvoiceItem> invoiceItems) {
        for(InvoiceItem invoiceItem : invoiceItems) {
            invoiceItemService.save(invoiceItem);
        }
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Invoice> getAll() {
        String username = RequestProcessor.getUsername();
        User user = userService.findByUsername(username);

        if (user.getCompany() != null) {
            return service.findByCompany(user.getCompany());
        }

        return null;
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Invoice get(@PathVariable Long id, HttpServletRequest request,
                 HttpServletResponse response) {
        String username = RequestProcessor.getUsername();
        User user = userService.findByUsername(username);

        if (user.getCompany() != null) {
            Invoice entity = getService().findOne(id);

            if (entity == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }

            if(entity.getCompany().getId() == user.getCompany().getId()) {
                return entity;
            }
        }

        return null;
    }
}
