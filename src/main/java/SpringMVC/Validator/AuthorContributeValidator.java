package SpringMVC.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import SpringMVC.Entity.AuthorContribute;

public class AuthorContributeValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return clazz.equals(AuthorContribute.class);
	}

	public void validate(Object target, Errors errors) {
		AuthorContribute authorContribute = (AuthorContribute) target;
		if(authorContribute.getBookAuthorId() <= 0)
			errors.rejectValue("bookAuthorId", "", "Tác giả không hợp lệ");
		
		if (authorContribute.getRole().trim().length() == 0)
			errors.rejectValue("role", "", "Tên vai trò không được rỗng");

		if (authorContribute.getRole().length() < 3 || authorContribute.getRole().length() > 50)
			errors.rejectValue("role", "", "Tên vai trò phải có độ dài lớn hơn 3 và nhỏ hơn 50 ký tự");
	}
}
