package SpringMVC.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookAuthorMapper implements RowMapper<BookAuthor> {

	public BookAuthor mapRow(ResultSet rs, int rowNum) throws SQLException {
		BookAuthor bookAuthor = new BookAuthor(rs.getLong("Id"), rs.getString("name"), rs.getString("description"),
				rs.getString("email"), rs.getString("address"));
		return bookAuthor;
	}
}
