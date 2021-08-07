package SpringMVC.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import SpringMVC.DTO.UserLogin;

public class UserLoginValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return clazz.equals(UserLogin.class);
	}

	public void validate(Object target, Errors errors) {
		UserLogin userLogin = (UserLogin) target;
		if (userLogin.getUsername().trim().length() == 0)
			errors.rejectValue("username", "", "Tên người dùng không được rỗng");

		if (userLogin.getUsername().length() < 3 || userLogin.getUsername().length() > 50)
			errors.rejectValue("username", "", "Tên người dùng phải có độ dài lớn hơn 3 và nhỏ hơn 50 ký tự");

		if (userLogin.getPassword().trim().length() == 0)
			errors.rejectValue("password", "", "Mật khẩu không được rỗng");

		if (userLogin.getPassword().length() < 8 || userLogin.getUsername().length() > 100)
			errors.rejectValue("password", "", "Mật khẩu phải có độ dài lớn hơn 8 và nhỏ hơn 100 ký tự");
	}

}
