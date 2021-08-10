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

import SpringMVC.DTO.BookInfo;
import SpringMVC.DTO.ImageUpload;
import SpringMVC.Entity.AuthorContribute;
import SpringMVC.Entity.Book;
import SpringMVC.Service.BookAuthorServiceImpl;
import SpringMVC.Service.BookServiceImpl;
import SpringMVC.Service.CategoryServiceImpl;
import SpringMVC.Service.PublishingHouseServiceImpl;
import SpringMVC.Validator.AuthorContributeValidator;
import SpringMVC.Validator.BookValidator;
import SpringMVC.Validator.ImageUploadValidator;

@Controller
public class BookManagementController {
	@Autowired
	private BookServiceImpl bookServiceImpl;
	
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@Autowired
	private PublishingHouseServiceImpl publishingHouseServiceImpl;
	
	@Autowired
	private BookAuthorServiceImpl bookAuthorServiceImpl;
	
	@RequestMapping(value = {"quan-tri/danh-sach-sach","quan-tri/danh-sach-sach/{message}"}, method = RequestMethod.GET)
	public ModelAndView BookList(HttpSession httpSession, @PathVariable(required = false) String message) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/book-list");
		String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
		modelAndView.addObject("username", username);
		modelAndView.addObject("books", bookServiceImpl.GetBooks());
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
	
	@RequestMapping(value = "quan-tri/chi-tiet-sach/{id}", method = RequestMethod.GET)
	public ModelAndView BookDetail(HttpSession httpSession, @PathVariable long id) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		if (id <= 0)
			return new ModelAndView("redirect:/quan-tri/danh-sach-sach");
		
