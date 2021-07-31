package SpringMVC.AdminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringMVC.DAO.BookDAO;
import SpringMVC.Entity.Book;

@Service
public class BookServiceImpl implements IBookService {
	@Autowired
	private BookDAO bookDAO;
	
	public List<Book> GetBooks() {
		return bookDAO.GetBooks();
	}

	public Book GetBook(long id) {
		return bookDAO.GetBook(id);
	}

}
