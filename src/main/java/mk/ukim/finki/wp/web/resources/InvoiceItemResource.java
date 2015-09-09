package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.InvoiceItem;
import mk.ukim.finki.wp.service.InvoiceItemService;
import mk.ukim.finki.wp.web.CrudResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Trajche on 08.09.2015.
 */

@RestController
@RequestMapping("api/data/rest/invoice_items")
public class InvoiceItemResource extends CrudResource<InvoiceItem, InvoiceItemService>{

    @Autowired
    private InvoiceItemService service;

    @Override
    public InvoiceItemService getService() {
        return service;
    }

//    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
//    public List<InvoiceItem> create(@RequestBody @Valid List<InvoiceItem> invoiceItems, HttpServletRequest request,
//                    HttpServletResponse response) {
//        for(InvoiceItem item : invoiceItems) {
//            service.save(item);
//        }
//
//        return invoiceItems;
//    }
}
