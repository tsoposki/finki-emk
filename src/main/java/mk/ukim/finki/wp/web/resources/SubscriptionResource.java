package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.Subscription;
import mk.ukim.finki.wp.service.SubscriptionService;
import mk.ukim.finki.wp.web.CrudResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/subscription")
public class SubscriptionResource extends CrudResource<Subscription, SubscriptionService> {

    @Autowired
    private SubscriptionService service;

    @Override
    public SubscriptionService getService() {
        return service;
    }
}
