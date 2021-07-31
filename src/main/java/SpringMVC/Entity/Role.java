package SpringMVC.Entity;

public class Role {
	private int Id;
	private String name;
	
	public Role(int id, String name) {
		super();
		Id = id;
		this.name = name;
	}

	public Role() {
		super();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
