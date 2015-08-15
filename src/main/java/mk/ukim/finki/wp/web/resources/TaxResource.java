package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.Item;
import mk.ukim.finki.wp.model.Tax;
import mk.ukim.finki.wp.service.ItemService;
import mk.ukim.finki.wp.service.TaxService;
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
@RequestMapping("api/data/rest/taxes")
public class TaxResource extends CrudResource<Tax, TaxService> {

    @Autowired
    private TaxService service;

    @PersistenceContext
    private EntityManager em;

    @Override
    public TaxService getService() {
        return service;
    }


}
