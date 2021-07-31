package SpringMVC.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User(rs.getString("username"), rs.getString("password"), rs.getString("salt"),
				rs.getInt("roleId"));
		return user;
	}
}
