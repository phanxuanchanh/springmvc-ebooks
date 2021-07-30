package SpringMVC.AdminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import SpringMVC.AdminService.CategoryServiceImpl;

@Controller
public class CategoryManagementController {
	@Autowired
	CategoryServiceImpl categoryServiceImpl;

	@RequestMapping(value = "quan-tri/danh-sach-the-loai", method = RequestMethod.GET)
	public ModelAndView CategoryList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/category-list");
		modelAndView.addObject("categories", categoryServiceImpl.GetCategories());
		return modelAndView;
	}
	
	@RequestMapping(value = "quan-tri/chi-tiet-the-loai/{id}", method = RequestMethod.GET)
	public ModelAndView CategoryDetail(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/category-detail");
		modelAndView.addObject("category",categoryServiceImpl.GetCategory(id));
		return modelAndView;
	}
}
