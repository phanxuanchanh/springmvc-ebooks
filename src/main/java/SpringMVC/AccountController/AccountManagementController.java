package SpringMVC.AccountController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import SpringMVC.DTO.UserLogin;
import SpringMVC.DTO.UserRegister;
import SpringMVC.Service.UserServiceImpl;
import SpringMVC.Validator.UserLoginValidator;
import SpringMVC.Validator.UserRegisterValidator;

@Controller
public class AccountManagementController {
	@Autowired
	private UserServiceImpl userServiceImpl;

	@RequestMapping(value = "tai-khoan/dang-nhap", method = RequestMethod.GET)
	public ModelAndView Login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("account/login");
		modelAndView.addObject("userLogin", new UserLogin());
		return modelAndView;
	}

	@RequestMapping(value = "tai-khoan/dang-nhap", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public ModelAndView Login(@ModelAttribute("userLogin") UserLogin userLogin, BindingResult bindingResult, UserLoginValidator userLoginValidator) {
		userLoginValidator.validate(userLogin, bindingResult);
		if(bindingResult.hasErrors())
			return new ModelAndView("account/login", "userLogin", userLogin);
		
		if(userServiceImpl.Login(userLogin))
			return new ModelAndView("redirect:/");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("account/login");
		modelAndView.addObject("userLogin", new UserLogin());
		modelAndView.addObject("state", "Đăng nhập không thành công, có thể dữ liệu không hợp lệ hoặc chưa tồn tại tài khoản này");
		return modelAndView;
	}
	
	@RequestMapping(value = "tai-khoan/dang-ky", method = RequestMethod.GET)
	public ModelAndView Register() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("account/register");
		modelAndView.addObject("userRegister", new UserRegister());
		return modelAndView;
	}
	
	@RequestMapping(value = "tai-khoan/dang-ky", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public ModelAndView Login(@ModelAttribute("userLogin") UserRegister userRegister, BindingResult bindingResult, UserRegisterValidator userRegisterValidator) {
		userRegisterValidator.validate(userRegister, bindingResult);
		if(bindingResult.hasErrors())
			return new ModelAndView("account/register", "userRegister", userRegister);
		
		if(userServiceImpl.Register(userRegister))
			return new ModelAndView("redirect:/tai-khoan/dang-nhap");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("account/register");
		modelAndView.addObject("userRegister", new UserRegister());
		modelAndView.addObject("state", "Đăng ký không thành công, có thể dữ liệu không hợp lệ hoặc đã tồn tại tài khoản này");
		return modelAndView;
	}
}
