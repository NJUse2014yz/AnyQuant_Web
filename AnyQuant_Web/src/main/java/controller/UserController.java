package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	
	@RequestMapping("/profile")
	public ModelAndView profile(){
		ModelAndView modelAndView = new ModelAndView();
		
		
		return modelAndView;
	}
	
}
