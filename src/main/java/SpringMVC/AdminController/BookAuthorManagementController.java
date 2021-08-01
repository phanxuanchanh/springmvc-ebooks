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

import SpringMVC.AdminService.BookAuthorServiceImpl;
import SpringMVC.Entity.BookAuthor;
import SpringMVC.Validator.BookAuthorValidator;

@Controller
public class BookAuthorManagementController {
	@Autowired
	private BookAuthorServiceImpl bookAuthorServiceImpl;
	
	@RequestMapping(value = {"quan-tri/danh-sach-tac-gia","quan-tri/danh-sach-tac-gia/{message}"}, method = RequestMethod.GET)
	public ModelAndView BookAuthorList(@PathVariable(required = false) String message) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/book-author-list");
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
	public ModelAndView BookAuthorDetail(@PathVariable long id) {
		if (id <= 0)
			return new ModelAndView("redirect:/quan-tri/danh-sach-tac-gia");
		
		BookAuthor bookAuthor = bookAuthorServiceImpl.GetBookAuthor(id);
		if (bookAuthor == null)
			return new ModelAndView("redirect:/quan-tri/danh-sach-tac-gia");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/book-author-detail");
		modelAndView.addObject("bookAuthor", bookAuthorServiceImpl.GetBookAuthor(id));
		return modelAndView;
	}
	
	@RequestMapping(value = {"quan-tri/tao-moi-tac-gia", "quan-tri/tao-moi-tac-gia/{message}"}, method = RequestMethod.GET)
	public ModelAndView CreateBookAuthor(@PathVariable(required = false) String message) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/create-book-author");
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
	public ModelAndView CreateBookAuthor(@ModelAttribute("bookAuthor") BookAuthor bookAuthor, BindingResult bindingResult, BookAuthorValidator bookAuthorValidator) {
		bookAuthorValidator.validate(bookAuthor, bindingResult);
		if (bindingResult.hasErrors())
			return new ModelAndView("admin/create-book-author", "bookAuthor", bookAuthor);

		if(bookAuthorServiceImpl.CreateBookAuthor(bookAuthor))
			return new ModelAndView("redirect:/quan-tri/tao-moi-tac-gia/add-success");
		
		return new ModelAndView("redirect:/quan-tri/tao-moi-tac-gia/add-failed");
	}
	
	@RequestMapping(value = {"quan-tri/chinh-sua-tac-gia/{id}", "quan-tri/chinh-sua-tac-gia/{id}/{message}"}, method = RequestMethod.GET)
	public ModelAndView UpdateBookAuthor(@PathVariable long id, @PathVariable(required = false) String message) {
		if (id <= 0)
			return new ModelAndView("redirect:/quan-tri/danh-sach-tac-gia");

		BookAuthor bookAuthor = bookAuthorServiceImpl.GetBookAuthor(id);
		if (bookAuthor == null)
			return new ModelAndView("redirect:/quan-tri/danh-sach-tac-gia");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/update-book-author");
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
	public ModelAndView UpdateBookAuthor(@ModelAttribute("bookAuthor") BookAuthor bookAuthor, BindingResult bindingResult, BookAuthorValidator bookAuthorValidator) {
		bookAuthorValidator.validate(bookAuthor, bindingResult);
		if (bindingResult.hasErrors())
			return new ModelAndView("admin/update-book-author", "bookAuthor", bookAuthor);

		if(bookAuthorServiceImpl.UpdateBookAuthor(bookAuthor))
			return new ModelAndView("redirect:/quan-tri/chinh-sua-tac-gia/{id}/edit-success");
		
		return new ModelAndView("redirect:/quan-tri/chinh-sua-tac-gia/{id}/edit-failed");
	}

	@RequestMapping(value = "quan-tri/xoa-tac-gia", method = RequestMethod.POST)
	public ModelAndView DeleteBookAuthor(@RequestParam(value = "id", required = true) long id) {
		if(id <= 0)
			return new ModelAndView("redirect:/quan-tri/danh-sach-tac-gia/delete-failed");
		
		if(bookAuthorServiceImpl.DeleteBookAuthor(id))
			return new ModelAndView("redirect:/quan-tri/danh-sach-tac-gia/delete-success");
		
		return new ModelAndView("redirect:/quan-tri/danh-sach-tac-gia/delete-failed");
	}
}
