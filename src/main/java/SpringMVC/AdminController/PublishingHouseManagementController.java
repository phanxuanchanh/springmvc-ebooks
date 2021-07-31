package SpringMVC.AdminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import SpringMVC.AdminService.PublishingHouseServiceImpl;
import SpringMVC.Entity.PublishingHouse;

@Controller
public class PublishingHouseManagementController {
	@Autowired
	private PublishingHouseServiceImpl publishingHouseServiceImpl;
	
	@RequestMapping(value = "quan-tri/danh-sach-nha-xuat-ban", method = RequestMethod.GET)
	public ModelAndView PublishingHouseList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/publishing-house-list");
		modelAndView.addObject("publishingHouses", publishingHouseServiceImpl.GetPublishingHouses());
		return modelAndView;
	}
	
	@RequestMapping(value = "quan-tri/chi-tiet-nha-xuat-ban/{id}", method = RequestMethod.GET)
	public ModelAndView PublishingHouseDetail(@PathVariable long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/publishing-house-detail");
		modelAndView.addObject("publishingHouse", publishingHouseServiceImpl.GetPublishingHouse(id));
		return modelAndView;
	}
	
	@RequestMapping(value = "quan-tri/tao-moi-nha-xuat-ban", method = RequestMethod.GET)
	public ModelAndView CreatePublishingHouse() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/create-publishing-house");
		modelAndView.addObject("publishingHouse", new PublishingHouse());
		return modelAndView;
	}
	
	@RequestMapping(value = "quan-tri/cap-nhat-nha-xuat-ban/{id}", method = RequestMethod.GET)
	public ModelAndView UpdatePublishingHouse(long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/update-publishing-house");
		modelAndView.addObject("publishingHouse", publishingHouseServiceImpl.GetPublishingHouse(id));
		return modelAndView;
	}
}
