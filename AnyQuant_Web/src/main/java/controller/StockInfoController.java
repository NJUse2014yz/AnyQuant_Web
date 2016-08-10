package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * 单支股票页面
 * @author 周聪
 */
@Controller
public class StockInfoController {
	@RequestMapping("/stockInfo")
	public ModelAndView stockInfo(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("data/stockInfo");
		return modelAndView;
	}
	
	
}
