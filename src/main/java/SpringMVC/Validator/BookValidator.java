package SpringMVC.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import SpringMVC.Entity.Book;

public class BookValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return clazz.equals(Book.class);
	}

	public void validate(Object target, Errors errors) {
		Book book = (Book)target;
		if (book.getName().trim().length() == 0)
			errors.rejectValue("name", "", "Tên tác giả không được rỗng");

		if (book.getName().length() < 3 || book.getName().length() > 50)
			errors.rejectValue("name", "", "Tên tác giả phải có độ dài lớn hơn 3 và nhỏ hơn 50 ký tự");
	}

}
