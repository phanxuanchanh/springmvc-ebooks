package SpringMVC.Service;

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
		if (categoryDAO.IsExistCategoryById(id))
			return categoryDAO.GetCategory(id);
		return null;
	}

	public boolean CreateCategory(Category category) {
		if(categoryDAO.IsExistCategoryByName(category.getName()))
			return false;
		return categoryDAO.CreateCategory(category);
	}

	public boolean UpdateCategory(Category category) {
		if(categoryDAO.IsExistCategoryById(category.getID()))
			return categoryDAO.UpdateCategory(category);
		return false;
	}

	public boolean DeleteCategory(int id) {
		if (categoryDAO.IsExistCategoryById(id)) {
			//Kiểm tra đi�?u kiện ràng buộc
			return categoryDAO.DeleteCategory(id);
		}
		return false;
	}

}
