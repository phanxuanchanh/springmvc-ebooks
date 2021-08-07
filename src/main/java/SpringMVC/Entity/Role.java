package SpringMVC.Entity;

public class Role {
	private int ID;
	private String name;
	
	public Role(int id, String name) {
		super();
		ID = id;
		this.name = name;
	}

	public Role() {
		super();
	}

	public int getID() {
		return ID;
	}

	public void setID(int id) {
		ID = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
