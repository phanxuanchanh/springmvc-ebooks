package SpringMVC.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import SpringMVC.Entity.BookAuthor;
import SpringMVC.Entity.BookAuthorMapper;

@Repository
public class BookAuthorDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<BookAuthor> GetBookAuthors() {
		List<BookAuthor> bookAuthors = new ArrayList<BookAuthor>();
		String query = "Select * from BookAuthor";
		bookAuthors = jdbcTemplate.query(query, new BookAuthorMapper());
		return bookAuthors;
	}

	public List<BookAuthor> GetBookAuthorsByBookId(long bookId) {
		List<BookAuthor> bookAuthors = new ArrayList<BookAuthor>();
		String query = "Select BookAuthor.* from BookAuthor, AuthorContribute where BookAuthor.Id = AuthorContribute.bookAuthorId and AuthorContribute.bookId = ?";
		bookAuthors = jdbcTemplate.query(query, new Object[] {bookId}, new BookAuthorMapper());
		return bookAuthors;
	}

	public BookAuthor GetBookAuthor(long id) {
		BookAuthor bookAuthor = null;
		String query = "Select * from BookAuthor where Id = ?";
		bookAuthor = jdbcTemplate.queryForObject(query, new Object[] { id }, new BookAuthorMapper());
		return bookAuthor;
	}

	public boolean CreateBookAuthor(BookAuthor bookAuthor) {
		String query = "Insert into BookAuthor(name, description, email, address) values(?, ?, ?, ?)";
		int affected = jdbcTemplate.update(query, new Object[] { bookAuthor.getName(), bookAuthor.getDescription(),
				bookAuthor.getEmail(), bookAuthor.getAddress() });
		return (affected > 0);
	}

	public boolean UpdateBookAuthor(BookAuthor bookAuthor) {
		String query = "Update BookAuthor set name = ?, description = ?, email = ?, address = ? where Id = ?";
		int affected = jdbcTemplate.update(query, new Object[] { bookAuthor.getName(), bookAuthor.getDescription(),
				bookAuthor.getEmail(), bookAuthor.getAddress(), bookAuthor.getID() });
		return (affected > 0);
	}

	public boolean DeleteBookAuthor(long id) {
		String query = "Delete from BookAuthor where Id = ?";
		int affected = jdbcTemplate.update(query, new Object[] { id });
		return (affected > 0);
	}

	public int CountBookAuthor() {
		String query = "Select count(*) from BookAuthor";
		int count = jdbcTemplate.queryForObject(query, Integer.class);
		return count;
	}

	public boolean IsExistBookAuthorById(long id) {
		String query = "Select count(*) from BookAuthor where Id = ?";
		int count = jdbcTemplate.queryForObject(query, new Object[] { id }, Integer.class);
		return (count > 0);
	}

	public boolean IsExistBookAuthorByName(String name) {
		String query = "Select count(*) from BookAuthor where name = ?";
		int count = jdbcTemplate.queryForObject(query, new Object[] { name }, Integer.class);
		return (count > 0);
	}
}
