package SpringMVC.Service;

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
	
	public List<BookAuthor> GetBookAuthorsByBookId(long bookId) {
		return bookAuthorDAO.GetBookAuthorsByBookId(bookId);
	}

	public BookAuthor GetBookAuthor(long id) {
		if (bookAuthorDAO.IsExistBookAuthorById(id))
			return bookAuthorDAO.GetBookAuthor(id);
		return null;
	}

	public boolean CreateBookAuthor(BookAuthor bookAuthor) {
		if (bookAuthorDAO.IsExistBookAuthorByName(bookAuthor.getName()))
			return false;
		return bookAuthorDAO.CreateBookAuthor(bookAuthor);
	}

	public boolean UpdateBookAuthor(BookAuthor bookAuthor) {
		if (bookAuthorDAO.IsExistBookAuthorById(bookAuthor.getID()))
			return bookAuthorDAO.UpdateBookAuthor(bookAuthor);
		return false;
	}

	public boolean DeleteBookAuthor(long id) {
		if (bookAuthorDAO.IsExistBookAuthorById(id))
			return bookAuthorDAO.DeleteBookAuthor(id);
		return false;
	}
}
