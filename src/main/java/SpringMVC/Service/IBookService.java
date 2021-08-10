package SpringMVC.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringMVC.DTO.BookInfo;
import SpringMVC.Entity.AuthorContribute;
import SpringMVC.Entity.Book;

@Service
interface IBookService {
	@Autowired

	List<Book> GetBooks();

	List<BookInfo> GetLatestBooks(int count);

	List<BookInfo> GetBooksByViews(int count);

	List<BookInfo> GetBooksByCategoryId(int id);

	Book GetBook(long id);

	BookInfo GetBookInfo(long id);

	boolean CreateBook(Book book);

	boolean AddBookAuthor(AuthorContribute authorContribute);

	boolean DeleteAllBookAuthor(long bookId);

	boolean AddImage(long id, String filePath);

	boolean DeleteImage(long id);

	boolean AddPdf(long id, String filePath);

	boolean DeletePdf(long id);

	boolean DeleteBook(long id);

	int CountBook();
}
