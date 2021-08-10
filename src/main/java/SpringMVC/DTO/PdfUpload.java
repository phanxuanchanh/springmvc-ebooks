package SpringMVC.DTO;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class PdfUpload extends FileUpload {

	public PdfUpload() {
		super();
	}

	public PdfUpload(long bookId, CommonsMultipartFile commonsMultipartFile) {
		super(bookId, commonsMultipartFile);
	}

}
