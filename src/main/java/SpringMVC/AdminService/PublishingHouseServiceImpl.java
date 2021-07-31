package SpringMVC.AdminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringMVC.DAO.PublishingHouseDAO;
import SpringMVC.Entity.PublishingHouse;

@Service
public class PublishingHouseServiceImpl implements IPublishingHouseService {
	@Autowired
	private PublishingHouseDAO publishingHouseDAO;

	public List<PublishingHouse> GetPublishingHouses() {
		return publishingHouseDAO.GetPublishingHouses();
	}

	public PublishingHouse GetPublishingHouse(long id) {
		return publishingHouseDAO.GetPublishingHouse(id);
	}

	public boolean CreatePublishingHouse(PublishingHouse publishingHouse) {
		return publishingHouseDAO.CreatePublishingHouse(publishingHouse);
	}

	public boolean UpdatePublishingHouse(PublishingHouse publishingHouse) {
		return publishingHouseDAO.UpdatePublishingHouse(publishingHouse);
	}

	public boolean DeletePublishingHouse(long id) {
		return publishingHouseDAO.DeletePublishingHouse(id);
	}
}
