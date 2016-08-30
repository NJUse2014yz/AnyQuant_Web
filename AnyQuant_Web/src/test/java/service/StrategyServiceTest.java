package service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import backtest.TestReport;
import mapper.FunctionMapper;
import mapper.QuotaInfMapper;
import mapper.StrategyInfMapper;
import mapper.StrategyMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import data.impl.DataServiceImpl;
import po.StockInf;
import po.Strategy;
import service.impl.BackTestServiceImpl;
import service.impl.StrategyServiceImpl;
import tool.JsonExchangeTool;
import vo.Flag;
import vo.RealTestVO;
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
import function.risk.StandardPercentFunction;
import function.risk.StandardPercentVO;

public class StrategyServiceTest {
	public static ApplicationContext applicationContext1 =new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
	public static FunctionMapper functionMapper=(FunctionMapper) applicationContext1.getBean("functionMapper");
	public static StrategyMapper strategyMapper=(StrategyMapper) applicationContext1.getBean("strategyMapper");
	public static StrategyInfMapper strategyInfMapper=(StrategyInfMapper) applicationContext1.getBean("strategyInfMapper");
	public static QuotaInfMapper quotaInfMapper=(QuotaInfMapper) applicationContext1.getBean("quotaInfMapper");
	public static StrategyService instance=new StrategyServiceImpl(strategyMapper,functionMapper,strategyInfMapper,quotaInfMapper);
	
