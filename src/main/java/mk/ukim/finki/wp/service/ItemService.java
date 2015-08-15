package mk.ukim.finki.wp.service;

import java.util.List;

import mk.ukim.finki.wp.model.Category;
import mk.ukim.finki.wp.model.Item;

public interface ItemService extends BaseEntityCrudService<Item> {

    List<Item> findByCategoryId(Long id);

    List<Item> findByCategory(Category category);
}
