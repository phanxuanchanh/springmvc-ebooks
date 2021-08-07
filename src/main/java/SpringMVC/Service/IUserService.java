package SpringMVC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringMVC.DTO.UserLogin;
import SpringMVC.DTO.UserRegister;
import SpringMVC.Entity.User;

@Service
public interface IUserService {
	@Autowired
	
	User GetUser(String username);
	User GetUserByEmail(String email);
	boolean Login(UserLogin userLogin);
	boolean Register(UserRegister userRegister);
	boolean DeleteUser(String username);
}
