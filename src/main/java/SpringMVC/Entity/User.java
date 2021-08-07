package SpringMVC.Entity;

public class User {
	private String username;
	private String email;
	private String password;
	private int roleId;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public User() {
		super();
	}

	public User(String username, String email, String password, int roleId) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.roleId = roleId;
	}
}
