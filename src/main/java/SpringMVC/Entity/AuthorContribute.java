package SpringMVC.Entity;

public class AuthorContribute {
	private long bookAuthorId;
	private long bookId;
	private String role;

	public long getBookAuthorId() {
		return bookAuthorId;
	}

	public void setBookAuthorId(long bookAuthorId) {
		this.bookAuthorId = bookAuthorId;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public AuthorContribute(long bookAuthorId, long bookId, String role) {
		super();
		this.bookAuthorId = bookAuthorId;
		this.bookId = bookId;
		this.role = role;
	}

	public AuthorContribute() {
		super();
	}
}
