package SpringMVC.AdminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringMVC.DAO.CategoryDAO;
import SpringMVC.Entity.Category;

@Service
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	private CategoryDAO categoryDAO;
	
	public List<Category> GetCategories() {
		return categoryDAO.GetCategories();
	}

	public Category GetCategory(int id) {
		return categoryDAO.GetCategory(id);
	}
	
}
