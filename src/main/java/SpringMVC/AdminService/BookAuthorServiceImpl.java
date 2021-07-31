package SpringMVC.AdminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringMVC.DAO.BookAuthorDAO;
import SpringMVC.Entity.BookAuthor;

@Service
public class BookAuthorServiceImpl implements IBookAuthorService {
	@Autowired
	private BookAuthorDAO bookAuthorDAO;

	public List<BookAuthor> GetBookAuthors() {
		return bookAuthorDAO.GetBookAuthors();
	}

	public BookAuthor GetBookAuthor(long id) {
		return bookAuthorDAO.GetBookAuthor(id);
	}

	public boolean CreateBookAuthor(BookAuthor bookAuthor) {
		return bookAuthorDAO.CreateBookAuthor(bookAuthor);
	}

	public boolean UpdateBookAuthor(BookAuthor bookAuthor) {
		return bookAuthorDAO.UpdateBookAuthor(bookAuthor);
	}

	public boolean DeleteBookAuthor(long id) {
		return bookAuthorDAO.DeleteBookAuthor(id);
	}
}
