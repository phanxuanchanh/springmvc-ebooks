package SpringMVC.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PublishingHouseMapper implements RowMapper<PublishingHouse> {

	public PublishingHouse mapRow(ResultSet rs, int rowNum) throws SQLException {
		PublishingHouse publishingHouse = new PublishingHouse(rs.getLong("Id"), rs.getString("name"),
				rs.getString("description"), rs.getString("email"), rs.getString("address"));
		return publishingHouse;
	}

}
