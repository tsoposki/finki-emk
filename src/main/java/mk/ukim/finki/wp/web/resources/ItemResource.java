package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.Book;
import mk.ukim.finki.wp.model.Item;
import mk.ukim.finki.wp.service.ItemService;
import mk.ukim.finki.wp.web.CrudResource;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("api/data/rest/items")
public class ItemResource extends CrudResource<Item, ItemService> {

    @Autowired
    private ItemService service;

    @PersistenceContext
    private EntityManager em;

    @Override
    public ItemService getService() {
        return service;
    }

    @RequestMapping(value = "/by_category/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Item> getByTypeId(@PathVariable Long id,
                                      HttpServletRequest request, HttpSession session) {

        if(id>= 0) {
            return getService().findByCategoryId(id);
        }
        return getService().findAll();

    }

}
