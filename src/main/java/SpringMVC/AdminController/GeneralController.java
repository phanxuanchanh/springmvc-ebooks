package SpringMVC.AdminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import SpringMVC.AdminService.GeneralServiceImpl;

@Controller
public class GeneralController {
	@Autowired
	private GeneralServiceImpl generalServiceImpl;

	@RequestMapping(value = "quan-tri/tong-quan", method = RequestMethod.GET)
	public ModelAndView Overview() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/overview");
		modelAndView.addObject("analyst", generalServiceImpl.GetAnalyst());
		return modelAndView;
	}
}
