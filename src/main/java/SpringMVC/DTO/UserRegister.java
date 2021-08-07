package SpringMVC.DTO;

public class UserRegister extends UserLogin {
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRegister(String username, String password, String email) {
		super(username, password);
		this.email = email;
	}

	public UserRegister() {
		super();
	}
}
