package SpringMVC.AdminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import SpringMVC.AdminService.CategoryServiceImpl;
import SpringMVC.Entity.Category;
import SpringMVC.Validator.CategoryValidator;

@Controller
public class CategoryManagementController {
	@Autowired
	CategoryServiceImpl categoryServiceImpl;

	@RequestMapping(value = { "quan-tri/danh-sach-the-loai", "quan-tri/danh-sach-the-loai/{message}" }, method = RequestMethod.GET)
	public ModelAndView CategoryList(@PathVariable(required = false) String message) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/category-list");
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
	public ModelAndView CategoryDetail(@PathVariable int id) {
		if (id <= 0)
			return new ModelAndView("redirect:/quan-tri/danh-sach-the-loai");

		Category category = categoryServiceImpl.GetCategory(id);
		if (category == null)
			return new ModelAndView("redirect:/quan-tri/danh-sach-the-loai");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/category-detail");
		modelAndView.addObject("category", category);
		return modelAndView;
	}

	@RequestMapping(value = {"quan-tri/tao-moi-the-loai", "quan-tri/tao-moi-the-loai/{message}"}, method = RequestMethod.GET)
	public ModelAndView CreateCategory(@PathVariable(required = false) String message) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/create-category");
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
	public ModelAndView CreateCategory(@ModelAttribute("category") Category category, BindingResult bindingResult, CategoryValidator categoryValidator) {
		categoryValidator.validate(category, bindingResult);
		if (bindingResult.hasErrors())
			return new ModelAndView("admin/create-category", "category", category);

		if(categoryServiceImpl.CreateCategory(category))
			return new ModelAndView("redirect:/quan-tri/tao-moi-the-loai/add-success");
		
		return new ModelAndView("redirect:/quan-tri/tao-moi-the-loai/add-failed");
	}

	@RequestMapping(value = {"quan-tri/chinh-sua-the-loai/{id}", "quan-tri/chinh-sua-the-loai/{id}/{message}"}, method = RequestMethod.GET)
	public ModelAndView UpdateCategory(@PathVariable int id, @PathVariable(required = false) String message) {
		if (id <= 0)
			return new ModelAndView("redirect:/quan-tri/danh-sach-the-loai");

		Category category = categoryServiceImpl.GetCategory(id);
		if (category == null)
			return new ModelAndView("redirect:/quan-tri/danh-sach-the-loai");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/update-category");
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
	public ModelAndView UpdateCategory(@ModelAttribute("category") Category category, BindingResult bindingResult, CategoryValidator categoryValidator) {
		categoryValidator.validate(category, bindingResult);
		if (bindingResult.hasErrors())
			return new ModelAndView("admin/update-category", "category", category);

		if(categoryServiceImpl.UpdateCategory(category))
			return new ModelAndView("redirect:/quan-tri/chinh-sua-the-loai/{id}/edit-success");
		
		return new ModelAndView("redirect:/quan-tri/chinh-sua-the-loai/{id}/edit-failed");
	}

	@RequestMapping(value = "quan-tri/xoa-the-loai", method = RequestMethod.POST)
	public ModelAndView DeleteCategory(@RequestParam(value = "id", required = true) int id) {
		if(id <= 0)
			return new ModelAndView("redirect:/quan-tri/danh-sach-the-loai/delete-failed");
		
		if(categoryServiceImpl.DeleteCategory(id))
			return new ModelAndView("redirect:/quan-tri/danh-sach-the-loai/delete-success");
		
		return new ModelAndView("redirect:/quan-tri/danh-sach-the-loai/delete-failed");
	}
}
