package SpringMVC.UserController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import SpringMVC.DTO.BookInfo;
import SpringMVC.Entity.Book;
import SpringMVC.Entity.Category;
import SpringMVC.Service.BookServiceImpl;
import SpringMVC.Service.CategoryServiceImpl;

@Controller
public class HomeController {
	@Autowired
	private BookServiceImpl bookServiceImpl;
	
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@RequestMapping(value = { "/", "/trang-chu" }, method = RequestMethod.GET)
	public ModelAndView Index(HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/index");
		Object obj = httpSession.getAttribute("loginState");
		boolean isLogged = false;
		if(obj != null)
			isLogged = true;
		
		modelAndView.addObject("isLogged", isLogged);
		modelAndView.addObject("latestBooks", bookServiceImpl.GetLatestBooks(10));
		modelAndView.addObject("booksByViews", bookServiceImpl.GetBooksByViews(10));
		return modelAndView;
	}
	
	@RequestMapping(value = "/danh-sach-the-loai", method = RequestMethod.GET)
	public ModelAndView CategoryList(HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/category-list");
		Object obj = httpSession.getAttribute("loginState");
		boolean isLogged = false;
		if(obj != null)
			isLogged = true;
		
		modelAndView.addObject("isLogged", isLogged);
		modelAndView.addObject("categories", categoryServiceImpl.GetCategories());
		modelAndView.addObject("bookNumber", bookServiceImpl.CountBook());
		return modelAndView;
	}
	
	@RequestMapping(value = "/sach-theo-the-loai/{id}", method = RequestMethod.GET)
	public ModelAndView BooksByCategory(HttpSession httpSession, @PathVariable int id) {
		if(id <= 0)
			return new ModelAndView("redirect:/");
		
		List<Category> categories = categoryServiceImpl.GetCategories();
		
		Category category = null;
		for(Category item : categories) {
			if(item.getID() == id) {
				category = item;
			}
		}
		
		if(category == null) 
			return new ModelAndView("redirect:/");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/books-by-category");
		Object obj = httpSession.getAttribute("loginState");
		boolean isLogged = false;
		if(obj != null)
			isLogged = true;
		
		modelAndView.addObject("isLogged", isLogged);
		modelAndView.addObject("categories", categories);
		modelAndView.addObject("category", category);
		modelAndView.addObject("bookNumber", bookServiceImpl.CountBook());
		modelAndView.addObject("booksByCategory", bookServiceImpl.GetBooksByCategoryId(id));
		return modelAndView;
	}
	
	@RequestMapping(value = "/chi-tiet-sach/{id}", method = RequestMethod.GET)
	public ModelAndView BookDetail(HttpSession httpSession, @PathVariable long id) {
		if(id <= 0)
			return new ModelAndView("redirect:/");
		
		BookInfo bookInfo = bookServiceImpl.GetBookInfo(id);
		if(bookInfo == null)
			return new ModelAndView("redirect:/");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/book-detail");
		Object obj = httpSession.getAttribute("loginState");
		boolean isLogged = false;
		if(obj != null)
			isLogged = true;
		
		modelAndView.addObject("isLogged", isLogged);
		modelAndView.addObject("bookInfo", bookInfo);
		modelAndView.addObject("bookNumber", bookServiceImpl.CountBook());
		modelAndView.addObject("booksByCategory", bookServiceImpl.GetBooksByCategoryId(bookInfo.getCategory().getID()));
		return modelAndView;
	}
	
	@RequestMapping(value = "/xem-sach-online/{id}", method = RequestMethod.GET)
	public ModelAndView ReadBook(HttpSession httpSession, @PathVariable long id) {
		if(id <= 0)
			return new ModelAndView("redirect:/");
		
		Book book = bookServiceImpl.GetBook(id);
		if(book == null)
			return new ModelAndView("redirect:/");
		
		if(book.getPdf() == null)
			return new ModelAndView("redirect:/");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/read-book");
		Object obj = httpSession.getAttribute("loginState");
		boolean isLogged = false;
		if(obj != null)
			isLogged = true;
		
		modelAndView.addObject("isLogged", isLogged);
		modelAndView.addObject("book", book);
		return modelAndView;
	}
	
	@RequestMapping(value ="/tim-kiem-sach", method = RequestMethod.GET)
	public ModelAndView TimKiemSach(HttpSession httpSession, @RequestParam(value = "keyword", required = true) String keyword) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/search-results");
		Object obj = httpSession.getAttribute("loginState");
		boolean isLogged = false;
		if(obj != null)
			isLogged = true;
		
		modelAndView.addObject("isLogged", isLogged);
		modelAndView.addObject("keyword", keyword);
		return modelAndView;
	}
	
	@RequestMapping(value = "/tang-luot-xem", method = RequestMethod.POST)
	public ResponseEntity<String> IncreaseView(@RequestParam(value = "id", required = true) long id){
		if(id <= 0)
			return new ResponseEntity<String>("Invalid", HttpStatus.BAD_REQUEST);
		
		if(bookServiceImpl.IncreaseView(id))
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		
		return new ResponseEntity<String>("Failed", HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/thich-sach", method = RequestMethod.POST)
	public ResponseEntity<String> Upvote(@RequestParam(value = "id", required = true) long id){
		if(id <= 0)
			return new ResponseEntity<String>("Invalid", HttpStatus.BAD_REQUEST);
		
		if(bookServiceImpl.Upvote(id))
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		
		return new ResponseEntity<String>("Failed", HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/khong-thich-sach", method = RequestMethod.POST)
	public ResponseEntity<String> Downvote(@RequestParam(value = "id", required = true) long id){
		if(id <= 0)
			return new ResponseEntity<String>("Invalid", HttpStatus.BAD_REQUEST);
		
		if(bookServiceImpl.Downvote(id))
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		
		return new ResponseEntity<String>("Failed", HttpStatus.NOT_FOUND);
	}
}