package SpringMVC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringMVC.DTO.Analyst;

@Service
interface IGeneralService {
	@Autowired

	Analyst GetAnalyst();
}
