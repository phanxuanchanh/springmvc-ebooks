package SpringMVC.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringMVC.DAO.CategoryDAO;
import SpringMVC.DTO.Analyst;

@Service
public class GeneralServiceImpl implements IGeneralService {
	@Autowired
	private CategoryDAO categoryDAO;

	public Analyst GetAnalyst() {

		Analyst analyst = new Analyst(categoryDAO.CountCategory(), 0, 0, 0);
		return analyst;
	}

}
