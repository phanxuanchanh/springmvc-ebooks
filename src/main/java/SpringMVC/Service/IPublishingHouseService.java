package SpringMVC.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringMVC.Entity.PublishingHouse;

@Service
public interface IPublishingHouseService {
	@Autowired
	
	List<PublishingHouse> GetPublishingHouses();
	PublishingHouse GetPublishingHouse(long id);
	boolean CreatePublishingHouse(PublishingHouse publishingHouse);
	boolean UpdatePublishingHouse(PublishingHouse publishingHouse);
	boolean DeletePublishingHouse(long id);
}
