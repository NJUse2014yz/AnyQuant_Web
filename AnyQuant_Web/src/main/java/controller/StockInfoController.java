package controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import common.Ktype;
import service.StockDataService;
import tool.CookieHelper;
import vo.KgraInf;
import vo.LinegraInf;
import vo.StockListInf;



/**
 * 单支股票页面
 * @author 周聪
 * 2016年5月22日
 */
@Controller
public class StockInfoController {
	
	@Autowired
	private StockDataService stockBl;
	
//	@Autowired
//	private PairStrategyService pairBl;
	
	/**
	 * 进入股票界面
	 * 2016年5月22日
	 * @throws Exception 
	 */
	@RequestMapping("/stockInfo")
	public ModelAndView stockInfo(String id,HttpServletRequest request) throws Exception{
		System.out.println("stockId:"+id);
		ModelAndView modelAndView=new ModelAndView();
		String userName=CookieHelper.getCookie(request, CookieHelper.USER_NAME);
		if(userName.length()==0)
			modelAndView.addObject("isLogin","false");
		else{
			//check islike this stock
		}
		
		//latest stock info
		StockListInf latestInfo=stockBl.showSingleStock(id);
		
		modelAndView.addObject("latestInfo",latestInfo);
		
		if((!id.startsWith("sh000"))&&(!id.startsWith("sz399")))
			modelAndView.addObject("isStock","true");
		
		modelAndView.setViewName("data/StockInf");
		
		return modelAndView;
	}
	
	/**
	 * 获得预测结果
	 * @throws Exception 
	 */
	/*@RequestMapping("/getForecast")
	public @ResponseBody List<StrategyRecInf> getForecast(String id) throws Exception {
		if(id.startsWith("sh000")||id.startsWith("sz399"))
			return null;
		
		List<StrategyRecInf> list=null;
		try{
			list = strategyBl.getRecStrategy(id);
		}catch(DataLackException e){
			return null;
		}
		
		return list;
	}
	
	@RequestMapping("/getPairStock")
	public @ResponseBody StockInf getPairStock(String id) throws Exception{
		List<StockPair> list=pairBl.getSolemate(id);
		if(list.size()==0)
			return null;
		StockPair pair=list.get(0);
		return pair.stock2;
	}*/
	
	/**
	 * 收藏股票
	 */
	@RequestMapping("/likeStock")
	public @ResponseBody void likeStock(String isLike,
			HttpServletRequest request,HttpServletResponse response){
		System.out.println("isLike:"+isLike);
		
		CookieHelper.addCookie(CookieHelper.IS_LIKE, isLike, response, request);
		
		
	}
	
	@RequestMapping("/getLineData")
	public @ResponseBody List<LinegraInf> getLineData(String id) throws Exception{
		List<LinegraInf> lineData=stockBl.getLinegraph(id, null, get30BeforeDay(), getToday());
		for(LinegraInf info:lineData){
			//转换日期格式2016-05-12为20160512
			info.date=info.date.replace("-", "");
		}
		return lineData;
	}
	 
	/**
	 * 获取k线图json数据
	 * 2016年5月22日
	 * @throws Exception 
	 */
	@RequestMapping("/getKLineData")
	public @ResponseBody List<KgraInf> getKLineData(String id) throws Exception{
		List<KgraInf> list=stockBl.getKgraph(id, Ktype.DAILY, "2006-05-06", getToday());
		
		for(KgraInf info:list){
			//转换日期格式2016-05-12为20160512
			info.date=info.date.replace("-", "");
		}
		
		return list;
	}
	
	
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 
	private String getToday(){
		Calendar today=Calendar.getInstance();
		return sdf.format(today.getTime());
	}
	
	private String get30BeforeDay(){
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		return sdf.format(cal.getTime());
	}
	
	
}
