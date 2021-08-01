package SpringMVC.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringMVC.DAO.BookAuthorDAO;
import SpringMVC.DAO.BookDAO;
import SpringMVC.DAO.CategoryDAO;
import SpringMVC.DAO.PublishingHouseDAO;
import SpringMVC.DTO.Analyst;

@Service
public class GeneralServiceImpl implements IGeneralService {
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private PublishingHouseDAO publishingHouseDAO;
	
	@Autowired
	private BookAuthorDAO bookAuthorDAO;
	
	@Autowired
	private BookDAO bookDAO;

	public Analyst GetAnalyst() {

		Analyst analyst = new Analyst(categoryDAO.CountCategory(), publishingHouseDAO.CountPublishingHouse(),
				bookAuthorDAO.CountBookAuthor(), bookDAO.CountBook());
		return analyst;
	}

}
