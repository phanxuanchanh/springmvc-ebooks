package SpringMVC.AdminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import SpringMVC.AdminService.CategoryServiceImpl;

@Controller
public class GeneralController {
	@Autowired
	CategoryServiceImpl categoryServiceImpl;

	@RequestMapping(value = "quan-tri/overview", method = RequestMethod.GET)
	public ModelAndView Overview() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/index");
		return modelAndView;
	}
}
