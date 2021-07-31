package SpringMVC.AdminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import SpringMVC.AdminService.BookServiceImpl;

@Controller
public class BookManagementController {
	@Autowired
	private BookServiceImpl bookServiceImpl;
	
	@RequestMapping(value = "quan-tri/danh-sach-sach", method = RequestMethod.GET)
	public ModelAndView BookList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/book-list");
		modelAndView.addObject("books", bookServiceImpl.GetBooks());
		return modelAndView;
	}
	
	@RequestMapping(value = "quan-tri/chi-tiet-sach/{id}", method = RequestMethod.GET)
	public ModelAndView BookDetail(@PathVariable long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/book-detail");
		modelAndView.addObject("category", bookServiceImpl.GetBook(id));
		return modelAndView;
	}
}
