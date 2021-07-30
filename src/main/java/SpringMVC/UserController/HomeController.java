package SpringMVC.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import SpringMVC.DAO.CategoryDAO;

@Controller
public class HomeController {
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = {"/", "/trang-chu"}, method = RequestMethod.GET)
	public ModelAndView Index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/index");
		return modelAndView;
	}
	
	@RequestMapping(value = {"/quan-tri/overview"}, method = RequestMethod.GET)
	public ModelAndView Admin() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/index");
		modelAndView.addObject("categories", categoryDAO.GetCategories());
		return modelAndView;
	}
}
