package SpringMVC.DTO;

public class BookAuthorInfo {
	private long ID;
	private String name;
	private String description;
	private String email;
	private String address;
	private String roleName;

	public long getID() {
		return ID;
	}

	public void setID(long id) {
		ID = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public BookAuthorInfo(long iD, String name, String description, String email, String address, String roleName) {
		super();
		ID = iD;
		this.name = name;
		this.description = description;
		this.email = email;
		this.address = address;
		this.roleName = roleName;
	}

	public BookAuthorInfo() {
		super();
	}

}
