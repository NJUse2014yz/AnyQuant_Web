package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller

public class StrategyController {
	@RequestMapping("/addStrategy")
	public String addStrategy(){
		return "strategy/AddStrategy";	
	}
	@RequestMapping("/myStrategy")
	public String myStrategy(){
		return "strategy/MyStrategy";	
	}
	@RequestMapping("/publicStrategy")
	public String publicStrategy(){
		return "strategy/PublicStrategy";	
	}
	@RequestMapping("/strategy")
	public String strategy(String sname){
		return "strategy/Strategy";	
	}
	@RequestMapping("/strategyCompare")
	public String strategyCompare(String s1,String s2){
		return "strategy/StrategyCompare";	
	}
}
