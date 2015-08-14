package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.Category;
import mk.ukim.finki.wp.service.CategoryService;
import mk.ukim.finki.wp.web.CrudResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/data/rest/categories")
public class CategoryResource extends
		CrudResource<Category, CategoryService> {

	@Autowired
	private CategoryService service;

	@Override
	public CategoryService getService() {
		return service;
	}

}
