package SpringMVC.AdminController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import SpringMVC.Entity.PublishingHouse;
import SpringMVC.Service.PublishingHouseServiceImpl;
import SpringMVC.Validator.PublishingHouseValidator;

@Controller
public class PublishingHouseManagementController {
	@Autowired
	private PublishingHouseServiceImpl publishingHouseServiceImpl;
	
	@RequestMapping(value = {"quan-tri/danh-sach-nha-xuat-ban","quan-tri/danh-sach-nha-xuat-ban/{message}"}, method = RequestMethod.GET)
	public ModelAndView PublishingHouseList(HttpSession httpSession, @PathVariable(required = false) String message) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/publishing-house-list");
		String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
		modelAndView.addObject("username", username);
		modelAndView.addObject("publishingHouses", publishingHouseServiceImpl.GetPublishingHouses());
		if(message != null) {
			if(message.equals("delete-success"))
				modelAndView.addObject("state", "Xóa thành công");
			else if(message.equals("delete-failed"))
				modelAndView.addObject("state", "Xóa thất bại");
			else 
				modelAndView.addObject("state", "Không xác định được nội dung thông báo");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "quan-tri/chi-tiet-nha-xuat-ban/{id}", method = RequestMethod.GET)
	public ModelAndView PublishingHouseDetail(HttpSession httpSession, @PathVariable long id) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		if (id <= 0)
			return new ModelAndView("redirect:/quan-tri/danh-sach-nha-xuat-ban");
		
		PublishingHouse publishingHouse = publishingHouseServiceImpl.GetPublishingHouse(id);
		if (publishingHouse == null)
			return new ModelAndView("redirect:/quan-tri/danh-sach-nha-xuat-ban");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/publishing-house-detail");
		String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
		modelAndView.addObject("username", username);
		modelAndView.addObject("publishingHouse", publishingHouse);
		return modelAndView;
	}
	
	@RequestMapping(value = {"quan-tri/tao-moi-nha-xuat-ban", "quan-tri/tao-moi-nha-xuat-ban/{message}"}, method = RequestMethod.GET)
	public ModelAndView CreatePublishingHouse(HttpSession httpSession, @PathVariable(required = false) String message) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/create-publishing-house");
		String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
		modelAndView.addObject("username", username);
		modelAndView.addObject("publishingHouse", new PublishingHouse());
		if(message != null) {
			if(message.equals("add-success"))
				modelAndView.addObject("state", "Thêm thành công");
			else if(message.equals("add-failed"))
				modelAndView.addObject("state", "Thêm thất bại");
			else 
				modelAndView.addObject("state", "Không xác định được nội dung thông báo");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "quan-tri/tao-moi-nha-xuat-ban", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public ModelAndView CreatePublishingHouse(HttpSession httpSession, @ModelAttribute("publishingHouse") PublishingHouse publishingHouse, BindingResult bindingResult, PublishingHouseValidator publishingHouseValidator) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		publishingHouseValidator.validate(publishingHouse, bindingResult);
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/create-publishing-house");
			String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
			modelAndView.addObject("username", username);
			modelAndView.addObject("publishingHouse", publishingHouse);
			return modelAndView;
		}

		if(publishingHouseServiceImpl.CreatePublishingHouse(publishingHouse))
			return new ModelAndView("redirect:/quan-tri/tao-moi-nha-xuat-ban/add-success");
		
		return new ModelAndView("redirect:/quan-tri/tao-moi-nha-xuat-ban/add-failed");
	}
	
	@RequestMapping(value = {"quan-tri/chinh-sua-nha-xuat-ban/{id}", "quan-tri/chinh-sua-nha-xuat-ban/{id}/{message}"}, method = RequestMethod.GET)
	public ModelAndView UpdatePublishingHouse(HttpSession httpSession, @PathVariable long id, @PathVariable(required = false) String message) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		if (id <= 0)
			return new ModelAndView("redirect:/quan-tri/danh-sach-nha-xuat-ban");

		PublishingHouse publishingHouse = publishingHouseServiceImpl.GetPublishingHouse(id);
		if (publishingHouse == null)
			return new ModelAndView("redirect:/quan-tri/danh-sach-nha-xuat-ban");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/update-publishing-house");
		String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
		modelAndView.addObject("username", username);
		modelAndView.addObject("publishingHouse", publishingHouse);
		if(message != null) {
			if(message.equals("edit-success"))
				modelAndView.addObject("state", "Chỉnh sửa thành công");
			else if(message.equals("edit-failed"))
				modelAndView.addObject("state", "Chỉnh sửa thất bại");
			else 
				modelAndView.addObject("state", "Không xác định được nội dung thông báo");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "quan-tri/chinh-sua-nha-xuat-ban/{id}", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public ModelAndView UpdatePublishingHouse(HttpSession httpSession, @ModelAttribute("publishingHouse") PublishingHouse publishingHouse, BindingResult bindingResult, PublishingHouseValidator publishingHouseValidator) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		publishingHouseValidator.validate(publishingHouse, bindingResult);
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/update-publishing-house");
			String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
			modelAndView.addObject("username", username);
			modelAndView.addObject("publishingHouse", publishingHouse);
			return modelAndView;
		}

		if(publishingHouseServiceImpl.UpdatePublishingHouse(publishingHouse))
			return new ModelAndView("redirect:/quan-tri/chinh-sua-nha-xuat-ban/{id}/edit-success");
		
		return new ModelAndView("redirect:/quan-tri/chinh-sua-nha-xuat-ban/{id}/edit-failed");
	}

	@RequestMapping(value = "quan-tri/xoa-nha-xuat-ban", method = RequestMethod.POST)
	public ModelAndView DeletePublishingHouse(HttpSession httpSession, @RequestParam(value = "id", required = true) long id) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		if(id <= 0)
			return new ModelAndView("redirect:/quan-tri/danh-sach-nha-xuat-ban");
		
		if(publishingHouseServiceImpl.DeletePublishingHouse(id))
			return new ModelAndView("redirect:/quan-tri/danh-sach-nha-xuat-ban/delete-success");
		
		return new ModelAndView("redirect:/quan-tri/danh-sach-nha-xuat-ban/delete-failed");
	}
}
