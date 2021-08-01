package SpringMVC.Entity;

public class Book {
	private long ID;
	private String name;
	private String description;
	private int categoryId;
	private long publishingHouseId;
	private long views;
	private long upvote;
	private long downvote;
	private String pdf;
	private String img;

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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public long getPublishingHouseId() {
		return publishingHouseId;
	}

	public void setPublishingHouseId(long publishingHouseId) {
		this.publishingHouseId = publishingHouseId;
	}

	public long getViews() {
		return views;
	}

	public void setViews(long views) {
		this.views = views;
	}

	public long getUpvote() {
		return upvote;
	}

	public void setUpvote(long upvote) {
		this.upvote = upvote;
	}

	public long getDownvote() {
		return downvote;
	}

	public void setDownvote(long downvote) {
		this.downvote = downvote;
	}

	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Book(long id, String name, String description, int categoryId, long publishingHouseId, long views, long upvote,
			long downvote, String pdf, String img) {
		super();
		ID = id;
		this.name = name;
		this.description = description;
		this.categoryId = categoryId;
		this.publishingHouseId = publishingHouseId;
		this.views = views;
		this.upvote = upvote;
		this.downvote = downvote;
		this.pdf = pdf;
		this.img = img;
	}

	public Book() {
		super();
	}

}
