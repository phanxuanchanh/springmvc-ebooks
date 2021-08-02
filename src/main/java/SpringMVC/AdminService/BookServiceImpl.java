package SpringMVC.AdminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringMVC.DAO.BookAuthorDAO;
import SpringMVC.DAO.BookDAO;
import SpringMVC.DAO.CategoryDAO;
import SpringMVC.DAO.PublishingHouseDAO;
import SpringMVC.DTO.BookInfo;
import SpringMVC.Entity.Book;
import SpringMVC.Entity.BookAuthor;
import SpringMVC.Entity.Category;
import SpringMVC.Entity.PublishingHouse;

@Service
public class BookServiceImpl implements IBookService {
	@Autowired
	private BookDAO bookDAO;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private PublishingHouseDAO publishingHouseDAO;

	@Autowired
	private BookAuthorDAO bookAuthorDAO;

	public List<Book> GetBooks() {
		return bookDAO.GetBooks();
	}

	public Book GetBook(long id) {
		if (bookDAO.IsExistBookById(id))
			return bookDAO.GetBook(id);
		return null;
	}

	public BookInfo GetBookInfo(long id) {
		if (bookDAO.IsExistBookById(id)) {
			Book book = bookDAO.GetBook(id);
			if (book == null)
				return null;

			Category category = categoryDAO.GetCategory(book.getCategoryId());
			PublishingHouse publishingHouse = publishingHouseDAO.GetPublishingHouse(book.getPublishingHouseId());
			List<BookAuthor> bookAuthors = bookAuthorDAO.GetBookAuthorsByBookId(book.getID());

			return new BookInfo(book.getID(), book.getName(), book.getDescription(), category, publishingHouse,
					bookAuthors, book.getViews(), book.getUpvote(), book.getDownvote(), book.getPdf(), book.getImg());
		}
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

	public boolean AddImage(long id, String filePath) {
		if (bookDAO.IsExistBookById(id))
			return bookDAO.AddImage(id, filePath);
		return false;
	}

	public boolean DeleteImage(long id) {
		if (bookDAO.IsExistBookById(id))
			return bookDAO.DeleteImage(id);
		return false;
	}

	public boolean AddPdf(long id, String filePath) {
		if (bookDAO.IsExistBookById(id))
			return bookDAO.AddPdf(id, filePath);
		return false;
	}

	public boolean DeletePdf(long id) {
		if (bookDAO.IsExistBookById(id))
			return bookDAO.DeletePdf(id);
		return false;
	}

	public boolean DeleteBook(long id) {
		if (bookDAO.IsExistBookById(id))
			return bookDAO.DeleteBook(id);
		return false;
	}
}
