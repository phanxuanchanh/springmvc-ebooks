package SpringMVC.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AuthorContributeMapper implements RowMapper<AuthorContribute> {

	public AuthorContribute mapRow(ResultSet rs, int rowNum) throws SQLException {
		AuthorContribute authorContribute = new AuthorContribute(rs.getLong("bookAuthorId"), rs.getLong("bookId"),
				rs.getString("role"));
		return authorContribute;
	}

}
