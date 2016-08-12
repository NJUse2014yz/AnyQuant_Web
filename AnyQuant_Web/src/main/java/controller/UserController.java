package controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import service.UserService;
import tool.CookieHelper;

@Controller
public class UserController {
	@Autowired
	public UserService userService;
	
	
	/**
	 * 进入登录界面
	 * 2016年8月12日
	 */
	@RequestMapping("/askForLogin")
	public ModelAndView askForLogin(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("user/login");

		return modelAndView;
	}

	/**
	 * 验证用户密码是否正确
	 * 2016年8月12日
	 */
	@RequestMapping("/verifyPassword")
	public @ResponseBody Boolean verifyPassword(String userName, String password) {

		boolean isValid = true;
		
		return isValid;
	}
	
	/**
	 * 验证用户名是否存在
	 */
	@RequestMapping("/isUserNameExists")
	public @ResponseBody Boolean isUserNameExists(String userName){
		boolean isExists = true;
		System.out.println("userName:"+userName);
		return isExists;
	}
	
	/**
	 * 登录
	 * 保存用户登录状态，跳转到首页
	 * 2016年8月12日
	 */
	@RequestMapping("/login")
	public ModelAndView login(String userName, String password,HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();

		boolean isValid = true;
		
		if (isValid) {
			CookieHelper.addCookie(CookieHelper.USER_NAME, userName, response, request);
		}
		
		modelAndView.setViewName("main/index");
		return modelAndView;
	}
	
	@RequestMapping("/register")
	public ModelAndView register(String userName,String password,String qq,String email,String mobile) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("user/login");
		return modelAndView;
	}
	
	
	
	/**
	 * 注销登录，删除username cookie
	 * 2016年6月1日
	 */
	@RequestMapping("/logout")
	public @ResponseBody void logout(HttpServletRequest request,HttpServletResponse response){
		CookieHelper.deleteCookie(CookieHelper.USER_NAME, request, response);
	}
}
