package SpringMVC.Entity;

public class Role {
	private String ID;
	private String name;
	
	public Role(String iD, String name) {
		super();
		ID = iD;
		this.name = name;
	}

	public Role() {
		super();
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
