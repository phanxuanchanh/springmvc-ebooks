package SpringMVC.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringMVC.Entity.Book;

@Service
public interface IBookService {
	@Autowired
	
	List<Book> GetBooks();
	Book GetBook(long id);
}
