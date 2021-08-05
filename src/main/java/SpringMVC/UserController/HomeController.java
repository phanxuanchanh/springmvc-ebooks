package SpringMVC.UserController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import SpringMVC.DTO.BookInfo;
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
	public ModelAndView Index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/index");
		modelAndView.addObject("latestBooks", bookServiceImpl.GetLatestBooks());
		modelAndView.addObject("booksByViews", bookServiceImpl.GetBooksByViews());
		return modelAndView;
	}
	
	@RequestMapping(value = "/danh-sach-the-loai", method = RequestMethod.GET)
	public ModelAndView CategoryList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/category-list");
		modelAndView.addObject("categories", categoryServiceImpl.GetCategories());
		modelAndView.addObject("bookNumber", bookServiceImpl.CountBook());
		return modelAndView;
	}
	
	@RequestMapping(value = "/sach-theo-the-loai/{id}", method = RequestMethod.GET)
	public ModelAndView BooksByCategory(@PathVariable int id) {
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
		modelAndView.addObject("categories", categories);
		modelAndView.addObject("category", category);
		modelAndView.addObject("bookNumber", bookServiceImpl.CountBook());
		modelAndView.addObject("booksByCategory", bookServiceImpl.GetBooksByCategoryId(id));
		return modelAndView;
	}
	
	@RequestMapping(value = "/chi-tiet-sach/{id}", method = RequestMethod.GET)
	public ModelAndView BookDetail(@PathVariable long id) {
		if(id <= 0)
			return new ModelAndView("redirect:/");
		
		BookInfo bookInfo = bookServiceImpl.GetBookInfo(id);
		if(bookInfo == null)
			return new ModelAndView("redirect:/");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/book-detail");
		modelAndView.addObject("book", bookInfo);
		modelAndView.addObject("bookNumber", bookServiceImpl.CountBook());
		modelAndView.addObject("booksByCategory", bookServiceImpl.GetBooksByCategoryId(bookInfo.getCategory().getID()));
		return modelAndView;
	}
}