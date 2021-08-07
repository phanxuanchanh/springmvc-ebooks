package SpringMVC.Service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringMVC.DAO.RoleDAO;
import SpringMVC.DAO.UserDAO;
import SpringMVC.DTO.UserInfo;
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
		if (userDAO.IsExistUserByUserName(username)) {
			User user = userDAO.GetUser(username);
			user.setPassword(null);
			return user;
		}
		return null;
	}

	public UserInfo GetUserInfo(String username) {
		if (userDAO.IsExistUserByUserName(username)) {
			User user = userDAO.GetUser(username);

			Role role = roleDAO.GetRole(user.getRoleId());
			return new UserInfo(user.getUsername(), user.getEmail(), user.getPassword(), role);
		}
		return null;
	}

	public User GetUserByEmail(String email) {
		if (userDAO.IsExistUserByEmail(email)) {
			User user = userDAO.GetUserByEmail(email);
			user.setPassword(null);
			return user;
		}
		return null;
	}
	
	public UserInfo GetUserInfoByEmail(String email) {
		if (userDAO.IsExistUserByEmail(email)) {
			User user = userDAO.GetUserByEmail(email);

			Role role = roleDAO.GetRole(user.getRoleId());
			return new UserInfo(user.getUsername(), user.getEmail(), user.getPassword(), role);
		}
		return null;
	}

	public boolean Login(UserLogin userLogin) {
		if (userDAO.IsExistUserByUserName(userLogin.getUsername())) {
			User user = userDAO.GetUser(userLogin.getUsername());
			if (BCrypt.checkpw(userLogin.getPassword(), user.getPassword()))
				return true;

			return false;
		}
		return false;
	}

	public boolean Register(UserRegister userRegister) {
		if(userDAO.IsExistUserByUserName(userRegister.getUsername()) || userDAO.IsExistUserByEmail(userRegister.getEmail()))
			return false;

		String passwordHashed = BCrypt.hashpw(userRegister.getPassword(), BCrypt.gensalt(12));

		Role role = null;
		if (roleDAO.IsExistRoleByName("User"))
			role = roleDAO.GetRoleByName("User");

		if (role == null)
			return false;

		User user = new User(userRegister.getUsername(), userRegister.getEmail(), passwordHashed, role.getID());
		return userDAO.CreateUser(user);
	}

	public boolean DeleteUser(String username) {
		if (userDAO.IsExistUserByUserName(username))
			return userDAO.DeleteUser(username);
		return false;
	}

}