		BookInfo bookInfo = bookServiceImpl.GetBookInfo(id);
		if (bookInfo == null)
			return new ModelAndView("redirect:/quan-tri/danh-sach-sach");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/book-detail");
		String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
		modelAndView.addObject("username", username);
		modelAndView.addObject("bookInfo", bookInfo);
		return modelAndView;
	}
	
	@RequestMapping(value = {"quan-tri/tao-moi-sach", "quan-tri/tao-moi-sach/{message}"}, method = RequestMethod.GET)
	public ModelAndView CreateBook(HttpSession httpSession, @PathVariable(required = false) String message) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/create-book");
		String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
		modelAndView.addObject("username", username);
		modelAndView.addObject("book", new Book());
		modelAndView.addObject("categories", categoryServiceImpl.GetCategories());
		modelAndView.addObject("publishingHouses", publishingHouseServiceImpl.GetPublishingHouses());
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
	
	@RequestMapping(value = "quan-tri/tao-moi-sach", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public ModelAndView CreateBook(HttpSession httpSession, @ModelAttribute("book") Book book, BindingResult bindingResult, BookValidator bookValidator) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		bookValidator.validate(book, bindingResult);
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/create-book");
			String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
			modelAndView.addObject("username", username);
			modelAndView.addObject("book", book);
			return modelAndView;
		}

		if(bookServiceImpl.CreateBook(book))
			return new ModelAndView("redirect:/quan-tri/tao-moi-sach/add-success");
		
		return new ModelAndView("redirect:/quan-tri/tao-moi-sach/add-failed");
	}
	
	@RequestMapping(value = {"quan-tri/tac-gia-cua-sach/{id}","quan-tri/tac-gia-cua-sach/{id}/{message}"}, method = RequestMethod.GET)
	public ModelAndView EditBookAuthor(HttpSession httpSession, @PathVariable long id, @PathVariable(required = false) String message) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		if (id <= 0)
			return new ModelAndView("redirect:/quan-tri/danh-sach-sach");
		
		BookInfo bookInfo = bookServiceImpl.GetBookInfo(id);
		if (bookInfo == null)
			return new ModelAndView("redirect:/quan-tri/danh-sach-sach");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/edit-book-author");
		String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
		modelAndView.addObject("username", username);
		modelAndView.addObject("bookInfo", bookInfo);
		modelAndView.addObject("authorContribute", new AuthorContribute());
		modelAndView.addObject("bookAuthors", bookAuthorServiceImpl.GetBookAuthors());
		if(message != null) {
			if(message.equals("add-success"))
				modelAndView.addObject("state", "Thêm thành công");
			else if(message.equals("add-failed"))
				modelAndView.addObject("state", "Thêm thất bại");
			else if(message.equals("delete-success"))
				modelAndView.addObject("state", "Xóa thành công");
			else if(message.equals("delete-failed"))
				modelAndView.addObject("state", "Xóa thất bại");
			else 
				modelAndView.addObject("state", "Không xác định được nội dung thông báo");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "quan-tri/them-tac-gia-cua-sach", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public ModelAndView AddBookAuthor(HttpSession httpSession, @ModelAttribute("authorContribute") AuthorContribute authorContribute, BindingResult bindingResult,AuthorContributeValidator authorContributeValidator) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		authorContributeValidator.validate(authorContribute, bindingResult);
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/edit-book-author");
			String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
			modelAndView.addObject("username", username);
			modelAndView.addObject("bookInfo", bookServiceImpl.GetBookInfo(authorContribute.getBookId()));
			modelAndView.addObject("authorContribute", authorContribute);
			modelAndView.addObject("bookAuthors", bookAuthorServiceImpl.GetBookAuthors());
			return modelAndView;
		}

		if(bookServiceImpl.AddBookAuthor(authorContribute))
			return new ModelAndView("redirect:/quan-tri/tac-gia-cua-sach/" + authorContribute.getBookId() + "/add-success");
		
		return new ModelAndView("redirect:/quan-tri/tac-gia-cua-sach/" + authorContribute.getBookId() + "/add-failed");
	}	
	
	@RequestMapping(value = "quan-tri/xoa-tat-ca-tac-gia-cua-sach", method = RequestMethod.POST)
	public ModelAndView DeleteAllBookAuthor(HttpSession httpSession, @RequestParam(value = "id", required = true) long id) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		if(id <= 0)
			return new ModelAndView("redirect:/quan-tri/danh-sach-sach");
		
		if(bookServiceImpl.DeleteAllBookAuthor(id))
			return new ModelAndView("redirect:/quan-tri/tac-gia-cua-sach/" + id + "/delete-success");
		
		return new ModelAndView("redirect:/quan-tri/tac-gia-cua-sach/" + id + "/delete-failed");
	}
		
	@RequestMapping(value = {"quan-tri/hinh-anh-cua-sach/{id}", "quan-tri/hinh-anh-cua-sach/{id}/{message}"}, method = RequestMethod.GET)
	public ModelAndView EditImage(HttpSession httpSession, @PathVariable long id, @PathVariable(required = false) String message) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		if (id <= 0)
			return new ModelAndView("redirect:/quan-tri/danh-sach-sach");
		
		Book book = bookServiceImpl.GetBook(id);
		if (book == null)
			return new ModelAndView("redirect:/quan-tri/danh-sach-sach");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/edit-image");
		String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
		modelAndView.addObject("username", username);
		modelAndView.addObject("book", book);
		modelAndView.addObject("imageUpload", new ImageUpload(book.getID(), null));
		if(message != null) {
			if(message.equals("add-success"))
				modelAndView.addObject("state", "Thêm thành công");
			else if(message.equals("add-failed"))
				modelAndView.addObject("state", "Thêm thất bại");
			else if(message.equals("delete-success"))
				modelAndView.addObject("state", "Xóa thành công");
			else if(message.equals("delete-failed"))
				modelAndView.addObject("state", "Xóa thất bại");
			else 
				modelAndView.addObject("state", "Không xác định được nội dung thông báo");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "quan-tri/them-hinh-anh-cua-sach", method = RequestMethod.POST)
	public ModelAndView AddImage(HttpSession httpSession, @ModelAttribute("imageUpload") ImageUpload imageUpload, BindingResult bindingResult, ImageUploadValidator imageUploadValidator) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		imageUploadValidator.validate(imageUpload, bindingResult);
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/edit-image");
			String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
			modelAndView.addObject("username", username);
			Book book = bookServiceImpl.GetBook(imageUpload.getBookId());
			modelAndView.addObject("book", book);
			modelAndView.addObject("imageUpload", imageUpload);
			return modelAndView;
		}
		
		return new ModelAndView("redirect:/quan-tri/hinh-anh-cua-sach/" + imageUpload.getBookId() + "/add-failed");
	}
	
	@RequestMapping(value = "quan-tri/xoa-hinh-anh-cua-sach", method = RequestMethod.POST)
	public ModelAndView DeleteImage(HttpSession httpSession, @RequestParam(value = "id", required = true) long id) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		if(id <= 0)
			return new ModelAndView("redirect:/quan-tri/danh-sach-sach");
		
		if(bookServiceImpl.DeleteImage(id))
			return new ModelAndView("redirect:/quan-tri/hinh-anh-cua-sach/" + id + "/delete-success");
		
		return new ModelAndView("redirect:/quan-tri/hinh-anh-cua-sach/" + id + "/delete-failed");
	}
	
	@RequestMapping(value = {"quan-tri/chinh-sua-sach/{id}", "quan-tri/chinh-sua-sach/{id}/{message}"}, method = RequestMethod.GET)
	public ModelAndView UpdateBook(HttpSession httpSession, @PathVariable long id, @PathVariable(required = false) String message) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		if (id <= 0)
			return new ModelAndView("redirect:/quan-tri/danh-sach-sach");

		Book book = bookServiceImpl.GetBook(id);
		if (book == null)
			return new ModelAndView("redirect:/quan-tri/danh-sach-sach");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/update-book");
		String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
		modelAndView.addObject("username", username);
		modelAndView.addObject("book", book);
		modelAndView.addObject("categories", categoryServiceImpl.GetCategories());
		modelAndView.addObject("publishingHouses", publishingHouseServiceImpl.GetPublishingHouses());
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
	
	@RequestMapping(value = "quan-tri/chinh-sua-sach/{id}", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public ModelAndView UpdateBook(HttpSession httpSession, @ModelAttribute("book") Book book, BindingResult bindingResult, BookValidator bookValidator) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		bookValidator.validate(book, bindingResult);
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/update-book");
			String username = loginState.replace("logged:true;username:", "").replace(";role:Admin", "");
			modelAndView.addObject("username", username);
			modelAndView.addObject("book", book);
			return modelAndView;
		}

		if(bookServiceImpl.UpdateBook(book))
			return new ModelAndView("redirect:/quan-tri/chinh-sua-sach/{id}/edit-success");
		
		return new ModelAndView("redirect:/quan-tri/chinh-sua-sach/{id}/edit-failed");
	}

	@RequestMapping(value = "quan-tri/xoa-sach", method = RequestMethod.POST)
	public ModelAndView DeleteBook(HttpSession httpSession, @RequestParam(value = "id", required = true) long id) {
		Object obj = httpSession.getAttribute("loginState");
		if(obj == null)
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		String loginState = obj.toString();
		if(!loginState.matches("logged:true;username:([a-zA-Z0-9]{1,});role:Admin"))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		if(id <= 0)
			return new ModelAndView("redirect:/quan-tri/danh-sach-sach");
		
		if(bookServiceImpl.DeleteBook(id))
			return new ModelAndView("redirect:/quan-tri/danh-sach-sach/delete-success");
		
		return new ModelAndView("redirect:/quan-tri/danh-sach-sach/delete-failed");
	}
}
