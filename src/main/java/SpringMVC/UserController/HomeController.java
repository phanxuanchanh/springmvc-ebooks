package SpringMVC.UserController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
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
		return modelAndView;
	}
}
