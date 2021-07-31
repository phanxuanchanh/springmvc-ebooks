package SpringMVC.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import SpringMVC.Entity.Role;
import SpringMVC.Entity.RoleMapper;

@Repository
public class RoleDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Role> GetRoles() {
		List<Role> roles = new ArrayList<Role>();
		String query = "Select * from [Role]";
		roles = jdbcTemplate.query(query, new RoleMapper());
		return roles;
	}

	public Role GetRole(int id) {
		Role role = null;
		String query = "Select * from Role where Id = ?";
		role = jdbcTemplate.queryForObject(query, new Object[] { id }, new RoleMapper());
		return role;
	}

	public boolean CreateRole(Role role) {
		String query = "Insert into Role(name) values(?)";
		int affected = jdbcTemplate.update(query, new Object[] { role.getName() });
		return (affected > 0);
	}

	public boolean UpdateRole(Role role) {
		String query = "Update Role set name = ? where Id = ?";
		int affected = jdbcTemplate.update(query, new Object[] { role.getName(), role.getId() });
		return (affected > 0);
	}

	public boolean DeleteRole(int id) {
		String query = "Delete from Role where Id = ?";
		int affected = jdbcTemplate.update(query, new Object[] { id });
		return (affected > 0);
	}

	public int CountRole() {
		String query = "Select count(*) from Role";
		int count = jdbcTemplate.queryForObject(query, Integer.class);
		return count;
	}
}
