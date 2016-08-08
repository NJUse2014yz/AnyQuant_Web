package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.UserService;

@Controller
public class UserController {
	@Autowired
	public UserService userService;
	@RequestMapping("signUp")			 //    _   _
	public void signUp() throws Exception//测试用@(I)@
	{
		userService.addUser("test2", "000");
	}
}
