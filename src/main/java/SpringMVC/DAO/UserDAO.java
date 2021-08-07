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
		String query = "Select * from [User]";
		users = jdbcTemplate.query(query, new UserMapper());
		return users;
	}

	public User GetUser(String username) {
		User user = null;
		String query = "Select * from [User] where username = ?";
		user = jdbcTemplate.queryForObject(query, new Object[] { username }, new UserMapper());
		return user;
	}
	
	public User GetUserByEmail(String email) {
		User user = null;
		String query = "Select * from [User] where email = ?";
		user = jdbcTemplate.queryForObject(query, new Object[] { email }, new UserMapper());
		return user;
	}

	public boolean CreateUser(User user) {
		String query = "Insert into [User](username, email, password, roleId) values(?, ?, ?, ?)";
		int affected = jdbcTemplate.update(query,
				new Object[] { user.getUsername(), user.getEmail(), user.getPassword(), user.getRoleId() });
		return (affected > 0);
	}

	/*public boolean UpdateUser(User user) {
		String query = "Update User set name = ? where Id = ?";
		int affected = jdbcTemplate.update(query, new Object[] { user.getUsername() });
		return (affected > 0);
	}*/

	public boolean DeleteUser(String username) {
		String query = "Delete from [User] where Id = ?";
		int affected = jdbcTemplate.update(query, new Object[] { username });
		return (affected > 0);
	}

	public int CountUser() {
		String query = "Select count(*) from [User]";
		int count = jdbcTemplate.queryForObject(query, Integer.class);
		return count;
	}
	
	public boolean IsExistUserByUserName(String username) {
		String query = "Select count(*) from [User] where username = ?";
		int count = jdbcTemplate.queryForObject(query, new Object[] { username }, Integer.class);
		return (count > 0);
	}

	public boolean IsExistUserByEmail(String email) {
		String query = "Select count(*) from [User] where email = ?";
		int count = jdbcTemplate.queryForObject(query, new Object[] { email }, Integer.class);
		return (count > 0);
	}
}
