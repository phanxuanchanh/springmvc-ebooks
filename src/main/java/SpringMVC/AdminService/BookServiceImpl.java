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
		if (bookDAO.IsExistBookById(id))
			return bookDAO.GetBook(id);
		return null;
	}

	public boolean CreateBook(Book book) {
		if (bookDAO.IsExistBookByName(book.getName()))
			return false;
		return bookDAO.CreateBook(book);
	}

	public boolean UpdateBook(Book book) {
		if (bookDAO.IsExistBookById(book.getID()))
			return bookDAO.UpdateBook(book);
		return false;
	}

	public boolean DeleteBook(long id) {
		if (bookDAO.IsExistBookById(id))
			return bookDAO.DeleteBook(id);
		return false;
	}
}
