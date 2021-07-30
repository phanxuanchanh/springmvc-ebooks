package SpringMVC.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CategoryMapper implements RowMapper<Category>  {

	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		Category category = new Category(rs.getInt("ID"), rs.getString("name"), rs.getString("description"));
		return category;
	}

}
