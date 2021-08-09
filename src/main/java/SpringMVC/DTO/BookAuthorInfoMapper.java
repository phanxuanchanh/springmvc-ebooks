package SpringMVC.DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookAuthorInfoMapper implements RowMapper<BookAuthorInfo> {

	public BookAuthorInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		BookAuthorInfo bookAuthorInfo = new BookAuthorInfo(rs.getLong("Id"), rs.getString("name"), rs.getString("description"),
				rs.getString("email"), rs.getString("address"), rs.getString("roleName"));
		return bookAuthorInfo;
	}

}
