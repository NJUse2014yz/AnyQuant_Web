
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 学习区
 * @author 周聪
 * 2016年8月30日
 */
@Controller
public class IntroductionController {

	/**
	 * 指标介绍
	 * 2016年8月30日
	 */
	@RequestMapping("/quotaIntroduction")
	public ModelAndView quotaIntroduction(){
		ModelAndView modelAndView=new ModelAndView();
		
		
		modelAndView.setViewName("introduction/QuotaIntroduction");
		return modelAndView;
	}
	
	/**
	 * 工具介绍
	 * 2016年8月30日
	 */
	@RequestMapping("/functionIntroduction")
	public ModelAndView functionIntroduction(){
		ModelAndView modelAndView=new ModelAndView();
		
		
		modelAndView.setViewName("introduction/FunctionIntroduction");
		return modelAndView;
	}
	
	/**
	 * 策略介绍
	 * 2016年8月30日
	 */
	@RequestMapping("/strategyIntroduction")
	public ModelAndView strategyIntroduction(){
		ModelAndView modelAndView=new ModelAndView();
		
		
		modelAndView.setViewName("introduction/StrategyIntroduction");
		return modelAndView;
	}
	
	/**
	 * 根据名称获得详细描述
	 */
	@RequestMapping("/getDetail")
	public ModelAndView getDetail(String name){
		ModelAndView modelAndView=new ModelAndView();
		
		
		return modelAndView;
	}
}
