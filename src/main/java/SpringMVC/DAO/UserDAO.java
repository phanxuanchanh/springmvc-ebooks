package SpringMVC.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import SpringMVC.Entity.User;
import SpringMVC.Entity.UserMapper;

@Repository
public class UserDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<User> GetUsers() {
		List<User> users = new ArrayList<User>();
		String query = "Select * from User";
		users = jdbcTemplate.query(query, new UserMapper());
		return users;
	}

	public User GetUser(int id) {
		User user = null;
		String query = "Select * from User where Id = ?";
		user = jdbcTemplate.queryForObject(query, new Object[] { id }, new UserMapper());
		return user;
	}

	public boolean CreateUser(User user) {
		String query = "Insert into User(username, password, salt, roleId) values(?, ?, ?, ?)";
		int affected = jdbcTemplate.update(query,
				new Object[] { user.getUsername(), user.getPassword(), user.getSalt(), user.getRoleId() });
		return (affected > 0);
	}

	/*public boolean UpdateUser(User user) {
		String query = "Update User set name = ? where Id = ?";
		int affected = jdbcTemplate.update(query, new Object[] { user.getUsername() });
		return (affected > 0);
	}*/

	public boolean DeleteUser(int id) {
		String query = "Delete from User where Id = ?";
		int affected = jdbcTemplate.update(query, new Object[] { id });
		return (affected > 0);
	}

	public int CountUser() {
		String query = "Select count(*) from User";
		int count = jdbcTemplate.queryForObject(query, Integer.class);
		return count;
	}
}
