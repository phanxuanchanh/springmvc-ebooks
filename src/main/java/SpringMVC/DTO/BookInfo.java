package SpringMVC.DTO;

import java.util.List;

import SpringMVC.Entity.Category;
import SpringMVC.Entity.PublishingHouse;

public class BookInfo {
	private long ID;
	private String name;
	private String description;
	private Category category;
	private PublishingHouse publishingHouse;
	private List<BookAuthorInfo> bookAuthorInfos;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public PublishingHouse getPublishingHouse() {
		return publishingHouse;
	}

	public void setPublishingHouse(PublishingHouse publishingHouse) {
		this.publishingHouse = publishingHouse;
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

	public List<BookAuthorInfo> getBookAuthorInfos() {
		return bookAuthorInfos;
	}

	public void setBookAuthorInfos(List<BookAuthorInfo> bookAuthorInfos) {
		this.bookAuthorInfos = bookAuthorInfos;
	}

	public BookInfo(long iD, String name, String description, Category category, PublishingHouse publishingHouse,
			List<BookAuthorInfo> bookAuthorInfos, long views, long upvote, long downvote, String pdf, String img) {
		super();
		ID = iD;
		this.name = name;
		this.description = description;
		this.category = category;
		this.publishingHouse = publishingHouse;
		this.bookAuthorInfos = bookAuthorInfos;
		this.views = views;
		this.upvote = upvote;
		this.downvote = downvote;
		this.pdf = pdf;
		this.img = img;
	}

	public BookInfo() {
		super();
	}
}
