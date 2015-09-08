package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.OrderItem;
import mk.ukim.finki.wp.service.OrderItemService;
import mk.ukim.finki.wp.web.CrudResource;
import mk.ukim.finki.wp.web.util.RequestProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("api/data/rest/order_items")
public class OrderItemResource extends
        CrudResource<OrderItem, OrderItemService> {

  @Autowired
  private OrderItemService service;

  @Override
  public OrderItemService getService() {
    return service;
  }

  @RequestMapping(method = RequestMethod.POST, produces = "application/json")
  public OrderItem create(@RequestBody OrderItem entity, HttpServletRequest request,
                          HttpServletResponse response) {
    entity.setUserToken(RequestProcessor.tempToken(request));
    getService().save(entity);
    return entity;
  }

  @RequestMapping(value = "/my", method = RequestMethod.GET, produces = "application/json")
  public List<OrderItem> myOrderItems(HttpServletRequest request) {
    return service.findByUserToken(RequestProcessor.tempToken(request));
  }

  @RequestMapping(value = "/check_pay", method = RequestMethod.POST, produces = "application/json")
  public void pay(HttpServletRequest request) {
    System.out.println("pay invoked");
  }


}
