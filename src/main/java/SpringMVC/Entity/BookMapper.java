package SpringMVC.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookMapper implements RowMapper<Book> {

	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book book = new Book(rs.getLong("Id"), rs.getString("name"), rs.getString("description"),
				rs.getInt("categoryId"), rs.getLong("publishingHouseId"), rs.getLong("views"), rs.getLong("upvote"),
				rs.getLong("downvote"), rs.getString("pdf"), rs.getString("img"));
		return book;
	}

}
