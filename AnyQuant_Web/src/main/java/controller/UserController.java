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
	@RequestMapping("/askForLogin")
	public ModelAndView askForLogin(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("user/login");

		String userName = CookieHelper.getCookie(request, CookieHelper.USER_NAME);
		
		modelAndView.addObject(CookieHelper.USER_NAME, userName);
		

		return modelAndView;
	}

	@RequestMapping("/login")
	public ModelAndView login(String userName, String password, String rememberMe, HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();

		boolean isValid = true;
		CookieHelper.addCookie(CookieHelper.USER_NAME, userName, response, request);
		if (isValid) {
			if (rememberMe != null) {
				// 重新登录并且要求保存密码
				CookieHelper.addCookie(CookieHelper.PASSWORD, password, response, request);

			} else {
				// 重新登录并且要求不保存密码
				CookieHelper.deleteCookie(CookieHelper.PASSWORD, request, response);
			}

			// TODO 返回首页
			modelAndView.setViewName("main/index");
			return modelAndView;
		}

		// 用户名不正确
		modelAndView.setViewName("user/login");
		modelAndView.addObject("loginResult", "fail");

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
