package SpringMVC.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import SpringMVC.Entity.Category;
import SpringMVC.Entity.MapperCategory;

@Repository
public class CategoryDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Category> GetCategories(){
		List<Category> categories = new ArrayList<Category>();
		String query = "Select * from Category";
		categories = jdbcTemplate.query(query, new MapperCategory());
		return categories;
	}
	
	
}
