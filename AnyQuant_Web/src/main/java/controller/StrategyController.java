package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller

public class StrategyController {
	@RequestMapping("/addStrategy")
	public String addStrategy(){
		return "strategy/AddStrategy";	
	}
}
