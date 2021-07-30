package SpringMVC.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import SpringMVC.Entity.Category;
import SpringMVC.Entity.CategoryMapper;

@Repository
public class CategoryDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Category> GetCategories(){
		List<Category> categories = new ArrayList<Category>();
		String query = "Select * from Category";
		categories = jdbcTemplate.query(query, new CategoryMapper());
		return categories;
	}
	
	public Category GetCategory(int id) {
		Category category = null;
		String query = "Select * from Category where ID = ?";
		category = jdbcTemplate.queryForObject(query, new Object[] {id}, new CategoryMapper());
		return category;
	}
	
	public boolean CreateCategory(Category category) {
		return true;
	}
}