	public static void makeStrategy()
	{
		String siid="sh600004";
		
		//userName
		String userName="u3";
		String createrName="u3";
		//strategyName
		String strategyName="s3";
		//choose
//		int num=1;
//		PairVO pairVO=new PairVO(siid,num);
//		PairFunction pair=new PairFunction(pairVO);

		List<List<Function>> choose=new ArrayList<List<Function>>();
		choose.add(new ArrayList<Function>());
//		choose.get(0).add(pair);
		//chooseStock
		StockInf stockInf=null;
		try {
			stockInf = new DataServiceImpl().getStockInf_sid(siid);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		String partner=stockInf.getPartner1();
		List<ChooseStock> stockList=new ArrayList<ChooseStock>();
		stockList.add(new ChooseStock(siid,1));
//		stockList.add(new ChooseStock(siid,0.505));
//		stockList.add(new ChooseStock(partner,0.495));
		//risk
		StandardPercentVO spvo=new StandardPercentVO();
		spvo.setAttribute("close");
		spvo.setStandard("m20");
		spvo.setPercent(0.8);
		spvo.setSign(-1);
		Function StandardPercentFunction=new StandardPercentFunction(spvo);
		FunctionResult upFRI=new FunctionResult();
		upFRI.location.add(ResultType.BOOLEAN);
		upFRI.rB=true;
		FunctionResult downFRI=new FunctionResult();
		downFRI.location.add(ResultType.BOOLEAN);
		downFRI.rB=true;
		FunctionResult upFRO=new FunctionResult();
		upFRO.location.add(ResultType.BOOLEAN);
		upFRO.rB=true;
		FunctionResult downFRO=new FunctionResult();
		downFRO.location.add(ResultType.BOOLEAN);
		downFRO.rB=true;
		StandardPercentFunction.setResultDownI(downFRI);
		StandardPercentFunction.setResultDownO(downFRO);
		StandardPercentFunction.setResultUpI(upFRI);
		StandardPercentFunction.setResultUpO(upFRO);
		List<List<Function>> risk=new ArrayList<List<Function>>();
		risk.add(new ArrayList<Function>());
		risk.get(0).add(StandardPercentFunction);
		//flag1
		String attribute1="m10";
		String attribute2="m5";
		int day1=30;
		Double standard1=0.5;
		FunctionResult upFRI1=new FunctionResult();
		upFRI1.location.add(ResultType.DOUBLELIST);
		upFRI1.rD=0.5;
		FunctionResult downFRI1=new FunctionResult();
		downFRI1.location.add(ResultType.DOUBLELIST);
		downFRI1.rD=0.2;
		FunctionResult upFRO1=new FunctionResult();
		upFRO1.location.add(ResultType.DOUBLELIST);
		upFRO1.rD=-0.2;
		FunctionResult downFRO1=new FunctionResult();
		downFRO1.location.add(ResultType.DOUBLELIST);
		downFRO1.rD=-0.5;
		TrendVO trendVO=new TrendVO(upFRI1,downFRI1,upFRO1,downFRO1,siid,attribute1,day1,standard1);
		TrendFunction trend=new TrendFunction(trendVO);
		//flag2
		
		List<List<Function>> flag=new ArrayList<List<Function>>();
		flag.add(new ArrayList<Function>());
		flag.get(0).add(trend);
		ShareFunction share=new ShareFunction();
		share.siid="sh600004";
		share.share=10;
		List<Flag> flags=new ArrayList<Flag>();
		flags.add(new Flag(share,flag));
		StrategyVO strategy=new StrategyVO(userName,createrName,strategyName,stockList,choose,risk,flags,null,null,0);
		
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
		List<List<Function>> risk=strategy.risk;
		List<Flag> flag=strategy.flags;
		System.out.println(userName);
		System.out.println(createrName);
		System.out.println(strategyName);
		System.out.println(stockList);
		System.out.println(choose);
		System.out.println(risk);
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
		List<StrategyVO> saveStrategyList=instance.getSaveStrategy("u1");
		for(int i=0;i<saveStrategyList.size();i++)
		{
			String userName=saveStrategyList.get(i).userName;
			String createrName=saveStrategyList.get(i).createrName;
			String strategyName=saveStrategyList.get(i).strategyName;
			List<ChooseStock> stockList=saveStrategyList.get(i).stockList;
			List<List<Function>> choose=saveStrategyList.get(i).choose;
			List<Flag> flag=saveStrategyList.get(i).flags;
			List<List<Function>> risk=saveStrategyList.get(i).risk;
			TestReport report=saveStrategyList.get(i).report;
			RealTestVO realTest=saveStrategyList.get(i).realTest;
			double score=saveStrategyList.get(i).score;
			System.out.println(userName);
			System.out.println(createrName);
			System.out.println(strategyName);
			System.out.println(stockList);
			System.out.println(choose);
			System.out.println(flag);
			System.out.println(risk);
			System.out.println(report);
			System.out.println(realTest);
			System.out.println(score);
		}
	}
	public static void getFunction()
	{
		System.out.println(instance.getFunctionDisRnk("Trend"));
		System.out.println(instance.getQuotaDisRnk("m5"));
		System.out.println(instance.getStrategyDisRnk("五日金叉策略"));
	}
	public static void deleteStrategy()
	{
		instance.deleteStrategy("u1","u1","s1");
	}
	public static void saveReport()
	{
		BackTestService backTest=new BackTestServiceImpl(strategyMapper);
		StrategyVO vo=new StrategyServiceImpl(strategyMapper).getSingleStrategy("u1","u1", "s1");
		TestReport report=null;
		try {
			report = backTest.backtest(vo.stockList, vo.flags, 1, vo.flags.get(0), vo.risk);
		} catch (Exception e) {
			e.printStackTrace();
		}
		backTest.saveBackTest("u1", "u1", "s1", report);
		System.out.println(report);
	}
	public static void saveStrategy()
	{
		instance.saveStrategy("u1","u3","s3");
	}
	public static void main(String[] args)
	{
//		StrategyServiceTest.deleteStrategy();
//		StrategyServiceTest.makeStrategy();
		StrategyServiceTest.getSaveStrategy();
//		new RealTestServiceTest().initRealTest();
//		new RealTestServiceTest().saveRealTest();
//		StrategyServiceTest.saveReport();
//		System.out.println(new StrategyServiceImpl(strategyMapper).getScore("u1","u1","s1"));
		
//		StrategyServiceTest.getStrategy();
//		StrategyServiceTest.getSelfStrategy();
//		StrategyServiceTest.getSaveStrategy();
//		new StrategyServiceTest().getFunction();
	}
}
