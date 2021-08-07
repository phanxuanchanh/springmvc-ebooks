package SpringMVC.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import SpringMVC.DTO.UserRegister;

public class UserRegisterValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return clazz.equals(UserRegister.class);
	}

	public void validate(Object target, Errors errors) {
		UserRegister userRegister = (UserRegister) target;
		if (userRegister.getUsername().trim().length() == 0)
			errors.rejectValue("username", "", "Tên người dùng không được rỗng");

		if (userRegister.getUsername().length() < 3 || userRegister.getUsername().length() > 50)
			errors.rejectValue("username", "", "Tên người dùng phải có độ dài lớn hơn 3 và nhỏ hơn 50 ký tự");

		if (userRegister.getEmail().trim().length() == 0)
			errors.rejectValue("username", "", "Email không được rỗng");

		if (userRegister.getEmail().length() > 50)
			errors.rejectValue("username", "", "Email phải có độ dài lớn nhỏ hơn 50 ký tự");

		if (userRegister.getPassword().trim().length() == 0)
			errors.rejectValue("password", "", "Mật khẩu không được rỗng");

		if (userRegister.getPassword().length() < 8 || userRegister.getUsername().length() > 100)
			errors.rejectValue("password", "", "Mật khẩu phải có độ dài lớn hơn 8 và nhỏ hơn 100 ký tự");
	}

}
