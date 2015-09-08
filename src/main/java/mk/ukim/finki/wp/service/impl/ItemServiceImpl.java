package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Category;
import mk.ukim.finki.wp.model.Company;
import mk.ukim.finki.wp.model.Item;
import mk.ukim.finki.wp.repository.ItemRepository;
import mk.ukim.finki.wp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl extends
        BaseEntityCrudServiceImpl<Item, ItemRepository> implements
        ItemService {

    @Autowired
    private ItemRepository repository;

    @Override
    protected ItemRepository getRepository() {
        return repository;
    }

    @Override
    public List<Item> findByCategoryId(Long id) {
        return repository.findByCategoryId(id);
    }

    @Override
    public List<Item> findByCategory(Category category) {
        return repository.findByCategory(category);
    }

    @Override
    public List<Item> findByCompany(Company company) {
        return getRepository().findByCompany(company);
    }
}
