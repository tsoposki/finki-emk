package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.*;
import mk.ukim.finki.wp.service.InvoiceItemService;
import mk.ukim.finki.wp.service.InvoiceService;
import mk.ukim.finki.wp.service.ItemService;
import mk.ukim.finki.wp.service.UserService;
import mk.ukim.finki.wp.web.CrudResource;

import mk.ukim.finki.wp.web.util.RequestProcessor;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public Invoice create(@RequestBody Invoice entity, HttpServletRequest request, HttpServletResponse response) {

        System.out.println(entity);
        String username = RequestProcessor.getUsername();
        User user = userService.findByUsername(username);
        if (user != null) {
            Company company = user.getCompany();
            List<Invoice> invoices = service.findByCompany(company);

            if (invoices.size() < company.getSubscription().getInvoicesLimit()) {
                entity.setCompany(company);
                saveInvoiceItems(entity.getInvoiceItems());
                getService().save(entity);
                System.out.println("Created Invoice from InvoiceResource");
                System.out.printf("Number of partners = %d\n", invoices.size());
                return entity;
            } else {
                System.out.printf("ERROR! Number of invoices = %d\n", invoices.size());
                System.out.printf("Limit of invoices = %d\n", company.getSubscription().getInvoicesLimit());
            }
        }

        return null;
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

        System.out.println(username);
        System.out.println(user.getCompany().getId());

        if (user.getCompany() != null) {
            System.out.println("getting invoices");
            return service.findByCompany(user.getCompany());
        }

        return null;
    }
}
