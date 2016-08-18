package service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mapper.FunctionMapper;
import mapper.StrategyMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import data.impl.DataServiceImpl;
import po.StockInf;
import po.Strategy;
import service.impl.StrategyServiceImpl;
import tool.JsonExchangeTool;
import vo.Flag;
import vo.StrategyVO;
import function.Function;
import function.FunctionResult;
import function.ResultType;
import function.choose.ChooseStock;
import function.choose.PairFunction;
import function.choose.PairVO;
import function.flag.TrendFunction;
import function.flag.TrendVO;
import function.order.ShareFunction;

public class StrategyServiceTest {
	public static ApplicationContext applicationContext1 =new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
	public static FunctionMapper functionMapper=(FunctionMapper) applicationContext1.getBean("functionMapper");
	public static StrategyMapper strategyMapper=(StrategyMapper) applicationContext1.getBean("strategyMapper");
	public static StrategyService instance=new StrategyServiceImpl(strategyMapper,functionMapper);
	
	public static void makeStrategy()
	{
		String siid="sh600004";
		
		//userName
		String userName="u1";
		String createrName="u1";
		//strategyName
		String strategyName="s1";
		//choose
		int num=1;
		PairVO pairVO=new PairVO(siid,num);
		PairFunction pair=new PairFunction(pairVO);

		List<List<Function>> choose=new ArrayList<List<Function>>();
		choose.add(new ArrayList<Function>());
		choose.get(0).add(pair);
		//chooseStock
		StockInf stockInf=null;
		try {
			stockInf = new DataServiceImpl().getStockInf_sid(siid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String partner=stockInf.getPartner1();
		List<ChooseStock> stockList=new ArrayList<ChooseStock>();
		stockList.add(new ChooseStock(siid,0.505));
		stockList.add(new ChooseStock(partner,0.495));
		//flag
		String attribute="close";
		Date start=new Date(2015-1900,0,1);
		Date end=new Date(Calendar.getInstance().getTimeInMillis());
		Double standard=0.5;
		FunctionResult upFRI=new FunctionResult();
		upFRI.location.add(ResultType.DOUBLELIST);
		upFRI.rD=0.5;
		FunctionResult downFRI=new FunctionResult();
		downFRI.location.add(ResultType.DOUBLELIST);
		downFRI.rD=0.2;
		FunctionResult upFRO=new FunctionResult();
		upFRO.location.add(ResultType.DOUBLELIST);
		upFRO.rD=-0.2;
		FunctionResult downFRO=new FunctionResult();
		downFRO.location.add(ResultType.DOUBLELIST);
		downFRO.rD=-0.5;
		TrendVO trendVO=new TrendVO(upFRI,downFRI,upFRO,downFRO,siid,attribute,start.getTime(),end.getTime(),standard);
		TrendFunction trend=new TrendFunction(trendVO);
		List<List<Function>> flag=new ArrayList<List<Function>>();
		flag.add(new ArrayList<Function>());
		flag.get(0).add(trend);
		ShareFunction share=new ShareFunction();
		List<Flag> flags=new ArrayList<Flag>();
		flags.add(new Flag(share,flag));
		StrategyVO strategy=new StrategyVO(userName,createrName,strategyName,stockList,choose,flags,null);
		
		instance.makeStrategy(strategy);
	}
	public static void getStrategy()
	{
		StrategyVO strategy=instance.getSingleStrategy("u1","u1","s1");
		String userName=strategy.userName;
		String createrName=strategy.createrName;
		String strategyName=strategy.strategyName;
		List<ChooseStock> stockList=strategy.stockList;
		List<Function> choose=strategy.choose.get(0);
		List<Flag> flag=strategy.flags;
		System.out.println(userName);
		System.out.println(createrName);
		System.out.println(strategyName);
		System.out.println(stockList);
		System.out.println(choose);
		System.out.println(flag);
		System.out.println(strategy.realTest);
	}
	public static void getSelfStrategy()
	{
		List<StrategyVO> selfStrategyList=instance.getSelfStrategy("u1");
		for(int i=0;i<selfStrategyList.size();i++)
		{
			String userName=selfStrategyList.get(i).userName;
			String createrName=selfStrategyList.get(i).createrName;
			String strategyName=selfStrategyList.get(i).strategyName;
			List<ChooseStock> stockList=selfStrategyList.get(i).stockList;
			List<Function> choose=selfStrategyList.get(i).choose.get(0);
			List<Flag> flag=selfStrategyList.get(i).flags;
			System.out.println(userName);
			System.out.println(createrName);
			System.out.println(strategyName);
			System.out.println(stockList);
			System.out.println(choose);
			System.out.println(flag);
		}
	}
	public static void getSaveStrategy()
	{
		List<StrategyVO> saveStrategyList=instance.getSaveStrategy("u2");
		for(int i=0;i<saveStrategyList.size();i++)
		{
			String userName=saveStrategyList.get(i).userName;
			String createrName=saveStrategyList.get(i).createrName;
			String strategyName=saveStrategyList.get(i).strategyName;
			List<ChooseStock> stockList=saveStrategyList.get(i).stockList;
			List<Function> choose=saveStrategyList.get(i).choose.get(0);
			List<Flag> flag=saveStrategyList.get(i).flags;
			System.out.println(userName);
			System.out.println(createrName);
			System.out.println(strategyName);
			System.out.println(stockList);
			System.out.println(choose);
			System.out.println(flag);
		}
	}
	public static void main(String[] args)
	{
		StrategyServiceTest.makeStrategy();
//		StrategyServiceTest.getStrategy();
//		StrategyServiceTest.getSelfStrategy();
//		StrategyServiceTest.getSaveStrategy();
	}
}
