package SpringMVC.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import SpringMVC.Entity.Category;

public class CategoryValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return clazz.equals(Category.class);
	}

	public void validate(Object target, Errors errors) {
		Category category = (Category)target;
		if(category.getName().trim().length() == 0)
			errors.rejectValue("name", "", "Tên thể loại không được rỗng");
		if(category.getName().length() < 3 || category.getName().length() > 50)
			errors.rejectValue("name", "", "Tên thể loại phải có độ dài lớn hơn 3 và nhỏ hơn 50 ký tự");
	}

}
