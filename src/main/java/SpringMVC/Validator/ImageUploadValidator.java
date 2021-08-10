package SpringMVC.Validator;

import java.util.Arrays;
import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import SpringMVC.DTO.ImageUpload;

public class ImageUploadValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return clazz.equals(ImageUpload.class);
	}

	public void validate(Object target, Errors errors) {
		ImageUpload imageUpload = (ImageUpload) target;
		if (imageUpload.getCommonsMultipartFile().getSize() == 0)
			errors.rejectValue("commonsMultipartFile", "", "Tập tin hình ảnh rỗng");

		List<String> mediaTypes = Arrays.asList(new String[] { "image/png", "image/jpeg" });
		if (!mediaTypes.contains(imageUpload.getCommonsMultipartFile().getContentType()))
			errors.rejectValue("commonsMultipartFile", "", "Định dạng hình ảnh không hợp lệ, chỉ hỗ trợ JPEG và PNG");
	}

}
