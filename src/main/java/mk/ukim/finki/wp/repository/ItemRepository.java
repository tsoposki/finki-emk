package mk.ukim.finki.wp.repository;
import mk.ukim.finki.wp.model.Category;
import mk.ukim.finki.wp.model.Item;

import java.util.List;

/**
 * Created by Trajche on 8/15/2015.
 */
public interface ItemRepository extends JpaSpecificationRepository<Item> {
    List<Item> findByCategoryId(Long id);
    List<Item> findByCategory(Category category);
}
