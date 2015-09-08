package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.Company;
import mk.ukim.finki.wp.model.Item;
import mk.ukim.finki.wp.model.User;
import mk.ukim.finki.wp.service.ItemService;
import mk.ukim.finki.wp.service.UserService;
import mk.ukim.finki.wp.web.CrudResource;
import mk.ukim.finki.wp.web.util.RequestProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("api/data/rest/items")
public class ItemResource extends CrudResource<Item, ItemService> {

    @Autowired
    private ItemService service;

    @Autowired
    private UserService userService;

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

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Item> getAll() {
        String username = RequestProcessor.getUsername();
        User user = userService.findByUsername(username);

        if (user != null) {
            return service.findByCompany(user.getCompany());
        }

        return null;
    }

    @Override
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public Item create(@RequestBody Item entity, HttpServletRequest request,
                       HttpServletResponse response) {

        String username = RequestProcessor.getUsername();
        User user = userService.findByUsername(username);
        if (user != null) {
            Company company = user.getCompany();
            List<Item> items = service.findByCompany(company);

            if (items.size() < company.getSubscription().getItemsLimit()) {
                entity.setCompany(company);
                getService().save(entity);
                System.out.println("Created Item from ItemResource");
                System.out.printf("Number of items = %d\n", items.size());
                return entity;
            } else {
                System.out.printf("ERROR! Number of items = %d\n", items.size());
                System.out.printf("Limit of items = %d\n", company.getSubscription().getItemsLimit());
            }
        }

        return null;
    }
}
