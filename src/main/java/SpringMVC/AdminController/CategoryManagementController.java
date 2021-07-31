package SpringMVC.AdminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import SpringMVC.AdminService.CategoryServiceImpl;
import SpringMVC.Entity.Category;

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
		modelAndView.addObject("category", categoryServiceImpl.GetCategory(id));
		return modelAndView;
	}

	@RequestMapping(value = "quan-tri/tao-moi-the-loai", method = RequestMethod.GET)
	public ModelAndView CreateCategory() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/create-category");
		modelAndView.addObject("category", new Category());
		return modelAndView;
	}

	@RequestMapping(value = "quan-tri/tao-moi-the-loai", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public ModelAndView CreateCategory(@ModelAttribute("category") Category category) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/create-category");
		categoryServiceImpl.CreateCategory(category);
		modelAndView.addObject("category", new Category());
		return modelAndView;
	}

	@RequestMapping(value = "quan-tri/cap-nhat-the-loai/{id}", method = RequestMethod.GET)
	public ModelAndView UpdateCategory(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/update-category");
		return modelAndView;
	}

	@RequestMapping(value = "quan-tri/xoa-the-loai/{id}", method = RequestMethod.GET)
	public ModelAndView DeleteCategory(int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/delete-category");
		return modelAndView;
	}
}
