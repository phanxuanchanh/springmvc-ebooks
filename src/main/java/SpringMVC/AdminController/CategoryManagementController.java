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

import SpringMVC.Entity.Category;
import SpringMVC.Service.CategoryServiceImpl;
import SpringMVC.Validator.CategoryValidator;

@Controller
public class CategoryManagementController {
	@Autowired
	CategoryServiceImpl categoryServiceImpl;

	@RequestMapping(value = { "quan-tri/danh-sach-the-loai", "quan-tri/danh-sach-the-loai/{message}" }, method = RequestMethod.GET)
	public ModelAndView CategoryList(HttpSession httpSession, @PathVariable(required = false) String message) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/category-list");
		String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
		modelAndView.addObject("username", username);
		modelAndView.addObject("categories", categoryServiceImpl.GetCategories());
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

	@RequestMapping(value = "quan-tri/chi-tiet-the-loai/{id}", method = RequestMethod.GET)
	public ModelAndView CategoryDetail(HttpSession httpSession, @PathVariable int id) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		if (id <= 0)
			return new ModelAndView("redirect:/quan-tri/danh-sach-the-loai");

		Category category = categoryServiceImpl.GetCategory(id);
		if (category == null)
			return new ModelAndView("redirect:/quan-tri/danh-sach-the-loai");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/category-detail");
		String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
		modelAndView.addObject("username", username);
		modelAndView.addObject("category", category);
		return modelAndView;
	}

	@RequestMapping(value = {"quan-tri/tao-moi-the-loai", "quan-tri/tao-moi-the-loai/{message}"}, method = RequestMethod.GET)
	public ModelAndView CreateCategory(HttpSession httpSession, @PathVariable(required = false) String message) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/create-category");
		String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
		modelAndView.addObject("username", username);
		modelAndView.addObject("category", new Category());
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

	@RequestMapping(value = "quan-tri/tao-moi-the-loai", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public ModelAndView CreateCategory(HttpSession httpSession, @ModelAttribute("category") Category category, BindingResult bindingResult, CategoryValidator categoryValidator) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		categoryValidator.validate(category, bindingResult);
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/create-category");
			String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
			modelAndView.addObject("username", username);
			modelAndView.addObject("category", category);
			return modelAndView;
		}

		if(categoryServiceImpl.CreateCategory(category))
			return new ModelAndView("redirect:/quan-tri/tao-moi-the-loai/add-success");
		
		return new ModelAndView("redirect:/quan-tri/tao-moi-the-loai/add-failed");
	}

	@RequestMapping(value = {"quan-tri/chinh-sua-the-loai/{id}", "quan-tri/chinh-sua-the-loai/{id}/{message}"}, method = RequestMethod.GET)
	public ModelAndView UpdateCategory(HttpSession httpSession, @PathVariable int id, @PathVariable(required = false) String message) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		if (id <= 0)
			return new ModelAndView("redirect:/quan-tri/danh-sach-the-loai");

		Category category = categoryServiceImpl.GetCategory(id);
		if (category == null)
			return new ModelAndView("redirect:/quan-tri/danh-sach-the-loai");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/update-category");
		String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
		modelAndView.addObject("username", username);
		modelAndView.addObject("category", category);
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
	
	@RequestMapping(value = "quan-tri/chinh-sua-the-loai/{id}", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public ModelAndView UpdateCategory(HttpSession httpSession, @ModelAttribute("category") Category category, BindingResult bindingResult, CategoryValidator categoryValidator) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		categoryValidator.validate(category, bindingResult);
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/update-category");
			String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
			modelAndView.addObject("username", username);
			modelAndView.addObject("category", category);
			return modelAndView;
		}

		if(categoryServiceImpl.UpdateCategory(category))
			return new ModelAndView("redirect:/quan-tri/chinh-sua-the-loai/{id}/edit-success");
		
		return new ModelAndView("redirect:/quan-tri/chinh-sua-the-loai/{id}/edit-failed");
	}

	@RequestMapping(value = "quan-tri/xoa-the-loai", method = RequestMethod.POST)
	public ModelAndView DeleteCategory(HttpSession httpSession, @RequestParam(value = "id", required = true) int id) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		if(id <= 0)
			return new ModelAndView("redirect:/quan-tri/danh-sach-the-loai/delete-failed");
		
		if(categoryServiceImpl.DeleteCategory(id))
			return new ModelAndView("redirect:/quan-tri/danh-sach-the-loai/delete-success");
		
		return new ModelAndView("redirect:/quan-tri/danh-sach-the-loai/delete-failed");
	}
}
