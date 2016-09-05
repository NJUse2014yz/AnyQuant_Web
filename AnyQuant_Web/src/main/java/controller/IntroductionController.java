
package controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import po.FunctionDisRnk;
import service.StrategyService;
import service.UserService;
import tool.CookieHelper;
import vo.UserInfVO;

/**
 * 学习区
 * @author 周聪
 * 2016年8月30日
 */
@Controller
public class IntroductionController {
	
	@Autowired
	private StrategyService service;
	
	@Autowired
	private UserService userService;
	
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
	 * 获取指标名称列表
	 * 2016年9月2日
	 */
	@RequestMapping("getQuotas")
	public @ResponseBody List<String> getQuotas(HttpServletRequest request){
		int rank=getUserRank(request);
		List<FunctionDisRnk> list=service.getRankQuotas(rank);
		List<String> names=getNames(list);
		return names;
	}
	
	/**
	 * 根据指标名称获得详细描述
	 */
	@RequestMapping("/getQuotaDetail")
	public ModelAndView getQuotaDetail(String name){
		ModelAndView modelAndView=new ModelAndView();
		FunctionDisRnk object=service.getQuotaDisRnk(name);
		setModel(modelAndView, object, name);
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
	 * 获取工具名称列表
	 * 2016年9月2日
	 */
	@RequestMapping("getFunctions")
	public @ResponseBody List<String> getFunctions(HttpServletRequest request){
		int rank=getUserRank(request);
		List<FunctionDisRnk> list=service.getRankFunctions(rank);
		List<String> names=getNames(list);
		return names;
	}
	
	/**
	 * 根据工具名称获得详细描述
	 */
	@RequestMapping("/getFunctionDetail")
	public ModelAndView getFunctionDetail(String name){
		ModelAndView modelAndView=new ModelAndView();
		FunctionDisRnk object=service.getFunctionDisRnk(name);
		setModel(modelAndView, object, name);
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
	 * 获取策略名称列表
	 * 2016年9月2日
	 */
	@RequestMapping("getStrategys")
	public @ResponseBody List<String> getStrategys(HttpServletRequest request){
		int rank=getUserRank(request);
		List<FunctionDisRnk> list=service.getRankStrategys(rank);
		List<String> names=getNames(list);
		return names;
	}
	
	
	
	/**
	 * 根据策略名称获得详细描述
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/getStrategyDetail")
	public ModelAndView getStrategyDetail(String name) throws UnsupportedEncodingException{
		ModelAndView modelAndView=new ModelAndView();
		name=URLDecoder.decode(name,"UTF-8");
		FunctionDisRnk object=service.getStrategyDisRnk(name);
		setModel(modelAndView, object, name);
		return modelAndView;
	}
	
	/**
	 * 将详细描述添加到modelAndView中
	 * 2016年9月2日
	 */
	private void setModel(ModelAndView modelAndView,FunctionDisRnk object,String name){
		String detail=object.discription;
		modelAndView.addObject("detail", detail);
		modelAndView.addObject("name", name);
		modelAndView.setViewName("introduction/Detail");
	}
	
	/**
	 * 获取当前用户的等级
	 * 未登录为0级
	 * 2016年9月2日
	 */
	private int getUserRank(HttpServletRequest request){
		String userName=CookieHelper.getCookie(request, CookieHelper.USER_NAME);
		if(userName==null||userName==" "||userName.length()==0)
			return 0;
		System.out.println(userName);
		UserInfVO vo=userService.queryUser(userName);
		return vo.rank;
	}
	
	/**
	 * 从对象functiondiskrank中获取名字
	 * 2016年9月2日
	 */
	private List<String> getNames(List<FunctionDisRnk> objects){
		List<String> names=new ArrayList<>();
		
		for(FunctionDisRnk object:objects){
			names.add(object.name);
		}
		return names;
	}
}
