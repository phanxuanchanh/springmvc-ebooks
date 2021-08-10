package SpringMVC.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import SpringMVC.DTO.PdfUpload;

public class PdfUploadValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return clazz.equals(PdfUpload.class);
	}

	public void validate(Object target, Errors errors) {
		PdfUpload pdfUpload = (PdfUpload)target;
		if (pdfUpload.getCommonsMultipartFile().getSize() == 0)
			errors.rejectValue("commonsMultipartFile", "", "Tập tin PDF rỗng");

		if (!pdfUpload.getCommonsMultipartFile().getContentType().equals("application/pdf"))
			errors.rejectValue("commonsMultipartFile", "", "Định dạng PDF không hợp lệ");
	}
}
