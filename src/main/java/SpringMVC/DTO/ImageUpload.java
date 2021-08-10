package SpringMVC.DTO;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ImageUpload extends FileUpload {

	public ImageUpload() {
		super();
	}

	public ImageUpload(long bookId, CommonsMultipartFile commonsMultipartFile) {
		super(bookId, commonsMultipartFile);
	}

}
