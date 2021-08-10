package SpringMVC.DTO;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileUpload {
	protected long bookId;
	protected CommonsMultipartFile commonsMultipartFile;

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public CommonsMultipartFile getCommonsMultipartFile() {
		return commonsMultipartFile;
	}

	public void setCommonsMultipartFile(CommonsMultipartFile commonsMultipartFile) {
		this.commonsMultipartFile = commonsMultipartFile;
	}

	public FileUpload(long bookId, CommonsMultipartFile commonsMultipartFile) {
		super();
		this.bookId = bookId;
		this.commonsMultipartFile = commonsMultipartFile;
	}

	public FileUpload() {
		super();
	}
}
