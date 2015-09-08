package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.Category;
import mk.ukim.finki.wp.model.Company;
import mk.ukim.finki.wp.model.Item;

import java.util.List;

public interface ItemService extends BaseEntityCrudService<Item> {

    List<Item> findByCategoryId(Long id);

    List<Item> findByCategory(Category category);

    List<Item> findByCompany(Company company);
}
