package SpringMVC.Service;

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
		if (publishingHouseDAO.IsExistPublishingHouseById(id))
			return publishingHouseDAO.GetPublishingHouse(id);
		return null;
	}

	public boolean CreatePublishingHouse(PublishingHouse publishingHouse) {
		if (publishingHouseDAO.IsExistPublishingHouseByName(publishingHouse.getName()))
			return false;
		return publishingHouseDAO.CreatePublishingHouse(publishingHouse);
	}

	public boolean UpdatePublishingHouse(PublishingHouse publishingHouse) {
		if (publishingHouseDAO.IsExistPublishingHouseById(publishingHouse.getID()))
			return publishingHouseDAO.UpdatePublishingHouse(publishingHouse);
		return false;
	}

	public boolean DeletePublishingHouse(long id) {
		if (publishingHouseDAO.IsExistPublishingHouseById(id))
			return publishingHouseDAO.DeletePublishingHouse(id);
		return false;
	}
}
