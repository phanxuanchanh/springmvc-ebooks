package SpringMVC.Entity;

public class Category {
	private int ID;
	private String name;
	private String description;

	public Category(int id, String name, String description) {
		super();
		ID = id;
		this.name = name;
		this.description = description;
	}

	public Category() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
