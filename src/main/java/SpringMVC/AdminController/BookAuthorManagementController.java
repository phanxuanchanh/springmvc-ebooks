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

import SpringMVC.Entity.BookAuthor;
import SpringMVC.Service.BookAuthorServiceImpl;
import SpringMVC.Validator.BookAuthorValidator;

@Controller
public class BookAuthorManagementController {
	@Autowired
	private BookAuthorServiceImpl bookAuthorServiceImpl;
	
	@RequestMapping(value = {"quan-tri/danh-sach-tac-gia","quan-tri/danh-sach-tac-gia/{message}"}, method = RequestMethod.GET)
	public ModelAndView BookAuthorList(HttpSession httpSession, @PathVariable(required = false) String message) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/book-author-list");
		String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
		modelAndView.addObject("username", username);
		modelAndView.addObject("bookAuthors", bookAuthorServiceImpl.GetBookAuthors());
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
	
	@RequestMapping(value = "quan-tri/chi-tiet-tac-gia/{id}", method = RequestMethod.GET)
	public ModelAndView BookAuthorDetail(HttpSession httpSession, @PathVariable long id) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		if (id <= 0)
			return new ModelAndView("redirect:/quan-tri/danh-sach-tac-gia");
		
		BookAuthor bookAuthor = bookAuthorServiceImpl.GetBookAuthor(id);
		if (bookAuthor == null)
			return new ModelAndView("redirect:/quan-tri/danh-sach-tac-gia");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/book-author-detail");
		String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
		modelAndView.addObject("username", username);
		modelAndView.addObject("bookAuthor", bookAuthor);
		return modelAndView;
	}
	
	@RequestMapping(value = {"quan-tri/tao-moi-tac-gia", "quan-tri/tao-moi-tac-gia/{message}"}, method = RequestMethod.GET)
	public ModelAndView CreateBookAuthor(HttpSession httpSession, @PathVariable(required = false) String message) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/create-book-author");
		String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
		modelAndView.addObject("username", username);
		modelAndView.addObject("bookAuthor", new BookAuthor());
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
	
	@RequestMapping(value = "quan-tri/tao-moi-tac-gia", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public ModelAndView CreateBookAuthor(HttpSession httpSession, @ModelAttribute("bookAuthor") BookAuthor bookAuthor, BindingResult bindingResult, BookAuthorValidator bookAuthorValidator) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		bookAuthorValidator.validate(bookAuthor, bindingResult);
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/create-book-author");
			String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
			modelAndView.addObject("username", username);
			modelAndView.addObject("bookAuthor", bookAuthor);
			return modelAndView;
		}

		if(bookAuthorServiceImpl.CreateBookAuthor(bookAuthor))
			return new ModelAndView("redirect:/quan-tri/tao-moi-tac-gia/add-success");
		
		return new ModelAndView("redirect:/quan-tri/tao-moi-tac-gia/add-failed");
	}
	
	@RequestMapping(value = {"quan-tri/chinh-sua-tac-gia/{id}", "quan-tri/chinh-sua-tac-gia/{id}/{message}"}, method = RequestMethod.GET)
	public ModelAndView UpdateBookAuthor(HttpSession httpSession, @PathVariable long id, @PathVariable(required = false) String message) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		if (id <= 0)
			return new ModelAndView("redirect:/quan-tri/danh-sach-tac-gia");

		BookAuthor bookAuthor = bookAuthorServiceImpl.GetBookAuthor(id);
		if (bookAuthor == null)
			return new ModelAndView("redirect:/quan-tri/danh-sach-tac-gia");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/update-book-author");
		String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
		modelAndView.addObject("username", username);
		modelAndView.addObject("bookAuthor", bookAuthor);
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
	
	@RequestMapping(value = "quan-tri/chinh-sua-tac-gia/{id}", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public ModelAndView UpdateBookAuthor(HttpSession httpSession, @ModelAttribute("bookAuthor") BookAuthor bookAuthor, BindingResult bindingResult, BookAuthorValidator bookAuthorValidator) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		bookAuthorValidator.validate(bookAuthor, bindingResult);
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/update-book-author");
			String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
			modelAndView.addObject("username", username);
			modelAndView.addObject("bookAuthor", bookAuthor);
			return modelAndView;
		}

		if(bookAuthorServiceImpl.UpdateBookAuthor(bookAuthor))
			return new ModelAndView("redirect:/quan-tri/chinh-sua-tac-gia/{id}/edit-success");
		
		return new ModelAndView("redirect:/quan-tri/chinh-sua-tac-gia/{id}/edit-failed");
	}

	@RequestMapping(value = "quan-tri/xoa-tac-gia", method = RequestMethod.POST)
	public ModelAndView DeleteBookAuthor(HttpSession httpSession, @RequestParam(value = "id", required = true) long id) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		if(id <= 0)
			return new ModelAndView("redirect:/quan-tri/danh-sach-tac-gia");
		
		if(bookAuthorServiceImpl.DeleteBookAuthor(id))
			return new ModelAndView("redirect:/quan-tri/danh-sach-tac-gia/delete-success");
		
		return new ModelAndView("redirect:/quan-tri/danh-sach-tac-gia/delete-failed");
	}
}
