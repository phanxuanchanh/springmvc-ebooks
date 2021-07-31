package SpringMVC.AdminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringMVC.Entity.BookAuthor;

@Service
public interface IBookAuthorService {
	@Autowired
	
	List<BookAuthor> GetBookAuthors();
	BookAuthor GetBookAuthor(long id);
	boolean CreateBookAuthor(BookAuthor bookAuthor);
	boolean UpdateBookAuthor(BookAuthor bookAuthor);
	boolean DeleteBookAuthor(long id);
}
