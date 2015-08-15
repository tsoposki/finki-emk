package mk.ukim.finki.wp.service.impl;

import java.util.List;

import mk.ukim.finki.wp.model.Category;
import mk.ukim.finki.wp.model.Item;
import mk.ukim.finki.wp.repository.ItemRepository;

import mk.ukim.finki.wp.service.ItemService;
import org.hibernate.SessionFactory;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.hibernate.search.jpa.Search;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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
}
