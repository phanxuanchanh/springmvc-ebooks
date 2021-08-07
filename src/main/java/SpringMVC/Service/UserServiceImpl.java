package SpringMVC.Service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringMVC.DAO.RoleDAO;
import SpringMVC.DAO.UserDAO;
import SpringMVC.DTO.UserLogin;
import SpringMVC.DTO.UserRegister;
import SpringMVC.Entity.Role;
import SpringMVC.Entity.User;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RoleDAO roleDAO;
	
	public User GetUser(String username) {
		if(userDAO.IsExistUserByUserName(username))
			return userDAO.GetUser(username);
		return null;
	}

	public User GetUserByEmail(String email) {
		if(userDAO.IsExistUserByEmail(email))
			return userDAO.GetUserByEmail(email);
		return null;
	}

	public boolean Login(UserLogin userLogin) {
		User user = GetUser(userLogin.getUsername());
		if(user == null)
			return false;

		if(BCrypt.checkpw(userLogin.getPassword(), user.getPassword()))
			return true;
		
		return false;
	}

	public boolean Register(UserRegister userRegister) {
		User user = GetUser(userRegister.getUsername());
		if(user != null)
			return false;
		
		String passwordHashed = BCrypt.hashpw(userRegister.getPassword(), BCrypt.gensalt(12));
		
		Role role = null;
		if(roleDAO.IsExistRoleByName("User"))
			role = roleDAO.GetRoleByName("User");
		
		if(role == null)
			return false;
		
		user = new User(userRegister.getUsername(), userRegister.getEmail(), passwordHashed, role.getID());
		return userDAO.CreateUser(user);
	}

	public boolean DeleteUser(String username) {
		if(userDAO.IsExistUserByUserName(username))
			return userDAO.DeleteUser(username);
		return false;
	}

}
