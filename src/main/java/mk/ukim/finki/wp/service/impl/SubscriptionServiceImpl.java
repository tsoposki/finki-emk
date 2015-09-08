package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Subscription;
import mk.ukim.finki.wp.repository.SubscriptionRepository;
import mk.ukim.finki.wp.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl extends BaseEntityCrudServiceImpl<Subscription, SubscriptionRepository> implements SubscriptionService {

    @Autowired
    private SubscriptionRepository repository;

    @Override
    protected SubscriptionRepository getRepository() {
        return repository;
    }


}
