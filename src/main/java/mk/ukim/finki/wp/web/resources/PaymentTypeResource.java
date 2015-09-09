package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.PaymentType;
import mk.ukim.finki.wp.service.PaymentTypeService;
import mk.ukim.finki.wp.web.CrudResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Trajche on 09.09.2015.
 */

@RestController
@RequestMapping("api/data/rest/payment_types")
public class PaymentTypeResource extends CrudResource<PaymentType, PaymentTypeService>{

    @Autowired
    private PaymentTypeService service;

    @Override
    public PaymentTypeService getService() {
        return service;
    }
}
