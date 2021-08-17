package SpringMVC.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import SpringMVC.Entity.Book;
import SpringMVC.Entity.BookMapper;

@Repository
public class BookDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Book> GetBooks() {
		List<Book> books = new ArrayList<Book>();
		String query = "Select * from Book";
		books = jdbcTemplate.query(query, new BookMapper());
		return books;
	}

	public List<Book> GetLatestBooks(int count) {
		List<Book> books = new ArrayList<Book>();
		String query = "Select top " + count + " * from Book order by Id desc";
		books = jdbcTemplate.query(query, new BookMapper());
		return books;
	}

	public List<Book> GetBooksByCategoryId(int id) {
		List<Book> books = new ArrayList<Book>();
		String query = "Select * from Book where categoryId = ?";
		books = jdbcTemplate.query(query, new Object[] { id }, new BookMapper());
		return books;
	}
	
	public List<Book> GetBooksByViews(int count) {
		List<Book> books = new ArrayList<Book>();
		String query = "Select top " + count + " * from Book order by views desc";
		books = jdbcTemplate.query(query, new BookMapper());
		return books;
	}
	
	public List<Book> GetBooksByKeyword(String keyword){
		List<Book> books = new ArrayList<Book>();
		String query = "Select * from Book where name like ?";
		books = jdbcTemplate.query(query, new Object[] { "%" + keyword + "%" }, new BookMapper());
		return books;
	}

	public Book GetBook(long id) {
		Book book = null;
		String query = "Select * from Book where Id = ?";
		book = jdbcTemplate.queryForObject(query, new Object[] { id }, new BookMapper());
		return book;
	}

	public boolean CreateBook(Book book) {
		String query = "Insert into Book(name, description, categoryId, publishingHouseId, views, upvote, downvote, pdf, img) values(?, ?, ?, ?, 0, 0, 0, NULL, NULL)";
		int affected = jdbcTemplate.update(query, new Object[] { book.getName(), book.getDescription(),
				book.getCategoryId(), book.getPublishingHouseId() });
		return (affected > 0);
	}

	public boolean UpdateBook(Book book) {
		String query = "Update Book set name = ?, description = ?, categoryId = ?, publishingHouseId = ? where Id = ?";
		int affected = jdbcTemplate.update(query, new Object[] { book.getName(), book.getDescription(),
				book.getCategoryId(), book.getPublishingHouseId(), book.getID() });
		return (affected > 0);
	}

	public boolean AddImage(long id, String filePath) {
		String query = "Update Book set img = ? where Id = ?";
		int affected = jdbcTemplate.update(query, new Object[] { filePath, id });
		return (affected > 0);
	}

	public boolean DeleteImage(long id) {
		String query = "Update Book set img = NULL where Id = ?";
		int affected = jdbcTemplate.update(query, new Object[] { id });
		return (affected > 0);
	}

	public boolean AddPdf(long id, String filePath) {
		String query = "Update Book set pdf = ? where Id = ?";
		int affected = jdbcTemplate.update(query, new Object[] { filePath, id });
		return (affected > 0);
	}

	public boolean DeletePdf(long id) {
		String query = "Update Book set pdf = NULL where Id = ?";
		int affected = jdbcTemplate.update(query, new Object[] { id });
		return (affected > 0);
	}
	
	public boolean IncreaseView(long id) {
		String query = "Update Book set views = views + 1 where Id = ?";
		int affected = jdbcTemplate.update(query, new Object[] { id });
		return (affected > 0);
	}
	
	public boolean Upvote(long id) {
		String query = "Update Book set upvote = upvote + 1 where Id = ?";
		int affected = jdbcTemplate.update(query, new Object[] { id });
		return (affected > 0);
	}
	
	public boolean Downvote(long id) {
		String query = "Update Book set downvote = downvote + 1 where Id = ?";
		int affected = jdbcTemplate.update(query, new Object[] { id });
		return (affected > 0);
	}

	public boolean DeleteBook(long id) {
		String query = "Delete from Book where Id = ?";
		int affected = jdbcTemplate.update(query, new Object[] { id });
		return (affected > 0);
	}

	public int CountBook() {
		String query = "Select count(*) from Book";
		int count = jdbcTemplate.queryForObject(query, Integer.class);
		return count;
	}

	public boolean IsExistBookById(long id) {
		String query = "Select count(*) from Book where Id = ?";
		int count = jdbcTemplate.queryForObject(query, new Object[] { id }, Integer.class);
		return (count > 0);
	}

	public boolean IsExistBookByName(String name) {
		String query = "Select count(*) from Book where name = ?";
		int count = jdbcTemplate.queryForObject(query, new Object[] { name }, Integer.class);
		return (count > 0);
	}
	
	public boolean IsExistBookByCategoryId(int categoryId) {
		String query = "Select count(*) from Book where categoryId = ?";
		int count = jdbcTemplate.queryForObject(query, new Object[] { categoryId }, Integer.class);
		return (count > 0);
	}
	
	public boolean IsExistBookByPublishingHouseId(long publishingHouseId) {
		String query = "Select count(*) from Book where publishingHouseId = ?";
		int count = jdbcTemplate.queryForObject(query, new Object[] { publishingHouseId }, Integer.class);
		return (count > 0);
	}
}
