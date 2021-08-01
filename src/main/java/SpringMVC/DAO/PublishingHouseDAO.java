package SpringMVC.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import SpringMVC.Entity.PublishingHouse;
import SpringMVC.Entity.PublishingHouseMapper;

@Repository
public class PublishingHouseDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<PublishingHouse> GetPublishingHouses() {
		List<PublishingHouse> publishingHouses = new ArrayList<PublishingHouse>();
		String query = "Select * from PublishingHouse";
		publishingHouses = jdbcTemplate.query(query, new PublishingHouseMapper());
		return publishingHouses;
	}

	public PublishingHouse GetPublishingHouse(long id) {
		PublishingHouse publishingHouse = null;
		String query = "Select * from PublishingHouse where Id = ?";
		publishingHouse = jdbcTemplate.queryForObject(query, new Object[] { id }, new PublishingHouseMapper());
		return publishingHouse;
	}

	public boolean CreatePublishingHouse(PublishingHouse publishingHouse) {
		String query = "Insert into PublishingHouse(name, description, email, address) values(?, ?, ?, ?)";
		int affected = jdbcTemplate.update(query, new Object[] { publishingHouse.getName(),
				publishingHouse.getDescription(), publishingHouse.getEmail(), publishingHouse.getAddress() });
		return (affected > 0);
	}

	public boolean UpdatePublishingHouse(PublishingHouse publishingHouse) {
		String query = "Update PublishingHouse set name = ?, description = ?, email = ?, address = ? where Id = ?";
		int affected = jdbcTemplate.update(query,
				new Object[] { publishingHouse.getName(), publishingHouse.getDescription(), publishingHouse.getEmail(),
						publishingHouse.getAddress(), publishingHouse.getID() });
		return (affected > 0);
	}

	public boolean DeletePublishingHouse(long id) {
		String query = "Delete from PublishingHouse where Id = ?";
		int affected = jdbcTemplate.update(query, new Object[] { id });
		return (affected > 0);
	}
	
	public int CountPublishingHouse() {
		String query = "Select count(*) from PublishingHouse";
		int count = jdbcTemplate.queryForObject(query, Integer.class);
		return count;
	}
	
	public boolean IsExistPublishingHouseById(long id) {
		String query = "Select count(*) from PublishingHouse where Id = ?";
		int count = jdbcTemplate.queryForObject(query, new Object[] { id }, Integer.class);
		return (count > 0);
	}

	public boolean IsExistPublishingHouseByName(String name) {
		String query = "Select count(*) from PublishingHouse where name = ?";
		int count = jdbcTemplate.queryForObject(query, new Object[] { name }, Integer.class);
		return (count > 0);
	}
}
