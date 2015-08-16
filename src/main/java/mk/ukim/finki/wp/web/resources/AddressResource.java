package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.Address;
import mk.ukim.finki.wp.service.AddressService;
import mk.ukim.finki.wp.web.CrudResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/data/rest/addresses")
public class AddressResource extends
        CrudResource<Address, AddressService> {

    @Autowired
    private AddressService service;

    @Override
    public AddressService getService() {
        return service;
    }

}
