package SpringMVC.AdminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import SpringMVC.AdminService.BookAuthorServiceImpl;

@Controller
public class BookAuthorManagementController {
	@Autowired
	private BookAuthorServiceImpl bookAuthorServiceImpl;
	
	@RequestMapping(value = "quan-tri/danh-sach-tac-gia", method = RequestMethod.GET)
	public ModelAndView BookAuthorList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/book-author-list");
		modelAndView.addObject("bookAuthors", bookAuthorServiceImpl.GetBookAuthors());
		return modelAndView;
	}
	
	@RequestMapping(value = "quan-tri/chi-tiet-tac-gia", method = RequestMethod.GET)
	public ModelAndView BookAuthorDetail(@PathVariable long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/book-author-detail");
		modelAndView.addObject("bookAuthor", bookAuthorServiceImpl.GetBookAuthor(id));
		return modelAndView;
	}
}
